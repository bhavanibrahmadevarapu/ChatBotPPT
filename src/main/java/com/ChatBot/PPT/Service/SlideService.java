package com.ChatBot.PPT.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ChatBot.PPT.DTO.SlideDTO;

@Service
public class SlideService {

    public List<SlideDTO> createSlides(String text) {

        List<SlideDTO> slides = new ArrayList<>();

        String[] lines = text.split("\\r?\\n");

        int slideNo = 1;

        for (String line : lines) {

            line = line.trim();

            if (!line.isEmpty()) {

                slides.add(
                    new SlideDTO(
                        slideNo++,
                        line,
                        ""
                    )
                );
            }
        }

        return slides;
    }
}