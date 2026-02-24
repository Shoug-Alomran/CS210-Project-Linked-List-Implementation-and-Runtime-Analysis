(function () {
  const EMAIL = "inquiry@shoug-tech.com";
  const MAIN_WEBSITE = "https://shoug-tech.com/";

  function getSiteRootHref() {
    const baseTag = document.querySelector("base[href]");
    if (baseTag && baseTag.href) return baseTag.href;
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
      overviewIntro: url("index/"),
      overviewDesign: url("overview/design-overview/"),
      // Analysis
      analysisAsymptotic: url("analysis/asymptotic-complexity/"),
      analysisRuntime: url("analysis/runtime-measurement/"),
      analysisInterpretation: url("analysis/interpretation/"),
      // Other pages
      teamwork: url("teamwork/index/"),
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
    `;

    if (meta) footer.insertBefore(block, meta);
    else footer.prepend(block);
  }

  function run() {
    addHeaderCTA();
    addFooterBlock();
  }

  if (typeof document$ !== "undefined" && document$.subscribe) {
    document$.subscribe(run);
  } else {
    document.addEventListener("DOMContentLoaded", run);
  }
})();
