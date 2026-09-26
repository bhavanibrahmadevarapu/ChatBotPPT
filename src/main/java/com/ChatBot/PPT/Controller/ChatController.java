package com.ChatBot.PPT.Controller;
import com.ChatBot.PPT.DTO.ChatRequest;
import com.ChatBot.PPT.DTO.ChatResponse;
import com.ChatBot.PPT.Service.ChatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping("/api/chat")
public class ChatController {
    
    private final ChatService chatService;
    public ChatController(ChatService chatService){
        this.chatService=chatService;
    }
    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String reply = chatService.getReply(request.getMessage());

        return new ChatResponse(reply);
    }
    
    

}
