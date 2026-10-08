
package com.ChatBot.PPT.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.nio.file.Files;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.ChatBot.PPT.DTO.SlideDTO;
import com.ChatBot.PPT.Service.PdfReaderService;
import com.ChatBot.PPT.Service.PptService;
import com.ChatBot.PPT.Service.SlideService;

@RestController
public class PptController {

    private final PdfReaderService pdfReaderService;
    private final SlideService slideService;
    private final PptService pptService;

    public PptController(
            PdfReaderService pdfReaderService,
            SlideService slideService,
            PptService pptService) {

        this.pdfReaderService = pdfReaderService;
        this.slideService = slideService;
        this.pptService = pptService;
    }

    @GetMapping("/api/ppt/generate")
    public String generatePpt(
            @RequestParam String fileName)
            throws IOException {

        String text =
                pdfReaderService.readPdf(
                        "uploads/" + fileName);

        List<SlideDTO> slides =
                slideService.createSlides(text);

        return pptService.generatePpt(slides);
    }

@GetMapping("/api/ppt/download")
public ResponseEntity<ByteArrayResource> downloadPpt()
        throws IOException {

    File file = new File("generated/presentation.pptx");

    byte[] data = Files.readAllBytes(file.toPath());

    ByteArrayResource resource =
            new ByteArrayResource(data);

    return ResponseEntity.ok()
            .header(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=presentation.pptx"
            )
            .contentType(
                MediaType.APPLICATION_OCTET_STREAM
            )
            .contentLength(data.length)
            .body(resource);
}

}

