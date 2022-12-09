package compose;

public class Balle{

    int PosX;
    int PosY;
    int sens;
    int moveB;
    boolean bol;
    static int longueur = 720;
    static int largeur = 500;

    public Balle(int x,int y,int s,boolean bol)
    {
        this.bol=bol;
        this.PosX=x;
        this.PosY=y;
        this.setsens(s);
    }
    public void reinPos(int x ,int y)
    {
        this.PosX=x;
        this.PosY=y;
    }


    public int getmoveB()
    {
        return this.moveB;
    }

    
    public void setmoveB(int x)
    {
        this.moveB=x;
    }
//PosX____________________________________________________________________
    public int getPosX()
    {
        return this.PosX;
    }
    public void setPosX(int x)
    {
        this.PosX=x;
    }

//PosY____________________________________________________________________
    public int getPosY()
    {
        return this.PosY;
    }
    public void setPosY(int y)
    {
        this.PosY=y;
    }

//Sens____________________________________________________________________
    public int getsens()
    {
        return this.sens;
    }

    public void setsens(int s)
    {
        this.sens=s;
    }


    public void changer_sens()
    {
        if (this.getsens() == 1)
        {
            this.setsens(-1);
        }
        else
        {
            this.setsens(1);
        }
    }

    public boolean getpause()
    {
        return this.bol;
    }

    public void setpause(boolean boolea)
    {
        this.bol=boolea;
    }

    public void verif_depl_balle(Terrain t)
    {

        int x = this.PosX;
        int y = this.PosY;

        if (this.getPosY() >= longueur)
        {
            
            this.setsens(-1); 
        }
        
        if (this.getPosY() <= 20)
        {
            

            this.setsens(1);
        }

        int ind =t.getindice();
        this.deplacement_balle(this.getsens(),ind,t);
       
    }

    public void deplacement_balle(int sens,int ind,Terrain t)
    {
        if(this.bol==true)
        {
        int x = this.getPosX();
        int y = this.getPosY();
        if (this.getPosX()<=0 || this.getPosX()>=490)
        {
            // int val1=t.getJoueur()[1].getScore();
            // if(this.getPosY()>390){
            //     val1+=1;
            // }
            // t.getJoueur()[1].setScore(val1);

            x=t.getJoueur()[0].getPosX()+20;
            y=t.getJoueur()[0].getPosY()+20;
        }
        
        if (this.getPosX()<=0 || this.getPosX()>=490)
        {
            // int val2=t.getJoueur()[0].getScore();

            // if(this.getPosY()<390){
            //     val2+=1;
            // }
            // t.getJoueur()[0].setScore(val2);

            x=t.getJoueur()[1].getPosX()+20;
            y=t.getJoueur()[1].getPosY()-20;
        }
        if (sens == -1)
        {
            x+=(this.getmoveB());
            y-=10;
        }
        if (sens == 1)
        {
            x+=(this.getmoveB());
            y+=10;
        }

        if (sens == 0)
        {
            x=t.getJoueur()[ind].getPosX();
            y=t.getJoueur()[ind].getPosY();
            t.changer_ind();
        }

        if (sens == 99)
        {
            x = 400;
            y = 500;
        }
        this.setPosX(x);
        this.setPosY(y);
    }
    else{
        this.getPosX();
        this.getPosY();
    }
    }
    
   

}