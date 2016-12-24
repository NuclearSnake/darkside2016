package com.neomysideprojects.darkside2016;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import javax.servlet.http.HttpSessionId

import com.neomysideprojects.darkside2016.managers.JacksonManager;
import com.neomysideprojects.darkside2016.managers.MySQL_DBManager;
import com.neomysideprojects.darkside2016.managers.PostgreSQL_Heroku_DBManager;

/**
 *
 * @author Neo
 */
public class Darkside2016 {
    public static final int IDLE_TIME = 1000*60*60*24*10; // 10 days
    public static final Boolean RELEASE = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        DataManager manager;
        if(RELEASE)
            manager = new DataManager(new PostgreSQL_Heroku_DBManager(), new JacksonManager());
        else
            manager = new DataManager(new MySQL_DBManager(), new JacksonManager());


        HttpProcessor httpProcessor = new HttpProcessor();
        HttpProcessor.setup(manager);

        long startTime = System.currentTimeMillis();

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
