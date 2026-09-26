package com.ChatBot.PPT.Service;
import org.springframework.stereotype.Service;
@Service
public class ChatService {
    //for now 
public String getReply(String message){

    if(message==null||message.trim().isEmpty()){
       return "Please enter a message.";
    }
    String msg=message.trim().toLowerCase();
    if(msg.equals("hello")){
        return "Hello! Upload a document to create a powerpoint presentation.";
    }
    else if(msg.equals("hi")){
        return "Hi! Upload a document.";
    }
    else{
        return "I can help in creating PowerPoint presentations.";
    }
}
}
