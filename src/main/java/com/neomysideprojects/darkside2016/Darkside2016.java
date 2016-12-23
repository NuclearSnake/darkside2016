package com.neomysideprojects.darkside2016;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import javax.servlet.http.HttpSessionId

/**
 *
 * @author Neo
 */
public class Darkside2016 {
    public static final int IDLE_TIME = 1000*60*30; // 30 mins

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        HttpProcessor httpProcessor = new HttpProcessor();
        HttpProcessor.main(null);

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
