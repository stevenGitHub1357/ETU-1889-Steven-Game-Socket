package HoteSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import affichage.*;
import compose.*;
import compose.Terrain;
import listener.ListnerOnline;

public class HoteSocket {
 
 public static void main(String[] test) {
 
 final ServerSocket serveurSocket ;
 final Socket clientSocket ;
 final BufferedReader in;
 final PrintWriter out;

Joueur[] joueur=new Joueur[2];
joueur[0]=new Joueur(200, 0);
joueur[1]=new Joueur(200, 740);
        
Balle balle = new Balle(230,300,1,true);

Terrain terr = new Terrain(50, 70,balle,joueur);

Contener contener = new Contener(terr,null);
ListnerOnline list = new ListnerOnline(contener,1);
contener.setListnerOnline(list);
Modif modif = new Modif(contener);

LaFrame laFrame = new LaFrame();
 

 
 try {
    serveurSocket = new ServerSocket(5000);
    clientSocket = serveurSocket.accept();
    laFrame = new LaFrame(contener,"J1");
    out = new PrintWriter(clientSocket.getOutputStream());
    in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream()));

    Thread envoi= new Thread(new Runnable() {
        String msg;
        
        @Override
        public void run(){
            while(true)
            {
                    System.out.println(contener.getMsg());
                    out.println(contener.getMsg());
                    out.flush(); 
                    int msg=Integer.valueOf(contener.getMsg());
                    modif.WriteChangeContenr(out,msg,0);
                    
                    try {
                        // Thread.sleep(1000);
                    } catch (Exception e) {
                        //TODO: handle exception
                    } 
            }
        }
        });
 envoi.start();
 
Thread recevoir= new Thread(new Runnable() {
    String msg ;
    @Override
    public void run() {
        try {
            msg = in.readLine();
            while(msg!=null){
                System.out.println("J2 : "+msg);
                msg = in.readLine();
                modif.ReadChangeContener(msg,0);

                try {
                    // Thread.sleep(1000);
                } catch (Exception e) {
                    //TODO: handle exception
                } 
                 
            }
        System.out.println("J2 déconecté");
        out.close();
        clientSocket.close();
        serveurSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 });
 recevoir.start();
 }catch (IOException e) {
 e.printStackTrace();
 }
 }
}