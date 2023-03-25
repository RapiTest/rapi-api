import { createRapi, ConfigBuilder } from "../src/index.js";

const config = new ConfigBuilder()
  .setTestSuites(["./example/test1.json"])
  .addBrowser("http://127.0.0.1:4444", { browserName: "firefox" })
  .build();

const rapi = createRapi("../rapi-runner/rapi-runner-linux", config);

const report = rapi.run();

console.log(JSON.stringify(report));
