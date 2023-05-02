# rapi-api
## Requirment
1. Selenium Server (Grid) (Version recommend >= 4.8), and set it up
2. Install rapi-runner
## Rapi config Document
* Before using the Rapi API, you need to familiarize yourself with our Rapi runner config file schema. You can learn more about it [here]().
## Quick Start
* [For NodeJS](./rapi-api-nodejs/)
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
* For Python
```python
import rapi_api
from rapi_api import ConfigBuilder, Rapi
config = ConfigBuilder()    \
    .setTestSuites(["test1.json"])   \
    .addBrowser("http://url.to.selenium.server", {
        "browserName": "firefox",
    }).build()

rapi = Rapi(
    "path/to/rapi/runner", config)
report = rapi.run()
print(report.json)
```
* For Java
```java
Config config = new Config();
ArrayList<String> testSuites = new ArrayList<>();
testSuites.add("path/to/testSuites");
config.getInput().setTestSuites(testSuites);

Browser browser = new Browser();
Map<String, Object> caps = new HashMap<>();
caps.put("browserName", "firefox");
browser.setCapability(caps);
ArrayList<Browser> browsers = new ArrayList<Browser>();
browsers.add(browser);
WebDriverConfig webDriverConfig = new WebDriverConfig();
webDriverConfig.setBrowsers(browsers);
webDriverConfig.setServerUrl("http://url.to.selenium.server");
ArrayList<WebDriverConfig> webDriverConfigs = new ArrayList<WebDriverConfig>();
webDriverConfigs.add(webDriverConfig);

config.getInput().setTestSuites(testSuites);
config.getWebdriver().setConfigs(webDriverConfigs);

Rapi rapi = new Rapi("path/to/rapi/runner", config);
RapiReport report = rapi.run();
System.out.println(report.getJson());
```

## Documentation
[NodeJS]()

[Python]()

[Java]()