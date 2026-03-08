(function () {
  var url = new URL(window.location.href);
  var hasSearchQuery = url.searchParams.has("q");
  var hasEmptySearchQuery = hasSearchQuery && !String(url.searchParams.get("q") || "").trim();
  var trackingParams = ["gclid", "fbclid", "mc_cid", "mc_eid"];
  var changed = false;

  if (hasSearchQuery) {
    url.searchParams.delete("q");
    changed = true;
  }

  trackingParams.forEach(function (key) {
    if (url.searchParams.has(key)) {
      url.searchParams.delete(key);
      changed = true;
    }
  });

  Array.from(url.searchParams.keys()).forEach(function (key) {
    if (key.toLowerCase().indexOf("utm_") === 0) {
      url.searchParams.delete(key);
      changed = true;
    }
  });

  if (changed) {
    var clean = url.pathname + (url.searchParams.toString() ? "?" + url.searchParams.toString() : "") + url.hash;
    window.history.replaceState({}, document.title, clean);
  }

  if (hasSearchQuery || hasEmptySearchQuery) {
    var robots = document.querySelector('meta[name="robots"]');
    if (!robots) {
      robots = document.createElement("meta");
      robots.name = "robots";
      document.head.appendChild(robots);
    }
    robots.content = "noindex,follow";
  }
})();
