package io.rapi.api;

import io.rapi.api.config.Browser;
import io.rapi.api.config.Input;
import io.rapi.api.config.WebDriver;
import main.java.io.rapi.api.config.WebDriverBrowserConfig;
import main.java.io.rapi.api.config.WebDriverCommonConfig;

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

        @Test
        public void shouldAnswerWithTrue() throws IOException, InterruptedException,
                        Exception {
                // Config config = new Config();
                // ArrayList<String> testSuites = new ArrayList<>();
                // testSuites.add("src/test/java/io/rapi/api/test1.json");
                // config.getInput().setTestSuites(testSuites);

                // Browser browser = new Browser();
                // Map<String, Object> caps = new HashMap<>();
                // caps.put("browserName", "firefox");
                // browser.setCapability(caps);
                // ArrayList<Browser> browsers = new ArrayList<Browser>();
                // browsers.add(browser);
                // WebDriverConfig webDriverConfig = new WebDriverConfig();
                // webDriverConfig.setBrowsers(browsers);
                // webDriverConfig.setServerUrl("http://127.0.0.1:4444");
                // ArrayList<WebDriverConfig> webDriverConfigs = new
                // ArrayList<WebDriverConfig>();
                // webDriverConfigs.add(webDriverConfig);

                // config.getInput().setTestSuites(testSuites);
                // config.getWebdriver().setConfigs(webDriverConfigs);

                ArrayList<String> testSuites = new ArrayList<>();
                testSuites.add("src/test/java/io/rapi/api/test1.json");
                Input input = Input.builder().withTestSuites(testSuites).build();

                Map<String, Object> caps = new HashMap<>();
                caps.put("browserName", "firefox");
                ArrayList<WebDriverCommonConfig> service = new ArrayList<WebDriverCommonConfig>();
                service.add(
                                WebDriverBrowserConfig.builder()
                                                .withBrowsers(Browser.builder().withCapability(caps).build())
                                                .withServerUrl("http://127.0.0.1:4444").build());

                Config config = Config.builder().withInput(input)
                                .withWebdriver(WebDriver.builder().withConfigs(service).build()).build();
                System.out.println(config.toString());
                Rapi rapi = new Rapi("../rapi-runner/rapi-runner-linux", config);
                RapiReport report = rapi.run();
                System.out.println(report.getJson());
                // assert (report.getJson() != null || report.getHtml() != null);
        }
}
