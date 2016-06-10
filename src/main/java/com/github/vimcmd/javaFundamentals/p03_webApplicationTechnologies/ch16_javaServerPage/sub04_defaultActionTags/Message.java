package com.github.vimcmd.javaFundamentals.p03_webApplicationTechnologies.ch16_javaServerPage.sub04_defaultActionTags;

/* # 5 # simple bean-class */

public class Message {

    private Integer id;
    private String text = "default bean text";

    public Message() {
    }

    public Message(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
