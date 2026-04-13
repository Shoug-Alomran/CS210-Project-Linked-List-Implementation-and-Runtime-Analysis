from __future__ import annotations

import gzip
import html
from pathlib import Path
import xml.etree.ElementTree as ET

_EXCLUDED_URLS: set[str] = set()
_NS = {"sm": "http://www.sitemaps.org/schemas/sitemap/0.9"}
ET.register_namespace("", _NS["sm"])

# Serve a small set of backward-compatible aliases for legacy relative URLs
# that were already crawled before the current canonical structure stabilized.
_LEGACY_NESTED_PREFIXES: tuple[str, ...] = (
    "analysis/asymptotic-complexity/",
    "analysis/runtime-measurement/",
    "overview/design-overview/",
    "overview/introduction/",
)

_LEGACY_NESTED_TARGETS: dict[str, str] = {
    "analysis/interpretation/": "analysis/interpretation/",
    "appendix/flowchart/index/": "appendix/flowchart/",
    "appendix/full-code/": "appendix/full-code/",
    "appendix/run-screenshots/": "appendix/run-screenshots/",
    "overview/design-overview/": "overview/design-overview/",
    "report/report.html": "report/report/",
    "teamwork/index/": "teamwork/contributions/",
}

_ROOT_LEGACY_REDIRECTS: dict[str, str] = {
    "appendix/flowchart/index/": "appendix/flowchart/",
    "teamwork/index/": "teamwork/contributions/",
}


def _build_legacy_redirects() -> dict[str, str]:
    redirects = dict(_ROOT_LEGACY_REDIRECTS)
    for prefix in _LEGACY_NESTED_PREFIXES:
        for legacy_suffix, canonical_path in _LEGACY_NESTED_TARGETS.items():
            redirects[prefix + legacy_suffix] = canonical_path
    return redirects


_LEGACY_REDIRECTS = _build_legacy_redirects()


def on_page_markdown(markdown, page, config, files):  # noqa: ANN001
    robots = str(page.meta.get("robots", "")).lower()
    if "noindex" in robots:
        site_url = str(config.site_url).rstrip("/") + "/"
        page_url = str(page.url).lstrip("/")
        _EXCLUDED_URLS.add(site_url + page_url)
    return markdown


def on_post_build(config, **kwargs):  # noqa: ANN001
    sitemap_path = Path(config.site_dir) / "sitemap.xml"
    if sitemap_path.exists():
        tree = ET.parse(sitemap_path)
        root = tree.getroot()

        if _EXCLUDED_URLS:
            for url in list(root.findall("sm:url", _NS)):
                loc = url.find("sm:loc", _NS)
                if loc is not None and loc.text in _EXCLUDED_URLS:
                    root.remove(url)

        try:
            ET.indent(tree, space="    ")
        except AttributeError:
            pass

        tree.write(sitemap_path, encoding="utf-8", xml_declaration=True)

        sitemap_gz_path = sitemap_path.with_suffix(".xml.gz")
        with gzip.open(sitemap_gz_path, "wb") as gz_file:
            gz_file.write(sitemap_path.read_bytes())

    _write_legacy_redirect_pages(config)


def _write_legacy_redirect_pages(config) -> None:  # noqa: ANN001
    site_dir = Path(config.site_dir)
    site_url = str(config.site_url).rstrip("/")

    for legacy_path, canonical_path in _LEGACY_REDIRECTS.items():
        target_url = f"{site_url}/{canonical_path.lstrip('/')}"
        destination = site_dir / legacy_path
        if legacy_path.endswith("/"):
            destination = destination / "index.html"
        destination.parent.mkdir(parents=True, exist_ok=True)
        destination.write_text(_render_redirect_html(target_url), encoding="utf-8")


def _render_redirect_html(target_url: str) -> str:
    safe_url = html.escape(target_url, quote=True)
    return f"""<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex,follow">
    <title>Redirecting…</title>
    <link rel="canonical" href="{safe_url}">
    <meta http-equiv="refresh" content="0; url={safe_url}">
    <script>
      window.location.replace("{safe_url}");
    </script>
  </head>
  <body>
    <p>If you are not redirected automatically, <a href="{safe_url}">open the current page</a>.</p>
  </body>
</html>
"""
