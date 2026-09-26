package com.ChatBot.PPT.Service;

public class ChatService {
    //for now 
public String getReply(String message){

    if(message==null||message.trim().isEmpty()){
       return "Please enter a message.";
    }
    String msg=message.trim().toLowerCase();
    if(msg.equals("Hello")){
        return "Hello! Upload a document to create a powerpoint presentation.";
    }
    else if(msg.equals("Hi")){
        return "Hi! Upload a document.";
    }
    else{
        return "I can hellp create PowerPoint presentations.";
    }
}
}
