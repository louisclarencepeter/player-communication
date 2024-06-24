package com.example;

public class Message {
    private String text; // The text content of the message
    private Player sender; // The player who sent the message

    public Message(String text, Player sender) {
        this.text = text;
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public Player getSender() {
        return sender;
    }
}
