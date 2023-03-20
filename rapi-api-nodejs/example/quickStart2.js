import { createRapi, createConfig } from "../src/index.js";

const config = createConfig("./example/config.json");
const rapi = createRapi(
  "../rapi-runner/rapi-runner-linux",
  config
);
const report = rapi.run();
console.log(JSON.stringify(report));
