package com.staxter.game;

public interface PlayerEngine {
    int MESSAGE_DEFAULT_COUNT = 10;

    void handle(String name) throws InterruptedException;
}
