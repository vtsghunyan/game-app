package com.staxter.game;

/**
 * This represents player who can send and receive messages.
 *  It can be either initiator or just responder
 *
 */
public class Player implements Runnable {
    private static final int MESSAGE_DEFAULT_COUNT = 10;
    private final PlayerEngine engine;
    private final String name;

    public Player(PlayerEngine engine, String name) {
        this.engine = engine;
        this.name = name;
    }

    public void run() {
        try {
            engine.handle(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
