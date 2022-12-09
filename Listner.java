package listener;

import affichage.*;
import compose.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.event.*;

public class Listner implements KeyListener,MouseListener
{
    Contener cont;
    int j=0;

    public Listner(Contener pan)
    {
        this.cont=pan;
        this.cont.setMsg(""+this.cont.gettab().getJoueur()[0].getPosX());
    }

    @Override
    public void keyPressed(KeyEvent e) {
         //_________J1
         if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            this.cont.gettab().getJoueur()[0].move_left();

            if(this.cont.gettab().getBalle().getPosY()>20 && this.cont.gettab().getBalle().getPosY()<50)
            {
                this.cont.gettab().getBalle().setmoveB(-3);
            }
            // this.cont.gettab().getBalle().setPosX(x+100);
            // System.out.println("left");
            this.cont.setMsg(""+this.cont.gettab().getJoueur()[0].getPosX());
            this.cont.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            this.cont.gettab().getJoueur()[0].move_right();

            if(this.cont.gettab().getBalle().getPosY()>20 && this.cont.gettab().getBalle().getPosY()<50)
            {
                this.cont.gettab().getBalle().setmoveB(3);
            }
            // System.out.println("rigth");
            this.cont.setMsg(""+this.cont.gettab().getJoueur()[0].getPosX());
            this.cont.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            this.cont.gettab().getBalle().setpause(true);
            if(this.cont.gettab().getBalle().getPosY()>20 && this.cont.gettab().getBalle().getPosY()<50)
            {
                this.cont.gettab().getBalle().setmoveB(0);
            }
            // System.out.println("down");
            this.cont.setMsg("down");
            this.cont.repaint();
        }
        

        //_________J2
        if (e.getKeyCode() == KeyEvent.VK_Q)
        {
            this.cont.gettab().getJoueur()[1].move_left();

            if(this.cont.gettab().getBalle().getPosY()>690 && this.cont.gettab().getBalle().getPosY()<800)

            {
                this.cont.gettab().getBalle().setmoveB(-3);
            }
            // System.out.println("2left");
            this.cont.setMsg("2left");
            this.cont.repaint();
        }

        if (e.getKeyCode() == KeyEvent.VK_D)
        {
            this.cont.gettab().getJoueur()[1].move_right();

            if(this.cont.gettab().getBalle().getPosY()>690 && this.cont.gettab().getBalle().getPosY()<800)

            {
                this.cont.gettab().getBalle().setmoveB(3);
            }
            // System.out.println("2right");
            this.cont.setMsg("2rigth");
            this.cont.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_Z)
        {

            this.cont.gettab().getBalle().setpause(true);
            if(this.cont.gettab().getBalle().getPosY()>690 && this.cont.gettab().getBalle().getPosY()<800)
            {
                this.cont.gettab().getBalle().setmoveB(0);
            }
            // System.out.println("2down");
            this.cont.setMsg("2down");
            this.cont.repaint();
        }

        if (e.getKeyCode() == 32)
        {
            this.cont.gettab().getBalle().setpause(false);
            // System.out.println("Pause");
            this.cont.setMsg("Pause");
        }
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