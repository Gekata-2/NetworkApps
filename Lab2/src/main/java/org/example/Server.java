package org.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

@WebService
public class Server {
    public static HashMap<Integer, String> marks = new HashMap<>();
    public final String dir = "src/main/ServerFiles/";
    public ArrayList<Record> records = new ArrayList<Record>();
    private int marks_id = 0;


    public void InitTestRecords() {
        AddRecord("Head2", "AMOGUS");
        AddRecord("Head1", "ABOBA");
        AddMark("Mark1");
        AddMark("Mark2");

        ArrayList<Integer> marks_id = new ArrayList<>();
        marks_id.add(2);
        marks_id.add(0);
        AddMarksToRecord(1, marks_id);
    }

    @WebMethod
    public void AddFileToRecord(int id, String fileName, byte[] file) {
        if (file != null && fileName.length() > 0) {

            Record record = FindRecord(id);
            if (record != null) {
                record.setFile(fileName, file);
                try {
                    //bytes[] to file
                    String path = dir + fileName;
                    Path writePath = Paths.get(path);

                    Files.write(writePath, file);
                    System.out.println("File '" + fileName + "' is added to record " + id);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @WebMethod
    public byte[] GetFileFromRecord(int id, String fileName) {
        Record record = FindRecord(id);
        if (record != null
            // && record.fileName.contentEquals(fileName)
        ) {
            System.out.println("File '" + record.fileName + "' is sent");
            return record.file;
        } else {
            System.out.println("record.fileName " + record.fileName + " fileName " + fileName);
            System.out.println("record" + record);
            return null;
        }
    }


    @WebMethod
    public ArrayList<Record> GetAllRecords() {
        return records;
    }

    @WebMethod
    public ArrayList<Record> GetRecordsByMark(int mark_id) {
        ArrayList<Record> recordsResponse = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).isContainsMark(mark_id))
                recordsResponse.add(records.get(i));
        }
        return recordsResponse;
    }


    @WebMethod
    public ArrayList<Mark> GetAllMarks() {
        ArrayList<Mark> marksResponse = new ArrayList<>();

        marks.entrySet().forEach(entry -> {
            marksResponse.add(new Mark(entry.getValue(), entry.getKey()));
        });
        return marksResponse;
    }

    @WebMethod
    public int AddRecord(String header, String text) {
        Record newRecord = new Record(header, text);
        records.add(newRecord);
        System.out.println("New record added: " + newRecord.header + "\n" + "id: " + newRecord.id + "; " + newRecord.text);
        return newRecord.getId();
    }

    @WebMethod
    public int AddMark(String txt) {
        if (!marks.containsValue(txt)) {
            int id = marks_id++;
            marks.put(id, txt);
            System.out.println("New mark added: " + txt);
            return id;
        }
        System.out.println("Mark already exist");
        return -1;
    }

    private Record FindRecord(int id) {
        Record record = null;
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId() == id) {//if record exist
                record = records.get(i);
                break;
            }
        }
        return record;
    }

    @WebMethod
    public void AddMarksToRecord(int record_id, ArrayList<Integer> marks_id) {

        Record record = FindRecord(record_id);

        if (record != null) //if record exist
            for (int i = 0; i < marks_id.size(); i++) {
                if (marks.containsKey(marks_id.get(i)))
                    record.AddMark(marks.get(marks_id.get(i)), marks_id.get(i));
            }
    }

    @WebMethod
    public void DeleteMark(int mark_id) {

        if (marks.containsKey(mark_id)) {
            for (int i = 0; i < records.size(); i++) {
                records.get(i).DeleteMark(mark_id);
            }
            System.out.println("Mark " + marks.get(mark_id) + " deleted");
            marks.remove(mark_id);
        }
    }

    @WebMethod
    public void PrintAllRecords() {
        System.out.println("--------------------");
        for (int i = 0; i < records.size(); i++) {

            Record record = records.get(i);

            System.out.println("     " + record.getHeader() + "\n" + "-> id: " + record.getId() +
                    "; " + record.getText()
            );

            System.out.print("-> Marks: {");
            String[] recordMarks = record.getMarks().values().toArray(new String[0]);

            for (int j = 0; j < recordMarks.length; j++) {
                System.out.print(recordMarks[j] + ";");
            }

            System.out.println(" }");


            System.out.println("-> File: [" + (records.get(i).getFileName() == null ? "" : records.get(i).getFileName()) + "]\n");

        }
        System.out.println("--------------------");

    }
}

