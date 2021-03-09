package com.liquidforte.speedrun.client;

import lombok.Data;

@Data
public class Times {
    private String primary;
    private long primary_t;
    private String realtime;
    private long realtime_t;
    private String realtime_noloads;
    private long realtime_noloads_t;
    private String ingame;
    private long ingame_t;
}
