package Moi;

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

/*
 * www.codeurjava.com
 */
public class Moi {
 
 public static void main(String[] test) {
 
 final ServerSocket serveurSocket ;
 final Socket clientSocket ;
 final BufferedReader in;
 final PrintWriter out;
 final Scanner sc=new Scanner(System.in);
 Joueur[] joueur=new Joueur[2];
joueur[0]=new Joueur(200, 0);
joueur[1]=new Joueur(200, 740);
        
Balle balle = new Balle(230,300,1,true);

Terrain terr = new Terrain(50, 70,balle,joueur);

Contener contener = new Contener(terr,null);
ListnerOnline list = new ListnerOnline(contener,1);
contener.setListnerOnline(list);

LaFrame laFrame = new LaFrame();
 

 
 try {
    System.out.println(contener.getMsg());
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
                    // if(Integer.valueOf(contener.getMsg())==100000){
                    //     System.out.println(contener.gettab().getJoueur()[0].getPosX());
                    //     out.println(contener.gettab().getJoueur()[0].getPosX());
                    //     out.flush();
                    // }
                    if(Integer.valueOf(contener.getMsg())==-100000){
                        System.out.println(contener.gettab().getJoueur()[0].getPosX());
                        out.println(contener.gettab().getJoueur()[0].getPosX());
                        out.flush();
                    }
                    if(Integer.valueOf(contener.getMsg())==900000){
                        for(int i=0; i<10; i++){
                            System.out.println(contener.gettab().getJoueur()[0].getPosX());
                            out.println(contener.gettab().getJoueur()[0].getPosX());
                            out.flush();
                            System.out.println(contener.gettab().getJoueur()[0].getPosX());
                            out.println(contener.gettab().getJoueur()[0].getPosX());
                            out.flush();
                        }
                    }
                    
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
            //tant que le client est connecté
            while(msg!=null){
                System.out.println("J2 : "+msg);
                msg = in.readLine();
                int pos = Integer.valueOf(msg);
                if(pos!=100000 && pos!=-100000){
                    contener.gettab().getJoueur()[0].setPosX(pos); 
                    if(contener.gettab().getBalle().getPosY()>650 && contener.gettab().getBalle().getPosY()<800 && pos==380)
                    {
                        contener.gettab().getBalle().setmoveB(3);
                    }
                    if(contener.gettab().getBalle().getPosY()>650 && contener.gettab().getBalle().getPosY()<800 && pos==0)
                    {
                        contener.gettab().getBalle().setmoveB(-3);
                    }
                }
                if(pos==-100000){
                    contener.gettab().getBalle().setpause(false);
                }
                if(pos == 100000){
                    contener.gettab().getBalle().setpause(true);
                    if(contener.gettab().getBalle().getPosY()>20 && contener.gettab().getBalle().getPosY()<50)
                    {
                        contener.gettab().getBalle().setmoveB(0);
                        pos=contener.gettab().getJoueur()[0].getPosX();
                    }
                    if(contener.gettab().getBalle().getPosY()>690 && contener.gettab().getBalle().getPosY()<800)
                    {
                        contener.gettab().getBalle().setmoveB(0);
                        pos=contener.gettab().getJoueur()[0].getPosX();
                    }

                }
                if(pos == 900000){
                    contener.gettab().getBalle().setpause(true);
                    pos=contener.gettab().getJoueur()[0].getPosX();
                }
                    contener.repaint();
                try {
                    // Thread.sleep(1000);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                 
            }
        //sortir de la boucle si le client a déconecté
        System.out.println("Client déconecté");
        //fermer le flux et la session socket
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