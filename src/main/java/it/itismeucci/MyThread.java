package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread{
    Socket s;
    public MyThread (Socket s){
        this.s = s;
    }

    @Override
    public void run(){
        System.out.println("qualcuno si è collegato");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String scelta;
            String stringaRicevuta;
            do {
                scelta = in.readLine();
                stringaRicevuta = in.readLine();
                switch (scelta) {
                    case "1":
                        out.writeBytes(stringaRicevuta.toUpperCase() + "\n");
                        break;
                    case "2":
                        out.writeBytes(stringaRicevuta.toLowerCase() + "\n");
                        break;
                    case "3":
                        StringBuilder s = new StringBuilder(stringaRicevuta);
                        out.writeBytes(s.reverse()+ "\n");
                        break;
                    case "4":
                        out.writeBytes(stringaRicevuta.length() + "\n");
                        break;
                    case "5":
                        System.out.println("comunicazione terminata");
                        break;
                    default:
                        out.writeBytes("Errore, selezionare uno dei numeri");
                        break;
                }
            } while (!stringaRicevuta.equals("5"));
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
          
    }
}
