package com.liquidforte.speedrun.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Game {
    private String id;
    private String name;

    @JsonProperty("names")
    private void setNames(Map<String, String> names) {
        this.name = names.get("international");
    }
}
