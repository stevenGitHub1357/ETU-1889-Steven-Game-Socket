package listener;

import affichage.*;
import compose.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.event.*;

public class ListnerOnline implements KeyListener,MouseListener
{
    Contener cont;
    int j=0;

    public ListnerOnline(Contener pan,int j)
    {
        this.cont=pan;
        this.j = j;
        this.cont.setMsg(""+this.cont.gettab().getJoueur()[0].getPosX());
        System.out.println("listner");
    }

    public ListnerOnline(){
        
    }

    public Contener getCont() {
        return cont;
    }
    public int getJ() {
        return j;
    }
    public void setCont(Contener cont) {
        this.cont = cont;
    }
    public void setJ(int j) {
        this.j = j;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
         //_________J1
         if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            this.cont.gettab().getJoueur()[this.j].setPosX(0);
            
            if(this.cont.gettab().getBalle().getPosY()>20 && this.cont.gettab().getBalle().getPosY()<50 && this.j==0)
            {
                this.cont.gettab().getBalle().setmoveB(-3);
            }
            if(this.cont.gettab().getBalle().getPosY()>690 && this.cont.gettab().getBalle().getPosY()<800 && this.j==1)

            {
                this.cont.gettab().getBalle().setmoveB(-3);
            }
            this.cont.setMsg(""+(this.cont.gettab().getJoueur()[this.j].getPosX()));
            this.cont.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            this.cont.gettab().getJoueur()[this.j].setPosX(380);

            if(this.cont.gettab().getBalle().getPosY()>20 && this.cont.gettab().getBalle().getPosY()<50 && this.j==0)
            {
                this.cont.gettab().getBalle().setmoveB(3);
            }
            if(this.cont.gettab().getBalle().getPosY()>690 && this.cont.gettab().getBalle().getPosY()<800 && this.j==1)
            {
                this.cont.gettab().getBalle().setmoveB(3);
            }
            this.cont.setMsg(""+(this.cont.gettab().getJoueur()[this.j].getPosX()));
            this.cont.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            this.cont.gettab().getBalle().setpause(true);
            if(this.cont.gettab().getBalle().getPosY()>20 && this.cont.gettab().getBalle().getPosY()<50)
            {
                this.cont.gettab().getBalle().setmoveB(0);
            }
            if(this.cont.gettab().getBalle().getPosY()>690 && this.cont.gettab().getBalle().getPosY()<800)
            {
                this.cont.gettab().getBalle().setmoveB(0);
            }
            this.cont.setMsg(""+100000);
            this.cont.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
                this.cont.gettab().getJoueur()[this.j].setPosX(200);
            

            if(this.cont.gettab().getBalle().getPosY()>20 && this.cont.gettab().getBalle().getPosY()<50)
            {
                this.cont.gettab().getBalle().setmoveB(0);
            }
            if(this.cont.gettab().getBalle().getPosY()>690 && this.cont.gettab().getBalle().getPosY()<800)
            {
                this.cont.gettab().getBalle().setmoveB(0);
            }
            this.cont.setMsg(""+(this.cont.gettab().getJoueur()[this.j].getPosX()));
            this.cont.repaint();
        }
        

        if (e.getKeyCode() == 32)
        {
            this.cont.gettab().getBalle().setpause(false);
            this.cont.setMsg(""+-100000);
        }
        if (e.getKeyCode() == KeyEvent.VK_A)
        {
            this.cont.gettab().getBalle().setpause(true);
            this.cont.setMsg(""+900000);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // int x=(e.getX());
        // int y=(e.getY());
        // System.out.println("y="+x+"\t"+"x="+y);
        // System.out.println("mouse");
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