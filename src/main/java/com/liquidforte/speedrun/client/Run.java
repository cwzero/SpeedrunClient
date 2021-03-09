package com.liquidforte.speedrun.client;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Run {
    private String id;
    private String weblink;
    private String game;
    private String level;
    private String category;
    private String comment;
    private Date date;
    private Date submitted;
    private List<Link> players = new ArrayList<>();
    private Times times;

    public String getPlayer() {
        return players.stream().filter(it -> it.getRel().equals("user")).findFirst().map(it -> it.getId()).orElse("");
    }
}
