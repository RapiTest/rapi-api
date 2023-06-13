package io.github.rapitest.config;

import lombok.*;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Session {
    @Builder.Default
    private String sessionId = "";
    @Builder.Default
    private boolean keepSessionAlive = false;
}
