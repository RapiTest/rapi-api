package io.rapi.api.config;

import lombok.*;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Period {
    @Builder.Default
    private int time = -1;
    @Builder.Default
    private int maxNum = -1;
}
