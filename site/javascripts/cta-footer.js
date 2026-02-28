(function () {
  const EMAIL = "inquiry@shoug-tech.com";
  const MAIN_WEBSITE = "https://shoug-tech.com/";
  const STORAGE_NAV = "ds-nav-collapsed";
  const STORAGE_TOC = "ds-toc-collapsed";

  function getConfigBase() {
    const configEl = document.getElementById("__config");
    if (!configEl || !configEl.textContent) return "";
    try {
      const config = JSON.parse(configEl.textContent);
      return config && typeof config.base === "string" ? config.base : "";
    } catch (e) {
      return "";
    }
  }

  function getSiteRootHref() {
    const selfScript = document.querySelector('script[src*="javascripts/cta-footer.js"]');
    if (selfScript && selfScript.src) {
      return selfScript.src.replace(/javascripts\/cta-footer\.js(?:\?.*)?$/, "");
    }

    const configBase = getConfigBase();
    if (configBase) return new URL(configBase.replace(/\/?$/, "/"), window.location.href).href;

    if (typeof __md_scope !== "undefined" && __md_scope && __md_scope.href) {
      return new URL("./", __md_scope.href).href;
    }

    try {
      if (typeof __md_get === "function") {
        const b = __md_get("__base") || "";
        if (b) return new URL(b.replace(/\/?$/, "/"), window.location.origin).href;
      }
    } catch (e) {}

    return new URL("./", window.location.href).href;
  }

  function url(path) {
    const clean = String(path || "").replace(/^\/+/, "");
    return new URL(clean, getSiteRootHref()).href;
  }

  function getSiteName() {
    const titleEl = document.querySelector(".md-header__title .md-ellipsis");
    return titleEl ? titleEl.textContent.trim() : "Website";
  }

  function addHeaderCTA() {
    const headerInner = document.querySelector(".md-header__inner");
    if (!headerInner) return;
    if (headerInner.querySelector("a.header-cta")) return;

    const cta = document.createElement("a");
    cta.className = "header-cta";
    cta.href = `mailto:${EMAIL}`;
    cta.textContent = "Contact Us";
    cta.setAttribute("aria-label", "Contact Us");
    headerInner.appendChild(cta);
  }

  function addFooterBlock() {
    const footer = document.querySelector(".md-footer");
    if (!footer) return;
    if (footer.querySelector(".custom-footer")) return;

    const meta = footer.querySelector(".md-footer-meta");
    const block = document.createElement("section");
    block.className = "custom-footer";
    const siteName = getSiteName();

    const links = {
      home: url(""),
      // Overview
      overviewIntro: url("overview/introduction/"),
      overviewDesign: url("overview/design-overview/"),
      // Analysis
      analysisAsymptotic: url("analysis/asymptotic-complexity/"),
      analysisRuntime: url("analysis/runtime-measurement/"),
      analysisInterpretation: url("analysis/interpretation/"),
      // Other pages
      teamwork: url("teamwork/contributions/"),
      conclusion: url("conclusion/"),
      references: url("references/"),
      // Report
      reportView: url("report/report/"),
      reportHtml: url("report/report.html"),
      // Appendices (correct folder name)
      appendixFlowchart: url("appendix/flowchart/"),
      appendixCode: url("appendix/full-code/"),
      appendixScreens: url("appendix/run-screenshots/")
    };

    block.innerHTML = `
      <div class="custom-footer__inner">
        <div class="custom-footer__left">
          <div class="custom-footer__brand">${siteName}</div>
          <div class="custom-footer__title">Stay Updated</div>

          <form class="custom-footer__form" action="mailto:${EMAIL}" method="get">
            <input
              class="custom-footer__input"
              type="email"
              name="email"
              placeholder="Email address"
              autocomplete="email"
              required
            >
            <button class="custom-footer__button" type="submit">
              Subscribe
            </button>
          </form>

          <div class="custom-footer__note">
            By submitting your email, you agree to be contacted regarding this website.
          </div>
        </div>

        <div class="custom-footer__right">
          <div class="footer-col">
            <div class="footer-col__title">Overview</div>
            <a class="footer-link" href="${links.home}">Home</a>
            <a class="footer-link" href="${links.overviewIntro}">Introduction</a>
            <a class="footer-link" href="${links.overviewDesign}">System Design Overview</a>
          </div>

          <div class="footer-col">
            <div class="footer-col__title">Analysis</div>
            <a class="footer-link" href="${links.analysisAsymptotic}">Asymptotic Complexity</a>
            <a class="footer-link" href="${links.analysisRuntime}">Runtime Measurement</a>
            <a class="footer-link" href="${links.analysisInterpretation}">Interpretation of Results</a>
          </div>

          <div class="footer-col">
            <div class="footer-col__title">Report</div>
            <a class="footer-link" href="${links.reportView}">View Report</a>
            <a class="footer-link" href="${links.reportHtml}">Full HTML Report</a>
          </div>

          <div class="footer-col">
            <div class="footer-col__title">Appendices</div>
            <a class="footer-link" href="${links.appendixFlowchart}">Flowchart</a>
            <a class="footer-link" href="${links.appendixCode}">Full Source Code</a>
            <a class="footer-link" href="${links.appendixScreens}">Run Screenshots</a>
          </div>
<div class="footer-col">
  <div class="footer-col__title">Website</div>
  <a class="footer-link" href="${MAIN_WEBSITE}" target="_blank" rel="noopener">
    shoug-tech.com
  </a>
</div>
          <div class="footer-col">
            <div class="footer-col__title">More</div>
            <a class="footer-link" href="${links.teamwork}">Teamwork Contribution</a>
            <a class="footer-link" href="${links.conclusion}">Conclusion</a>
            <a class="footer-link" href="${links.references}">References and Resources</a>
            <a class="footer-link" href="mailto:${EMAIL}">${EMAIL}</a>
          </div>
        </div>
      </div>
      <div class="custom-footer__legal">
        © 2026 Shoug Fawaz Alomran · All rights reserved
      </div>
    `;

    if (meta) footer.insertBefore(block, meta);
    else footer.prepend(block);
  }

  function isDesktop() {
    return window.matchMedia("(min-width: 76.25em)").matches;
  }

  function readBool(key) {
    try {
      return window.localStorage.getItem(key) === "1";
    } catch (e) {
      return false;
    }
  }

  function writeBool(key, value) {
    try {
      window.localStorage.setItem(key, value ? "1" : "0");
    } catch (e) {}
  }

  function applySidebarState() {
    const navCollapsed = isDesktop() && readBool(STORAGE_NAV);
    const tocCollapsed = isDesktop() && readBool(STORAGE_TOC);
    document.body.classList.toggle("ds-nav-collapsed", navCollapsed);
    document.body.classList.toggle("ds-toc-collapsed", tocCollapsed);
  }

  function setBtnLabel(btn, collapsed, group) {
    if (!btn) return;
    const labels = group === "nav"
      ? ["Show Navigation", "Hide Navigation"]
      : ["Show Contents", "Hide Contents"];
    btn.textContent = collapsed ? labels[0] : labels[1];
    btn.setAttribute("aria-pressed", collapsed ? "true" : "false");
  }

  function addSidebarToggles() {
    if (!document.body) return;
    applySidebarState();

    let rail = document.querySelector(".ds-toggle-rail");
    if (!rail) {
      rail = document.createElement("div");
      rail.className = "ds-toggle-rail";

      const navBtn = document.createElement("button");
      navBtn.type = "button";
      navBtn.className = "ds-toggle-btn";
      navBtn.dataset.group = "nav";

      const tocBtn = document.createElement("button");
      tocBtn.type = "button";
      tocBtn.className = "ds-toggle-btn";
      tocBtn.dataset.group = "toc";

      rail.append(navBtn, tocBtn);
      document.body.appendChild(rail);

      navBtn.addEventListener("click", function () {
        const next = !readBool(STORAGE_NAV);
        writeBool(STORAGE_NAV, next);
        applySidebarState();
        setBtnLabel(navBtn, next, "nav");
      });

      tocBtn.addEventListener("click", function () {
        const next = !readBool(STORAGE_TOC);
        writeBool(STORAGE_TOC, next);
        applySidebarState();
        setBtnLabel(tocBtn, next, "toc");
      });
    }

    const navBtn = rail.querySelector('[data-group="nav"]');
    const tocBtn = rail.querySelector('[data-group="toc"]');
    setBtnLabel(navBtn, readBool(STORAGE_NAV), "nav");
    setBtnLabel(tocBtn, readBool(STORAGE_TOC), "toc");
  }

  function run() {
    addHeaderCTA();
    addFooterBlock();
    addSidebarToggles();
  }

  window.addEventListener("resize", applySidebarState);

  if (typeof document$ !== "undefined" && document$.subscribe) {
    document$.subscribe(run);
  } else {
    document.addEventListener("DOMContentLoaded", run);
  }
})();
