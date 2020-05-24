package com.staxter.game;

/**
 * This represents player who can send and receive messages.
 *  It can be either initiator or just responder
 *
 */
public class Player implements Runnable {
    private final PlayerEngine engine;
    private final String name;

    public Player(PlayerEngine engine, String name) {
        this.engine = engine;
        this.name = name;
    }

    public void run() {
        try {
            engine.handle(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
