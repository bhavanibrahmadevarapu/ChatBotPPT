package com.ChatBot.PPT.Controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ChatBot.PPT.Service.PdfReaderService;

@RestController
public class DocumentReadController {

    private final PdfReaderService pdfReaderService;

    public DocumentReadController(PdfReaderService pdfReaderService) {
        this.pdfReaderService = pdfReaderService;
    }

    @GetMapping("/api/documents/read")
    public String readPdf(
            @RequestParam String fileName) throws IOException {

        return pdfReaderService.readPdf(
                "uploads/" + fileName);
    }
}