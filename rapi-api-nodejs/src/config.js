import fs from "fs";
/**
 * Create the config by existed json file
 * @param {string} filePath
 * @returns
 */
export const createConfig = (filePath) => {
  const { input, play, report, webdriver } = JSON.parse(
    fs.readFileSync(filePath, "utf-8")
  );
  return new Config(input, play, report, webdriver);
};

export class Config {
  #config;
  constructor(input, play, report, webdriver) {
    this.#config = {
      input: input,
      play: play,
      report: report,
      webdriver: webdriver,
    };
  }

  toString() {
    return JSON.stringify(this.#config);
  }

  getReportType() {
    return this.#config.report.type;
  }
}
