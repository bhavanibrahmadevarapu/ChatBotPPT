package com.ChatBot.PPT.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ChatBot.PPT.DTO.SlideDTO;
import com.ChatBot.PPT.Service.PdfReaderService;
import com.ChatBot.PPT.Service.SlideService;

@RestController
public class SlideController {

    private final PdfReaderService pdfReaderService;
    private final SlideService slideService;

    public SlideController(
            PdfReaderService pdfReaderService,
            SlideService slideService) {

        this.pdfReaderService = pdfReaderService;
        this.slideService = slideService;
    }

    @GetMapping("/api/slides")
    public List<SlideDTO> getSlides(
            @RequestParam String fileName)
            throws IOException {

        String text =
                pdfReaderService.readPdf(
                        "uploads/" + fileName);

        return slideService.createSlides(text);
    }
}