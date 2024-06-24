package com.example;

public class Main {
    public static void main(String[] args) {
        // Create initiator and receiver players
        Player initiator = new Player("Initiator");
        Player receiver = new Player("Receiver");

        // Set each player as the partner of the other
        initiator.setPartner(receiver);
        receiver.setPartner(initiator);

        // Create threads for initiator and receiver
        Thread initiatorThread = new Thread(initiator);
        Thread receiverThread = new Thread(receiver);

        // Start the threads
        initiatorThread.start();
        receiverThread.start();

        // Send a message from the initiator
        initiator.sendMessage("Message 1");

        try {
            // Wait for the threads to finish
            initiatorThread.join();
            receiverThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
