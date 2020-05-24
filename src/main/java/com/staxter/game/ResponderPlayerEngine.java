package com.staxter.game;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Responder player engine who receives and replies messages.
 *
 */
public class ResponderPlayerEngine implements PlayerEngine {
    private final AtomicInteger counter = new AtomicInteger(0);
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
     */
    @Override
    public void handle(String name) throws InterruptedException {
        while(counter.getAndIncrement() < MESSAGE_DEFAULT_COUNT) {
            Thread.sleep(2000);
            String message = input.take();
            Thread.sleep(2000);
            System.out.println(name + " received >> " + message);
            output.put(message + counter.get());
            System.out.println(name + " replied >> " + message + counter.get());
        }
    }
}
