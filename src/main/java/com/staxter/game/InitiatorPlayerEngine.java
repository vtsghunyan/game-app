package com.staxter.game;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Initiator player engine who initiates sending end receiving messages.
 *
 */
public class InitiatorPlayerEngine implements PlayerEngine {
    private final AtomicInteger counter = new AtomicInteger(0);
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
     */
    @Override
    public void handle(String name) throws InterruptedException {
        while(counter.getAndIncrement() < MESSAGE_DEFAULT_COUNT) {
            String message = "message";
            output.put(message);
            System.out.println(name + " sent >> " + message);
            message = input.take();
            Thread.sleep(2000);
            System.out.println(name + " received >> " + message);
            System.out.println("Message count = " + counter.get() + "\n");
        }
    }
}
