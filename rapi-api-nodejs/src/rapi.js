import { Config } from "./config.js";
import { RapiProc } from "./proc.js";

export const createRapi = (runnerPath, config) => {
  return new Rapi(runnerPath, config);
};

export class Rapi {
  #config;
  /**
   * @param {string} runnerPath - The rapi runner file path
   * @param {Config} config - The config about input, report, play, webdricer setting
   */
  constructor(runnerPath, config) {
    this.#config = config;
    this.runnerPath = runnerPath;
  }

  /**
   * The function will run the test depend on the config you set,
   * after finish the test it will pass the report back
   * @returns - The test report.
   */
  run() {
    const service = new RapiProc(this.runnerPath);
    const data = service.run(this.#config);
    console.error(data.stderr);
    return this.#parseReport(data.stdout);
  }

  #parseReport(report) {
    try {
      const startJsonFlag = "INFO Start to send json report to api\n";
      const endJsonFlag = "INFO End of sending json report to api\n";
      const startHtmlFlag = "INFO Start to send html report to api\n";
      const endHtmlFlag = "INFO End of sending html report to api\n";
      const reportType = this.#config.getReportType();
      let jsonReport = null;
      let htmlReport = null;
      if (reportType === "json" || reportType === "all") {
        jsonReport = report.substring(
          report.search(startJsonFlag) + startJsonFlag.length,
          report.search(endJsonFlag)
        );
        jsonReport = JSON.parse(jsonReport);
      }
      if (reportType === "html" || reportType === "all") {
        htmlReport = report.substring(
          report.search(startHtmlFlag) + startHtmlFlag.length,
          report.search(endHtmlFlag)
        );
      }
      return { json: jsonReport, html: htmlReport };
    } catch (e) {
      console.error(e);
      return null;
    }
  }
}
