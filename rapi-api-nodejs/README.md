# rapi-api-nodejs
## Quick Start
```javascript
import { createRapi, Browser, ConfigBuilder } from "rapi-api";

const config = new ConfigBuilder()
  .setTestSuites(["path/to/testSuites"])
  .addBrowser("http://url.to.selenium.server", { browserName: "firefox" })
  .build();

const rapi = createRapi("path/to/rapi/runner", config);

const report = rapi.run();

console.log(report);

```
## Documentation
[NodeJS](https://hackmd.io/@Rapi/ryRE3mtQn)