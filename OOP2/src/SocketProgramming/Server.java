package SocketProgramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        Socket socket = serverSocket.accept();
        System.out.print("connected!");

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = "", str2;
        while(!str1.equals("stop")){
            str1 = inputStream.readUTF();
            System.out.println("Client writes: "+str1);

            str2 = br.readLine();
            outputStream.writeUTF(str2);
            outputStream.flush();
        }

        outputStream.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
