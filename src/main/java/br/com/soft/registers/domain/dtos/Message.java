package br.com.soft.registers.domain.dtos;

public class Message {

    private String responseMessage;

    public Message(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
