package com.staxter.game;

import java.util.concurrent.BlockingQueue;

/**
 * Initiator player engine who initiates sending end receiving messages.
 *
 */
public class InitiatorPlayerEngine implements PlayerEngine {
    private final BlockingQueue<String> input;
    private final BlockingQueue<String> output;

    public InitiatorPlayerEngine(BlockingQueue<String> input, BlockingQueue<String> output) {
        this.input = input;
        this.output = output;
    }

    /**
     * This method is used to handle Initiator player's behaviour
     *
     * @param name the name of the player
     * @param i the index of sending message
     */
    @Override
    public void handle(String name, int i) throws InterruptedException {
        String message = "message";
        output.put(message);
        System.out.println(name + " sent >> " + message);
        message = input.take();
        System.out.println(name + " received >> " + message);
        System.out.println("Message count = " + i);
        Thread.sleep(2000);
    }
}
