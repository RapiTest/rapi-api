package io.rapi.api.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import lombok.*;
import main.java.io.rapi.api.config.WebDriverCommonConfig;

@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WebDriver {
    @Builder.Default
    private ArrayList<WebDriverCommonConfig> configs = new ArrayList<WebDriverCommonConfig>();
    @Builder.Default
    private Map<String, String> i18n = Collections.emptyMap();
}
