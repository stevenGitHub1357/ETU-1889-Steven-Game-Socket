package affichage;

import compose.*;
import listener.*;

import javax.swing.*;
import java.awt.*;
import java.net.http.WebSocket.Listener;

public class Contener extends JPanel{
    Terrain terr;
    String msg;
    Boolean verif;
    ListnerOnline list;

    public Contener(Terrain ta)
    {
        this.setLayout(null);
        this.terr=ta;
        this.propConteneur();
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    public Contener(Terrain ta,ListnerOnline list)
    {
        this.list=list;
        // list.setCont(this);
        this.setLayout(null);
        this.terr=ta;
        this.addKeyListener(list);
        this.addMouseListener(list);
        // this.propConteneurAction();
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public Terrain gettab()
    {
        return this.terr;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }


    public void propConteneur()
    {
        Listner Li = new Listner(this);
        this.addKeyListener(Li);
        this.addMouseListener(Li);
    }
    public void propConteneurAction()
    {
        // this.addKeyListener(this.list);
        // this.addMouseListener(this.list);
    }
    public ListnerOnline getListnerOnline(){
        return this.list;
    }
    public void setListnerOnline(ListnerOnline list){
        this.list = list;
    }


    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawLine(0, 360, 500, 360);

       //joueur
        g.setColor(Color.RED);
        g.fillRect(terr.getJoueur()[0].getPosX(), terr.getJoueur()[0].getPosY(), 80, 20);

        g.setColor(Color.BLUE);
        g.fillRect(terr.getJoueur()[1].getPosX(), terr.getJoueur()[1].getPosY(), 80, 20);

        //balle
        g.setColor(new Color(255,162,0));
        g.fillOval(this.terr.getBalle().getPosX(),this.terr.getBalle().getPosY(), 20, 20);
        try
            {
                Thread.sleep(25);
            }
        catch (Exception e){ }
        
        
        this.terr.getBalle().verif_depl_balle(this.terr);
        this.terr.butMarquer();
        this.terr.remise();
        

        this.repaint();

        g.setColor(Color.RED);
        g.setFont(new Font("Verdana",Font.BOLD,30));
        g.drawString(""+this.terr.getJoueur()[0].getScore(), 10, 350);

        g.setColor(Color.BLUE);
        g.setFont(new Font("Verdana",Font.BOLD,30));
        g.drawString(""+this.terr.getJoueur()[1].getScore(), 10, 390);

        this.addKeyListener(this.list);
        this.addMouseListener(this.list);

    }
}
