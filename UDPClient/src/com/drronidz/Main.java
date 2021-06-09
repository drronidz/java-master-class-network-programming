package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 6/9/2021 , 
    CREATED ON : 2:39 PM
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer,
                        buffer.length,
                        address,
                        5000);
                datagramSocket.send(packet);

                byte[] bufferTwo = new byte[50];
                packet = new DatagramPacket(bufferTwo, bufferTwo.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is :"
                        + new String(bufferTwo, 0, packet.getLength()));
            } while (!echoString.equals("exit"));

        } catch (SocketException e){
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
     }
}
