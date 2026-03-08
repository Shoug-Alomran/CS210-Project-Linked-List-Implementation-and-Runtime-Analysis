from __future__ import annotations

import gzip
from pathlib import Path
import xml.etree.ElementTree as ET

_EXCLUDED_URLS: set[str] = set()
_NS = {"sm": "http://www.sitemaps.org/schemas/sitemap/0.9"}
ET.register_namespace("", _NS["sm"])


def on_page_markdown(markdown, page, config, files):  # noqa: ANN001
    robots = str(page.meta.get("robots", "")).lower()
    if "noindex" in robots:
        site_url = str(config.site_url).rstrip("/") + "/"
        page_url = str(page.url).lstrip("/")
        _EXCLUDED_URLS.add(site_url + page_url)
    return markdown


def on_post_build(config, **kwargs):  # noqa: ANN001
    if not _EXCLUDED_URLS:
        return

    sitemap_path = Path(config.site_dir) / "sitemap.xml"
    if not sitemap_path.exists():
        return

    tree = ET.parse(sitemap_path)
    root = tree.getroot()

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
