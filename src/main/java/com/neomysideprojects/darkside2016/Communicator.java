package com.neomysideprojects.darkside2016;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Neo on 22.12.2016.
 */
public class Communicator implements Runnable {
    protected Socket clientSocket = null;
    protected String serverText   = null;

    public Communicator(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            System.out.println("Saying 'Hi' to a user on a "+clientSocket.getInetAddress());
            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
                    this.serverText + " - " +
                    time +
                    "").getBytes());
            output.flush();
            output.close();
            input.close();
            System.out.println("Request processed: " + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}
