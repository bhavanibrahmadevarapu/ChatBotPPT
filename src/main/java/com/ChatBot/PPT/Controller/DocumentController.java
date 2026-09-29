package com.ChatBot.PPT.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ChatBot.PPT.Service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public Map<String, String> uploadFile(
            @RequestParam("file") MultipartFile file) throws IOException {

        String fileName = documentService.uploadFile(file);

        Map<String, String> response = new HashMap<>();
        response.put("message", "File uploaded successfully");
        response.put("fileName", fileName);

        return response;
    }
}