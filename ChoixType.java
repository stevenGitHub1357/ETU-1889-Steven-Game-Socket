package affichage;

import javax.swing.*;
import java.awt.*;
import java.net.http.WebSocket.Listener;
import java.util.List;
import java.lang.reflect.Field;
import java.io.*;
import java.io.FileWriter;
import java.io.FileWriter;
import java.lang.Class;
import java.lang.management.ThreadInfo;
import java.lang.*;
import java.lang.reflect.*;
import java.awt.event.*;

import listener.*;

public class ChoixType extends JPanel{
    JButton offLine = new JButton("Game Offline");
    JButton onLine = new JButton("Game online");
    JButton hote = new JButton("Cree une partie");
    JButton rejoindre = new JButton("Rejoindre une partie");
    Boolean on = false;
    int joueur = 0;
    CTListener Ct = new CTListener(this);

    public ChoixType(){
        this.on = false;
        this.setLayout(null);
        this.allbutton();
    }

    public JButton getOffLine() {
        return offLine;
    }
    public int getJoueur() {
        return joueur;
    }
    public Boolean getOn() {
        return on;
    }
    public JButton getOnLine() {
        return onLine;
    }
    public JButton getHote() {
        return hote;
    }
    public JButton getRejoindre() {
        return rejoindre;
    }
    public void setOn(Boolean on) {
        this.on = on;
    }
    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }

    public void allbutton(){
        this.offLine.setBounds(130, 100, 200, 50);
        this.offLine.addActionListener(this.Ct);
        this.onLine.setBounds(130, 600, 200, 50);
        this.onLine.addActionListener(this.Ct);
        this.hote.setBounds(130, 300, 200, 50);
        this.hote.addActionListener(this.Ct);
        this.rejoindre.setBounds(130, 400, 200, 50);
        this.rejoindre.addActionListener(this.Ct);

        this.add(offLine);
        // this.add(onLine);
        this.add(hote);
        this.add(rejoindre);
        
    }
}
