package com.neomysideprojects.darkside2016;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Neo on 23.12.2016.
 */
public class PostgreSQL_Heroku_DBManager implements DBManager{

//    private static Connection getConnection() throws URISyntaxException, SQLException {
//        URI dbUri = new URI(System.getenv("DATABASE_URL"));
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
//
//        return DriverManager.getConnection(dbUrl, username, password);
//    }

    // JDBC driver name and database URL
    //static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = System.getenv("JDBC_DATABASE_URL"); // Heroku-provided
    //static final String DB_NAME = "dabl5tp0mkijjs"; // Heroku-provided

    //  Database credentials
    //static final String USER = "root";
    //static final String PASS = "";

    static {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 3: Open a connection
            System.out.println("Connecting to SQL...");
            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            sql = "CREATE TABLE IF NOT EXISTS category("
                    + "cat_id SERIAL NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(20) NOT NULL"
                    + ")";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS user("
                    + "user_id SERIAL NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(64) NOT NULL,"
                    + "passwordHash BIT(64),"
                    + "passwordSalt BIT(64),"
                    + "rating INT"
                    + ")";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS idea("
                    + "idea_id SERIAL NOT NULL PRIMARY KEY,"
                    + "user_id INT NOT NULL,"
                    + "username VARCHAR(64),"
                    + "title VARCHAR(64) NOT NULL,"
                    + "link VARCHAR(256),"
                    + "text VARCHAR(1024),"
                    + "file VARBIT(20971520),"
                    + "date TIMESTAMPTZ," // Timestamp with time zone
                    + "rating INT,"
                    + "FOREIGN KEY(user_id) REFERENCES user(user_id),"
                    + "CHECK (link IS NOT NULL OR text IS NOT NULL OR file IS NOT NULL)"
                    + ")";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS comment("
                    + "comm_id SERIAL NOT NULL PRIMARY KEY,"
                    + "user_id int NOT NULL,"
                    + "username VARCHAR(64),"
                    + "idea_id int NOT NULL,"
                    + "text VARCHAR(1024),"
                    + "date TIMESTAMP,"
                    + "FOREIGN KEY(user_id) REFERENCES user(user_id),"
                    + "FOREIGN KEY(idea_id) REFERENCES idea(idea_id)"
                    + ")";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS idea_category("
                    + "cat_id int NOT NULL,"
                    + "idea_id int NOT NULL,"
                    + "FOREIGN KEY(idea_id) REFERENCES idea(idea_id),"
                    + "FOREIGN KEY(cat_id) REFERENCES category(cat_id)"
                    + ")";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS vote("
                    + "user_id int NOT NULL,"
                    + "idea_id int NOT NULL,"
                    + "liked BOOLEAN NOT NULL DEFAULT 1,"
                    + "PRIMARY KEY(user_id, idea_id),"
                    + "FOREIGN KEY(user_id) REFERENCES user(user_id),"
                    + "FOREIGN KEY(idea_id) REFERENCES idea(idea_id)"
                    + ")";
            stmt.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS admin("
                    + "admin_id SERIAL NOT NULL PRIMARY KEY,"
                    + "user_id int NOT NULL,"
                    + "admin_since TIMESTAMPTZ," // Timestamp with time zone
                    + "FOREIGN KEY(user_id) REFERENCES user(user_id)"
                    + ")";
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Handle errors for JDBC
            System.out.println("Error occurred: "+se);
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            System.out.println("Error occurred: "+e);
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
                System.out.println("Error occurred: "+se2);
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                System.out.println("Error occurred: "+se);
                se.printStackTrace();
            }//end finally try
        }//end try
    }


    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            System.out.println("Connecting to SQL...");
            conn = DriverManager.getConnection(DB_URL);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT title, text, username from idea";
            //stmt.executeUpdate(sql);

            //sql = "SELECT id, first FROM delete_me";

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("first");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", \'First\': " + age);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        //System.out.println("Goodbye!");
    }//end main

    public void InitializeDB(){

    }

    private ResultSet query(String sql) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        //System.out.println("Goodbye!");
        return rs;
    }

    public CommentExtended readComment(int id) {
        CommentExtended ce = null;
        try {
            ResultSet rs = query("SELECT * FROM comment WHERE comm_id="+id);
            if(rs.next()){ // Get first only
                ce = new CommentExtended(rs.getInt("comm_id"), rs.getInt("user_id"), rs.getInt("idea_id"), rs.getString("username"));
                ce.setText(rs.getString("text"));
                ce.setTimestamp(rs.getTimestamp("date"));
                //Display values
                System.out.print(ce.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ce;
    }

    public IdeaExtended readIdea(int id) {
        IdeaExtended ie = null;
        try {
            ResultSet rs = query("SELECT * FROM comment WHERE comm_id="+id);
            if(rs.next()){ // Get first only
                ie = new IdeaExtended(rs.getInt("idea_id"), rs.getInt("user_id"), rs.getString("username"));
                ie.setTimestamp(rs.getTimestamp("date"));

                ie.setText(rs.getString("text"));
                ie.setLink(rs.getString("link"));
                ie.setFile(rs.getBytes("file"));

                //Display values
                System.out.print(ie.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ie;
    }

    public int writeComment(Comment c) {
        Connection conn = null;
        Statement stmt = null;
        int res = -1;
        try{
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            res = stmt.executeUpdate("INSERT INTO comment(user_id,idea_id,text) VALUES("+c.getUser_id()+","+c.getIdea_id()+","+timestamp+")");
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        //System.out.println("Goodbye!");
        return res;
//              sql = "CREATE TABLE comment("
//              + "comm_id SERIAL NOT NULL PRIMARY KEY,"
//              + "user_id int NOT NULL,"
//              + "username VARCHAR(64),"
//              + "idea_id int NOT NULL,"
//              + "text VARCHAR(1024),"
//              + "date TIMESTAMP,"
//              + "FOREIGN KEY(user_id) REFERENCES user(user_id),"
//              + "FOREIGN KEY(idea_id) REFERENCES idea(idea_id)"
//              + ") IF NOT EXISTS";
    }

    public int writeIdea(Idea i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateComment(Comment c, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateIdea(Idea i, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}