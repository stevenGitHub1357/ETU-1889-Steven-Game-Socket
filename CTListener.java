package listener;

import affichage.*;
import affichage.*;
import compose.*;
import compose.Terrain;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.event.*;

public class CTListener implements KeyListener,MouseListener,ActionListener
{
    ChoixType ct;



    public CTListener(ChoixType ct)
    {
        this.ct=ct;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.ct.getOffLine()){
            Joueur[] joueur=new Joueur[2];
            joueur[0]=new Joueur(200, 0);
            joueur[1]=new Joueur(200, 740);
        
            Balle balle = new Balle(230,300,1,true);
            Terrain terr = new Terrain(500, 700,balle,joueur);
            
            Contener contener = new Contener(terr);
            LaFrame laframe = new LaFrame(contener,"PingPong OffLine");
        }
        if(e.getSource() == this.ct.getHote()) {
            System.out.println("Cree partie");
            try {
                Runtime.getRuntime().exec(new String[]{"cmd","/c","start","1-Moi.cmd","/k","java -jar \"","D:/ITU/S3/INF-203-Program Syst-(Mr Naina)/Jeux/\"",""});
            } catch (Exception ex) {
                ex.getMessage();
                ex.getStackTrace();
                System.out.println("hote erreur");
            }
            
        }
        if(e.getSource() == this.ct.getRejoindre()){
            System.out.println("rejoindre");
            try {
                Runtime.getRuntime().exec(new String[]{"cmd","/c","start","2-Toi.cmd","/k","java -jar \"","D:/ITU/S3/INF-203-Program Syst-(Mr Naina)/Jeux/\"",""}); 
            } catch (Exception ex) {
                ex.getMessage();
                ex.getStackTrace();
                System.out.println("erreur rejoindre");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x=(e.getX());
        int y=(e.getY());
        System.out.println("y="+x+"\t"+"x="+y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }  
}