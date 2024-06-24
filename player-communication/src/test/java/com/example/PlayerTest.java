package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {
    @Test
    // Test for message sending between players
    public void testMessageSending() throws InterruptedException {
        // Create two player objects
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        // Set each player as the partner of the other
        player1.setPartner(player2);
        player2.setPartner(player1);

        // Create threads for each player
        Thread player1Thread = new Thread(player1);
        Thread player2Thread = new Thread(player2);

        // Start the player threads
        player1Thread.start();
        player2Thread.start();

        // Send a test message from player1 to player2
        player1.sendMessage("Test");

        // Wait for a second to allow message processing
        Thread.sleep(1000);

        // Assert that player2 has received at least one message
        assertTrue(player2.getMessageCount() > 0);

        // Stop the players and interrupt their threads
        player1.stop();
        player2.stop();
        player1Thread.interrupt();
        player2Thread.interrupt();

        // Wait for the player threads to finish
        player1Thread.join();
        player2Thread.join();
    }
}
