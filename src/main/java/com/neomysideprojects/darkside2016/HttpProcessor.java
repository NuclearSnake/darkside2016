package com.neomysideprojects.darkside2016;

import com.neomysideprojects.darkside2016.interfaces.DBManager;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Neo on 23.12.2016.
 */
public class HttpProcessor extends HttpServlet {
    private static DataManager manager = null;
    private static final int PORT = Darkside2016.RELEASE?Integer.parseInt(System.getenv("PORT")):80;

    public static void setup(DataManager manager){
        HttpProcessor.manager = manager;

        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HttpProcessor()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/user")){
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            // TODO Check if parameter really is of integer type
            // TODO Check output of database read operation
            pw.print( manager.insertUser(manager.readUser( Integer.parseInt(req.getParameter("id")) )) );
            pw.flush();
            pw.close();
            return;
        }

        if(req.getRequestURI().equals("/login")){
            resp.setContentType("text/plain;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            // TODO Check if parameter really is of integer type
            // TODO Check output of database read operation
            //pw.println("SUCCESS");
            //pw.println("You successfully logged in. Here is your token:");
            byte [] token = manager.loginUser(req.getParameter("name"), req.getParameter("password"));
            String str_token = new String(token, "windows-1251");
            pw.println( str_token );
            //pw.println("Have a nice day!");
            System.out.println("Token given to user "+req.getParameter("name")+"\nToken: "+Passwords.byteArrayToString(str_token.getBytes("windows-1251")).hashCode());

            pw.flush();
            pw.close();
            return;
        }


        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();

        pw.println("<H1>Hello, world! или: Привет мир!!</H1>");
        System.out.println("Input request\nMethod: "+req.getMethod()+"\nAuth type:"+req.getAuthType()+"\nQuery: "+req.getQueryString()+"\nRequest URI: "+req.getRequestURI());

        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if(req.getRequestURI().equals("/user")){
            System.out.println("Received query: "+req.toString());
            resp.setContentType("text/html;charset=utf-8");
            int result = manager.registerUser( req.getParameter("name"), req.getParameter("password") );
            PrintWriter pw = resp.getWriter();
            if(result > 0) {
                pw.println("SUCCESS");
                System.out.println(result + " user was added to the database");
            } else {
                pw.println(Integer.toString(result));
                System.out.println("Error: "+result);
            }
        }
        System.out.println("Input request\nMethod: "+req.getMethod()+"\nAuth type:"+req.getAuthType()+"\nQuery: "+req.getQueryString()+"\nRequest URI: "+req.getRequestURI());
        //super.doPost(req, resp);
    }

}