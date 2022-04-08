package SocketProgramming.MultipleClientHandeling;

import java.io.*;
import java.net.Socket;

public class Client2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5555);
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = "", str2;
        while(!str1.equals("stop")){
            str1 = br.readLine();
            outputStream.writeUTF(str1);
            outputStream.flush();

            str2 = inputStream.readUTF();
            System.out.println("Server writes: "+ str2);
        }

        outputStream.close();
        br.close();
        socket.close();
    }
}
