package com.neomysideprojects.darkside2016;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.http.HttpSessionId

/**
 *
 * @author Neo
 */
public class Darkside2016 extends HttpServlet {
    public static final int IDLE_TIME = 1000*60*30; // 30 mins
    //private static final int PORT = Integer.parseInt(System.getenv("PORT"));
    private static final int PORT = 80;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<H1>Hello, world! или: Привет мир!!</H1>");
        System.out.println("Input request\nMethod: "+req.getMethod()+"\nAuth type:"+req.getAuthType()+"\nQuery: "+req.getQueryString()+"\nRequest URI: "+req.getRequestURI());

        pw.flush();
        pw.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //DataManager manager = new DataManager(new MySQL_DBManager(), new JacksonManager());
        //MySQL_DBManager bManager = new MySQL_DBManager();
        //MySQL_DBManager.main(null);


        long startTime = System.currentTimeMillis();
        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new Darkside2016()), "/*");
        server.start();
        server.join();

        try {
            while(System.currentTimeMillis() < (startTime + IDLE_TIME) ) {
                System.out.println("Time left: "+((startTime + IDLE_TIME)-System.currentTimeMillis()));
                Thread.sleep(30000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time is over. C u nxt tim!");
        System.exit(0);
    }


}
