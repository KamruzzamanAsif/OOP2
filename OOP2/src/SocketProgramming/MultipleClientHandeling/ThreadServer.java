package SocketProgramming.MultipleClientHandeling;

import java.io.*;
import java.net.Socket;

public class ThreadServer implements Runnable{
    Socket socket;
    Thread thread;

    public ThreadServer(Socket socket){
        this.socket = socket;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = "", str2 = null;
        while(!str1.equals("stop")){
            try {
                str1 = inputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client writes: "+str1);

            try {
                str2 = br.readLine();
                outputStream.writeUTF(str2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            outputStream.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
