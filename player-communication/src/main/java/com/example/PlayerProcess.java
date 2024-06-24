package com.example;

public class PlayerProcess {
    public static void main(String[] args) {
        // Create player objects with command line arguments
        Player player = new Player(args[0]);
        Player partner = new Player(args[1]);

        // Set each player as the partner of the other
        player.setPartner(partner);
        partner.setPartner(player);

        // Create threads for each player
        Thread playerThread = new Thread(player);
        Thread partnerThread = new Thread(partner);

        // Start the player threads
        playerThread.start();
        partnerThread.start();
    }
}
