package affichage;

import compose.*;

import javax.swing.JFrame;
import javax.swing.*;

public class LaFrame extends JFrame{
   String nom;

    public LaFrame(JPanel cont,String nom){

        this.nom=nom;
        this.setContentPane(cont);
        this.propFrame();
        
        
    }

    public LaFrame(){}

    
    public void propFrame()
    {
        

        setTitle(nom);
        setSize(500, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setVisible(true);

    }
}