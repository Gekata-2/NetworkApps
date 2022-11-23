package org.example;

import java.util.HashMap;

public class Record {
    public static int counter = 0;
    public HashMap<Integer, String> record_marks;
    int id;
    String header;
    String text;

    String fileName;
    byte[] file = null;

    public Record() {
        this.header = "header";
        this.text = "text";
        this.id = 123;
        record_marks = new HashMap<>();
    }

    public Record(String header, String text) {
        this.header = header;
        this.text = text;
        this.id = counter++;
        record_marks = new HashMap<>();
    }

    public void setFile(String fileName, byte[] file) {
        this.file = file;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public HashMap<Integer, String> getMarks() {
        return record_marks;
    }

    public void setMarks(HashMap<Integer, String> marks) {
        this.record_marks = marks;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void AddMark(String mark, int mark_id) {
        if (!record_marks.containsValue(mark)) {
            record_marks.put(mark_id, mark);
        }
    }

    public void DeleteMark(int mark_id) {
        if (record_marks.containsKey(mark_id))
            record_marks.remove(mark_id);
    }

    public boolean isContainsMark(int id) {
        if (record_marks.containsKey(id))
            return true;
        else
            return false;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
