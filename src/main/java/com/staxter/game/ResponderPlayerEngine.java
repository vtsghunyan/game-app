package com.staxter.game;

import java.util.concurrent.BlockingQueue;

/**
 * Responder player engine who receives and replies messages.
 *
 */
public class ResponderPlayerEngine implements PlayerEngine {
    private final BlockingQueue<String> input;
    private final BlockingQueue<String> output;

    public ResponderPlayerEngine(BlockingQueue<String> input, BlockingQueue<String> output) {
        this.input = input;
        this.output = output;
    }

    /**
     * This method is used to handle Responder player's behaviour
     *
     * @param name the name of the player
     * @param i the index of sending message
     */
    @Override
    public void handle(String name, int i) throws InterruptedException {
        String message = input.take();
        System.out.println(name + " received >> " + message);
        Thread.sleep(2000);
        output.put(message + i);
        System.out.println(name + " replied >> " + message + i);
        Thread.sleep(2000);
    }
}
