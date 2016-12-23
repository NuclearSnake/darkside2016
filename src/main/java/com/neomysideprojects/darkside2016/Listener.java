package com.neomysideprojects.darkside2016;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Neo on 22.12.2016.
 */
public class Listener implements Runnable{
    private final int PORT = Integer.parseInt(System.getenv("PORT"));
    //private final int PORT = 80;
    @Override
    public void run(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Booted server.  " + PORT);
            System.out.println(serverSocket);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(1);
        }
        System.out.println("Server initialized.\n Port = "+PORT+".");
        Socket clientSocket = null;

        try {
            while(true) {
                clientSocket = serverSocket.accept();
                System.out.println("Connected, yay!!! Remote address: " + clientSocket.getInetAddress());
                //new Thread(new com.neomysideprojects.darkside2016.Communicator(clientSocket, "Hi there. Your server.")).start();
                respond(clientSocket, "Hi there. Your server.");
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + PORT);
            System.exit(1);
        }
    }

    public void respond(Socket clientSocket, String serverText){
        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            System.out.println("Saying 'Hi' to a user on a " + clientSocket.getInetAddress());
            output.write(("HTTP / 1.1 200 OK\n\nWorkerRunnable: " +
                    serverText + " - " +
                    time +
                    "").getBytes());
            output.flush();
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            System.out.println("Could not respond");
            e.printStackTrace();
        }
    }

}
