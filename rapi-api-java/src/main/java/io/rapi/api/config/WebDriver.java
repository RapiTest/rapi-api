package io.rapi.api.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class WebDriver {
    private ArrayList<WebDriverConfig> configs = new ArrayList<WebDriverConfig>();
    private Map<String, String> i18n = Collections.emptyMap();

    public void setConfigs(ArrayList<WebDriverConfig> configs) {
        this.configs = configs;
    }

    public void setI18n(Map<String, String> i18n) {
        this.i18n = i18n;
    }

    public ArrayList<WebDriverConfig> getConfigs() {
        return configs;
    }

    public Map<String, String> getI18n() {
        return i18n;
    }
}
