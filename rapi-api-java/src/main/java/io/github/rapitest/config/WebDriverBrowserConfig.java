package io.github.rapitest.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.SuperBuilder;
import io.github.rapitest.config.utils.BrowsersSessionsPropertySerializer;

@SuperBuilder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WebDriverBrowserConfig extends WebDriverCommonConfig {
    @JsonSerialize(using = BrowsersSessionsPropertySerializer.class)
    private Browser browsers;
}
