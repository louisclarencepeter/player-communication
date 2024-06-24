package com.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Player implements Runnable {
    // Constants
    private static final int QUEUE_CAPACITY = 10;

    // Instance variables
    private BlockingQueue<Message> incomingMessages = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    private Player partner;
    private String name;
    private AtomicInteger messageCounter = new AtomicInteger(0);
    private volatile boolean running = true;

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Set the partner player
    public void setPartner(Player partner) {
        this.partner = partner;
    }

    // Send a message to the partner player
    public void sendMessage(String text) {
        Message message = new Message(text, this);
        try {
            partner.receiveMessage(message);
            System.out.println(name + " sent: " + message.getText());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Receive a message from the partner player
    public void receiveMessage(Message message) throws InterruptedException {
        incomingMessages.put(message);
    }

    // Get the count of messages received
    public int getMessageCount() {
        return messageCounter.get();
    }

    // Stop the player from sending/receiving messages
    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Message message = incomingMessages.take();
                int currentCount = messageCounter.incrementAndGet();
                String newText = message.getText() + " " + currentCount;
                System.out.println(name + " received: " + message.getText());
                if (currentCount < 10) {
                    sendMessage(newText);
                } else {
                    stop();
                    partner.stop();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " has finished sending/receiving messages.");
    }
}
