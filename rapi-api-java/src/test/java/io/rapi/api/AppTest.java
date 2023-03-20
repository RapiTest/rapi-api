package io.rapi.api;

import io.rapi.api.config.Browser;
import io.rapi.api.config.WebDriverConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import io.rapi.api.RapiReport;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import io.rapi.api.config.Config;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException, InterruptedException, Exception {
        Config config = new Config();
        ArrayList<String> testSuites = new ArrayList<>();
        testSuites.add("src/test/java/io/rapi/api/test1.json");
        config.getInput().setTestSuites(testSuites);

        Browser browser = new Browser();
        Map<String, Object> caps = new HashMap<>();
        caps.put("browserName", "firefox");
        browser.setCapability(caps);
        ArrayList<Browser> browsers = new ArrayList<Browser>();
        browsers.add(browser);
        WebDriverConfig webDriverConfig = new WebDriverConfig();
        webDriverConfig.setBrowsers(browsers);
        webDriverConfig.setServerUrl("http://127.0.0.1:4444");
        ArrayList<WebDriverConfig> webDriverConfigs = new ArrayList<WebDriverConfig>();
        webDriverConfigs.add(webDriverConfig);

        config.getInput().setTestSuites(testSuites);
        config.getWebdriver().setConfigs(webDriverConfigs);

        Rapi rapi = new Rapi("../rapi-runner/rapi-runner-linux", config);
        RapiReport report = rapi.run();
        System.out.println(report.getJson());
        // assert (report.getJson() != null || report.getHtml() != null);
    }
}
