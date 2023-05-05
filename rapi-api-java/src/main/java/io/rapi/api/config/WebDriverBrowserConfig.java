package main.java.io.rapi.api.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.rapi.api.config.Browser;

import lombok.*;
import lombok.experimental.SuperBuilder;
import main.java.io.rapi.api.config.utils.BrowsersSessionsPropertySerializer;

@SuperBuilder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WebDriverBrowserConfig extends WebDriverCommonConfig {
    @JsonSerialize(using = BrowsersSessionsPropertySerializer.class)
    private Browser browsers;
}
