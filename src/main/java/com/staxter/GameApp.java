package com.staxter;

import com.staxter.game.InitiatorPlayerEngine;
import com.staxter.game.Player;
import com.staxter.game.ResponderPlayerEngine;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The GameApp program implements an application that creates and starts 2
 *  Player instances which send and receive messages to each other
 *
 */
public class GameApp {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> requests = new LinkedBlockingQueue<>();
        BlockingQueue<String> replies = new LinkedBlockingQueue<>();

        Thread initiator = new Thread(new Player(new InitiatorPlayerEngine(requests, replies), "Initiator"));
        Thread responder = new Thread(new Player(new ResponderPlayerEngine(replies, requests), "Responder"));

        initiator.start();
        responder.start();

        initiator.join();
        responder.join();
    }
}
