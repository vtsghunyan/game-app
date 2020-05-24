package com.staxter.game;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This represents player who can send and receive messages.
 *  It can be either initiator or just responder
 *
 */
public class Player implements Runnable {
    private static final int MESSAGE_DEFAULT_COUNT = 10;
    private final AtomicInteger counter = new AtomicInteger(0);
    private final PlayerEngine engine;
    private final String name;

    public Player(PlayerEngine engine, String name) {
        this.engine = engine;
        this.name = name;
    }

    public void run() {
        while(counter.getAndIncrement() < MESSAGE_DEFAULT_COUNT) {
            try {
                engine.handle(name, counter.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
