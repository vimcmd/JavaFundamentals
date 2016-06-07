package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch11_threads.sub14_latches;

/* # 28 # data containing class */

public class Task {
    private String content;
    private String answer;
    private float mark;

    public Task(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
