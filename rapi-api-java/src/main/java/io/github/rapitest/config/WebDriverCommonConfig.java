package io.github.rapitest.config;

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
