package com.ChatBot.PPT.DTO;

public class ChatResponse {

    public String reply;

    public ChatResponse(){

    }
     public ChatResponse(String reply) {
        this.reply = reply;
    }

    public String getReply(){
        return reply;
    }
    public void setReply(String reply){
        this.reply=reply;

    }
}
