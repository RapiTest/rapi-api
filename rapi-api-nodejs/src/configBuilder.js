import { Config } from "./config.js";

export const PlaybackType = {
  PLAY_CASE: 0,
  PLAY_SUITE: 1,
  PLAY_ALL_SUITES: 2,
};

export const SnapshotStatus = {
  NO_SNAPSHOT: 0,
  SNAPSHOT_ON_ERRORS: 1,
  ALWAYS_SNAPSHOT: 2,
};

const defaultReport = {
  type: "json",
  snapshot: SnapshotStatus.NO_SNAPSHOT,
};

export class ConfigBuilder {
  #play = {};
  #input = {};
  #report = {};
  #webdriver = { configs: [], i18n: {} };

  constructor() {
    this.#report = defaultReport;
  }

  /**
   * Set play config
   * @param {0 | 1 | 2} options.mode - The mode of playback.
   * @param {1 | 2 | 3 | 4 | 5} options.speed - The speed of the playback. 5 is the fast speed.
   * @param {number} options.autoWaitTimeout - The timeout before executing the next command.
   * @param {Object} options.period -
   * @param {number} options.period.time - The duration of the periodical running. Set to -1 to disable the periodical running.
   * @param {number} options.period.maxNum - The maximum number of times of the periodical running. Set to -1 to run infinitely.
   * @param {string} options.entry - The entry test case or test suite when running.
   * If mode=0, this field should be set to a full name of test case, e.g. testsuite1.testcase1.
   * If mode=1, this field should be set to a test suite, e.g. testsuite2.
   * If mode=2, this field will be ignored.
   * @param {boolean} options.noLog - Set to true to disable the log.
   * @param {Object} options
   */
  setPlay(options) {
    this.#play.mode = options.mode || this.#play.mode;
    this.#play.speed = options.speed || this.#play.speed;
    this.#play.entry = options.entry || this.#play.entry;
    this.#play.autoWaitTimeout =
      options.autoWaitTimeout || this.#play.autoWaitTimeout;
    this.#play.period = options.period || this.#play.period;
    this.#play.noLog = options.noLog || this.#play.noLog;
    return this;
  }

  /**
   * Set the file paths to the test suites
   * @param {string[]} testSuites A string array
   */
  setTestSuites(testSuites) {
    this.#input.testSuites = testSuites;
    return this;
  }

  /**
   * Set the file paths to the variable files. Only accept json and csv files.
   * @param {string[]} variables A string array
   */
  setVariables(variables) {
    this.#input.variables = variables;
    return this;
  }

  /**
   * Set the file paths to the dataDriven files.
   * @param {string[]} dataDriven A string array
   * @returns {ConfigBuilder}
   */
  setDataDriven(dataDriven) {
    this.#input.dataDriven = dataDriven;
    return this;
  }

  /**
   * Set the Report
   * @param {object} options
   * @param {0 | 1 | 2} options.snapshot - Playback with snapshots
   *    0: No snapshot (default)
   *    1: Capture snapshots on errors
   *    2: Always capture snapshots
   * @param {number} options.snapshotQuality - Snapshot quality ranging from 1 to 100.
   * 100 is the highest quality. A higher quality value will require more disk space.
   * @param {"html" | "json" | "all"} options.type - The type of the test report.
   * @returns {ConfigBuilder}
   */
  setReport(options = null) {
    this.#report.snapshot = options.snapshot || this.#report.snapshot;
    this.#report.snapshotQuality =
      options.snapshotQuality || this.#report.snapshotQuality;
    this.#report.type = options.type || this.#report.type;
    return this;
  }

  /**
   * Language codes and files paths. All the language codes can be
   * found in the Option page of SideeX Recorder. All the languages
   * set here will be run in order. See Internationalization (i18n)
   * Testing Using SideeX for more information.
   * @param {*} i18n
   * @returns {ConfigBuilder}
   */
  setWebdriverI18n(i18n) {
    this.#webdriver.i18n = i18n;
    return this;
  }

  /**
   * Set the webdriver information to run on.
   * @param {Object[]} webdriverConfig
   * @param {string} webdriverConfig.serverUrl - The URL of the WebDriver server.
   * @param {"selenium" | "appium"} webdriverConfig.type - The type of the WebDriver server.
   * @param {Object[]} webdriverConfig.browsers - The browser capabilities to be matched
   * @param {boolean} webdriverConfig.browsers.keepSessionAlive - Keep the webdriver sessionId alive.
   * @param {Object} webdriverConfig.browsers.capability Capability follow W3C WebDriver Capability spec.
   * @returns {ConfigBuilder}
   */
  setWebdriverConfig(webdriverConfig) {
    this.#webdriver.configs = webdriverConfig;
    return this;
  }

  /**
   * Add the webdriver information  to run on and the capability to match.
   * @param {string} serverUrl - The URL of the WebDriver server.
   * @param {Object} capability - Capability follow W3C WebDriver Capability spec.
   * @param {"selenium" | "appium"} type - The type of the WebDriver server.
   * @param {boolean} keepSessionAlive - Set true to keep the webdriver sessionId alive.
   */
  addBrowser(
    serverUrl,
    capability,
    type = "selenium",
    keepSessionAlive = false
  ) {
    this.#webdriver.configs.push({
      serverUrl: serverUrl,
      type: type,
      browsers: [
        {
          active: true,
          capability: capability,
          keepSessionAlive: keepSessionAlive,
        },
      ],
    });
  }

  /**
   * Add the webdriver information and the existed session id to run on.
   * @param {string} serverUrl - The URL of the WebDriver server.
   * @param {string} sessionId - The existed session id on the webdriver.
   * @param {"selenium" | "appium"} type - The type of the WebDriver server.
   * @param {boolean} keepSessionAlive - Set true to keep the webdriver sessionId alive.
   */
  addSession(
    serverUrl,
    sessionId,
    type = "selenium",
    keepSessionAlive = false
  ) {
    this.#webdriver.configs.push({
      serverUrl: serverUrl,
      type: type,
      sessions: [
        {
          sessionId: sessionId,
          keepSessionAlive: keepSessionAlive,
        },
      ],
    });
  }

  build() {
    return new Config(this.#input, this.#play, this.#report, this.#webdriver);
  }
}
