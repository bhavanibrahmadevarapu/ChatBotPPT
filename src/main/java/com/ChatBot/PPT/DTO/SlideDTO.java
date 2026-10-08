package com.ChatBot.PPT.DTO;

public class SlideDTO {

    private int slideNumber;
    private String title;
    private String content;

    public SlideDTO() {
    }

    public SlideDTO(int slideNumber, String title, String content) {
        this.slideNumber = slideNumber;
        this.title = title;
        this.content = content;
    }

    public int getSlideNumber() {
        return slideNumber;
    }

    public void setSlideNumber(int slideNumber) {
        this.slideNumber = slideNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}