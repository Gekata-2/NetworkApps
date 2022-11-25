package org.example;

import javax.xml.ws.Endpoint;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.InitTestRecords();
        server.PrintAllRecords();
        Endpoint.publish("http://localhost:8080/Server", server);
        System.out.println("Server is running!");
    }
}
