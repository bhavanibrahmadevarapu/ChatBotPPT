
package com.ChatBot.PPT.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.springframework.stereotype.Service;

import com.ChatBot.PPT.DTO.SlideDTO;

@Service
public class PptService {

    public String generatePpt(List<SlideDTO> slides)
            throws IOException {

        XMLSlideShow ppt = new XMLSlideShow();

        for (SlideDTO slideDTO : slides) {

            XSLFSlide slide = ppt.createSlide();

            XSLFTextBox textBox = slide.createTextBox();

            textBox.setAnchor(
                new java.awt.Rectangle(
                    50,
                    50,
                    500,
                    100
                )
            );

            textBox.setText(
                slideDTO.getTitle()
            );
        }

        String fileName = "presentation.pptx";

        FileOutputStream fos =
                new FileOutputStream(
                        "generated/" + fileName);

        ppt.write(fos);

        fos.close();
        ppt.close();

        return fileName;
    }
}