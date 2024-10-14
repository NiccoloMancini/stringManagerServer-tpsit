package it.itismeucci;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5673);
        do {
            Socket s = ss.accept();
            MyThread t = new MyThread(s);
            t.start();
        } while (true);
    }
}