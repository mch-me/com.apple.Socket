package com.apple.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketTcp {
    public static void main(String[] args) {
        String message = "cyzsb!";
        try {
            String serverAddress = "10.3.17.53";
            int serverPort = 8899;
            Socket socket = new Socket(serverAddress,serverPort);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(message);
            bufferedWriter.flush();
            socket.shutdownOutput();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (ConnectException e){
            System.out.println("can not get connection, please try again!");
        }catch (IOException e){
            e.printStackTrace();;
        }
    }
}
