package affichage;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Modif{
    Contener contener;
    public Modif(Contener contener){
        this.contener=contener;
    }
    public void WriteChangeContenr(PrintWriter out,int msg, int j){
        if(msg==-100000){
            System.out.println(contener.gettab().getJoueur()[j].getPosX());
            out.println(contener.gettab().getJoueur()[j].getPosX());
            out.flush();
        }
        if(msg==900000 || msg==700000 || msg==600000 || msg==500000){
            for(int i=0; i<10; i++){
                System.out.println(contener.gettab().getJoueur()[j].getPosX());
                out.println(contener.gettab().getJoueur()[j].getPosX());
                out.flush();
            }
        }
        this.contener.repaint();
    }

    public void ReadChangeContener(String in,int j){
        int msg=Integer.valueOf(in);
        if(msg!=100000 && msg!=-100000){
            contener.gettab().getJoueur()[j].setPosX(msg); 
            
        }
        if(msg==-100000){
            contener.gettab().getBalle().setpause(false);
            contener.gettab().getBalle().setmoveB(0);
        }
        if(msg == 100000){
            contener.gettab().getBalle().setpause(true);
            if(contener.gettab().getBalle().getPosY()>20 && contener.gettab().getBalle().getPosY()<50)
            {
                contener.gettab().getBalle().setmoveB(0);
                msg=contener.gettab().getJoueur()[0].getPosX();
            }
            if(contener.gettab().getBalle().getPosY()>690 && contener.gettab().getBalle().getPosY()<800)
            {
                contener.gettab().getBalle().setmoveB(0);
                msg=contener.gettab().getJoueur()[j].getPosX();
            }

        }
        if(msg == 900000){
            contener.gettab().getBalle().setpause(true);
            msg=contener.gettab().getJoueur()[j].getPosX();
        }
        if(msg==600000){
            if(contener.gettab().getBalle().getPosY()>20 && contener.gettab().getBalle().getPosY()<50 && j==0)
            {
                contener.gettab().getBalle().setmoveB(2);
            }
            if(contener.gettab().getBalle().getPosY()>690 && contener.gettab().getBalle().getPosY()<800 && j==1)
            {
                contener.gettab().getBalle().setmoveB(2);
            }
            msg=contener.gettab().getJoueur()[j].getPosX();
            
        }

        if(msg == 700000){
            contener.gettab().getBalle().setpause(true);
            if(contener.gettab().getBalle().getPosY()>690 && contener.gettab().getBalle().getPosY()<800 && j==1)
            {
                contener.gettab().getBalle().setmoveB(0);
            }
            if(contener.gettab().getBalle().getPosY()>20 && contener.gettab().getBalle().getPosY()<50 && j==0)
            {
                contener.gettab().getBalle().setmoveB(0);
            }
            msg=contener.gettab().getJoueur()[j].getPosX();
            
        }

        if(msg==500000){
            if(contener.gettab().getBalle().getPosY()>20 && contener.gettab().getBalle().getPosY()<50 && j==0)
                {
                    contener.gettab().getBalle().setmoveB(-2);
                }
                if(contener.gettab().getBalle().getPosY()>690 && contener.gettab().getBalle().getPosY()<800 && j==1)
                {
                    contener.gettab().getBalle().setmoveB(-2);
                }
            }
            msg=contener.gettab().getJoueur()[j].getPosX();
        this.contener.repaint();
        

    }
}