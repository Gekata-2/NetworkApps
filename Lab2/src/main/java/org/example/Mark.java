package org.example;

import java.util.HashMap;

public class Mark {

    int id;
    String text;

    public Mark() {
    }

    public Mark(String text, int id) {
        this.id=id;
        this.text=text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
