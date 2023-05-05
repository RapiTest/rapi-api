package main.java.io.rapi.api.config;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.rapi.api.config.Session;
import lombok.*;
import lombok.experimental.SuperBuilder;
import main.java.io.rapi.api.config.utils.BrowsersSessionsPropertySerializer;

@SuperBuilder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class WebDriverSessionConfig extends WebDriverCommonConfig {
    @JsonSerialize(using = BrowsersSessionsPropertySerializer.class)
    private Session sessions;
}
