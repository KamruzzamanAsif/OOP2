package SocketProgramming.MultipleClientHandeling;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);

        while(true){
            Socket socket = serverSocket.accept();
            System.out.print("Client connected!");
            new ThreadServer(socket);
        }
    }
}
