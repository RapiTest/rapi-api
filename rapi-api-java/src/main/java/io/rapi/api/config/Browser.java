package io.rapi.api.config;

import java.util.Collections;
import java.util.Map;
import lombok.*;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Browser {
    private final boolean active = true;
    @Builder.Default
    private boolean keepSessionAlive = false;
    @Builder.Default
    private Map<String, Object> capability = Collections.emptyMap();
}
