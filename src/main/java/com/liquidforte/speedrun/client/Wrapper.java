package com.liquidforte.speedrun.client;

import lombok.Data;

@Data
public class Wrapper<T> {
    private T data;
}
