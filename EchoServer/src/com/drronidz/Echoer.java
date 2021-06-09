package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/9/2021 , 
    CREATED ON : 2:06 PM
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(socket.getOutputStream()
                    , true);

            while (true) {
                String echoString = input.readLine();
                System.out.println("Received client input: " + echoString);
                if(echoString.equals("exit")) {
                    break;
                }

                try {
                    Thread.sleep(15000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                output.println(echoString);
            }


        } catch (IOException e) {
            System.out.println("Oops: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
