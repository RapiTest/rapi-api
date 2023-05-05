package main.java.io.rapi.api.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class WebDriverCommonConfig {
    @Builder.Default
    private String type = "selenium";
    @NonNull
    private String serverUrl;
}
