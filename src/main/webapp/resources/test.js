/* Place any Javascript here you want loaded in test.xhtml */
window.chartExtender = function() {
    // Rough Workaround
    // this.cfg.config.options.scales.y.beginAtZero = this.cfg.config.options.scales.y.ticks.beginAtZero;
    console.info(this.cfg.config);
    debugger;
};