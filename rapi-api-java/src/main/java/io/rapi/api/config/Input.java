package io.rapi.api.config;

import java.util.ArrayList;
import lombok.*;

@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Input {
    @NonNull
    private ArrayList<String> testSuites;
    @Builder.Default
    private ArrayList<String> variables = new ArrayList<String>();
    @Builder.Default
    private ArrayList<String> dataDriven = new ArrayList<String>();
}
