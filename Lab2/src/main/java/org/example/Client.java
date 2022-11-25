package org.example;

import org.example.service.Mark;
import org.example.service.Record;
import org.example.service.Server;
import org.example.service.ServerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Client {

    public static Server server;
    public static String dir = "src/main/ClientFiles/";
    public static List<String> allActions = Arrays.asList("add_r", "add_m", "add_mtor", "add_ftor", "del_m", "get_rbym", "get_fbyr", "print", "print_m", "hint", "exit");

    private static Scanner scanner;
    private static String actions = "Enter action (add_r,add_m,add_mtor,add_ftor,del_m,get_rbym,get_fbyr,print,print_m,hint,exit): ";

    public static void PrintRecords(List<Record> records) {
        System.out.println("--------------------");
        for (int i = 0; i < records.size(); i++) {
            Record record = records.get(i);

            System.out.println("     " + record.getHeader() + "\n" + "-> id: " + record.getId() +
                    "; " + record.getText()
            );

            System.out.print("-> Marks: {");
            Record.RecordMarks recordMarks = record.getRecordMarks();
            List<Record.RecordMarks.Entry> entry = recordMarks.getEntry();


            for (int j = 0; j < entry.size(); j++) {
                System.out.print(entry.get(j).getValue() + ";");
            }
            System.out.println(" }");

            System.out.println("-> File: [" + (records.get(i).getFileName() == null ? "" : records.get(i).getFileName()) + "]\n");

        }
        System.out.println("--------------------");
    }

    public static int AddRecord(String header, String text) {
        int id = server.addRecord(header, text);
        return id;
    }

    public static int AddMark(String text) {
        int id = server.addMark(text);
        return id;
    }

    public static void AddMarksToRecord(int record_id, ArrayList<Integer> marks_id) {
        server.addMarksToRecord(record_id, marks_id);
    }

    public static void DeleteMark(int id) {
        server.deleteMark(id);
    }

    public static void PrintAllMarks() {
        List<Mark> marks = server.getAllMarks();
        System.out.print("Marks: { ");
        for (int i = 0; i < marks.size(); i++) {

            System.out.print("(" + marks.get(i).getId() + "," + marks.get(i).getText() + "); ");
        }
        System.out.println("}");
    }

    public static void PrintRecordByMark(int mark_id) {
        PrintRecords(server.getRecordsByMark(mark_id));
    }

    public static byte[] ReadFile(String fileName) {
        try {
            String path = dir + fileName;
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return bytes;
        } catch (IOException e) {
            System.out.println("No such file");
            return null;
        }
    }

    public static void WriteFile(byte[] file, String fileName) {
        if (file != null && fileName.length() > 0) {
            try {
                int i = fileName.lastIndexOf('.');
                String extension = "." + fileName.substring(i + 1);
                String fName = fileName.substring(0, i);

                fName = fName + "_response" + extension;

                String path = dir + fName;
                Path writePath = Paths.get(path);
                Files.write(writePath, file);
                System.out.println("File written");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(file);

        }
    }

    public static void AddFileToRecord(int id, String fName) {
        byte[] file = ReadFile(fName);
        if (file != null) {
            server.addFileToRecord(id, fName, file);
        }
    }

    public static byte[] GetFileFromRecord(int id, String fName) {
        byte[] file = server.getFileFromRecord(id, fName);
        WriteFile(file, fName);
        return file;
    }

    private static void init() {
        ServerService realServer = new ServerService();
        server = realServer.getServerPort();
        scanner = new Scanner(System.in);
    }

    private static String GetAction() {
        System.out.print(actions);
        String action = scanner.nextLine();
        while (!allActions.contains(action.toLowerCase())) {
            System.out.println("Incorrect action. Please enter action again");
            System.out.print(actions);
            action = scanner.nextLine();
        }
        return action;
    }

    private static int getInt() {
        int res = 0;

        boolean correct_int = false;
        while (!correct_int) {
            if (scanner.hasNextInt()) {

                res = scanner.nextInt();
                scanner.nextLine();
                correct_int = true;
            } else {
                System.out.println("Incorrect input. Inter integer number");
            }
        }
        return res;
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if (string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    private static ArrayList<Integer> ParseMarks() {
        String[] marks = scanner.nextLine().trim().split("/");

        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < marks.length; i++) {
            if (isNumeric(marks[i].trim())) {
                ids.add(Integer.valueOf(marks[i].trim()));
            }
        }
        return ids;
    }

    private static void PrintHint() {
// "add_r", "add_m", "add_mtor", "add_ftor", "del_m", "get_rbym", "get_fbyr", "print", "print_m", "exit"
        System.out.println("--------------------------------------------");
        System.out.println("|>Possible actions (case doesn't matter):  |");
        System.out.println("" +
                "| add_r: " + "   Add new record to server       |\n" +
                "| add_m: " + "   Add new mark to server         |\n" +
                "| add_mtor: " + "Add new mark to record         |\n" +
                "| add_ftor: " + "Add new file to record         |\n" +
                "| del_m: " + "   Delete mark from server        |\n" +
                "| get_rbym: " + "Get records by mark            |\n" +
                "| get_fbyr: " + "Add file by record             |\n" +
                "| print: " + "   Print all records              |\n" +
                "| print_m: " + " Print all records by mark      |\n" +
                "| hint: " + "    Print hint                     |\n" +
                "| exit: " + "    Exit program                   |"
        );
        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {

        init();
        PrintHint();
        boolean isWorking = true;

        while (isWorking) {

            String action = GetAction();
            switch (action) {
                case "add_r": {
                    String header, text;

                    System.out.print("Enter header: ");
                    header = scanner.nextLine();

                    System.out.print("Enter text: ");
                    text = scanner.nextLine();

                    System.out.println("Record " + AddRecord(header, text) + " added");
                    break;
                }
                case "add_m": {
                    System.out.print("Enter mark: ");
                    String mark = scanner.nextLine();
                    System.out.println("Mark " + AddMark(mark) + " added");
                    break;
                }
                case "add_mtor": {
                    System.out.print("Enter record id: ");
                    int record_id = getInt();

                    System.out.print("Enter marks id separated by slash (1/2/5): ");
                    ArrayList<Integer> marks = ParseMarks();
                    if (marks.size() > 0) {
                        AddMarksToRecord(record_id, marks);
                    }

                    break;
                }
                case "add_ftor": {
                    System.out.print("Enter record id: ");
                    int record_id = getInt();

                    System.out.print("Enter file name: ");
                    String fileName = scanner.nextLine();

                    AddFileToRecord(record_id, fileName);
                    break;
                }
                case "del_m": {
                    System.out.print("Enter mark id: ");
                    String input = scanner.nextLine();
                    if (isNumeric(input.trim()))
                        DeleteMark(Integer.valueOf(input.trim()));
                    break;
                }
                case "get_rbym": {
                    System.out.print("Enter mark id: ");
                    String input = scanner.nextLine();
                    if (isNumeric(input.trim()))
                        PrintRecordByMark(Integer.valueOf(input.trim()));
                    break;
                }
                case "get_fbyr": {
                    System.out.print("Enter record id: ");
                    String id = scanner.nextLine();
                    if (isNumeric(id.trim())) {
                        System.out.print("Enter file name: ");
                        String fileName = scanner.nextLine();
                        GetFileFromRecord(Integer.valueOf(id.trim()), fileName);
                    }
                    break;
                }
                case "print_m":
                    PrintAllMarks();
                    break;
                case "print":
                    PrintRecords(server.getAllRecords());
                    break;
                case "hint":
                    PrintHint();
                    break;
                case "exit":
                    isWorking = false;
                    break;
                default:
                    break;
            }
        }

    }
}

