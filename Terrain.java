package compose;

public class Terrain{
    int largeur;
    int longueur;
    Balle balle;
    Joueur[] Joueur;
    int indice;
    String test;

    public Terrain(int l,int lo,Balle b,Joueur[] j)
    {
        this.setLargeur(l);
        this.setLongueur(lo);   
        this.setBalle(b);
        this.setJoueur(j);
        this.verif_ind(this.getBalle().getPosY());
        this.remise();
    }

    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }

    public int getLargeur()
    {
        return this.largeur;
    }

    public void setLargeur(int l)
    {
        this.largeur=l;
    }

    public int getLongueur()
    {
        return this.longueur;
    }

    public void setLongueur(int lo)
    {
        this.longueur=lo;
    }

    public Balle getBalle()
    {
        return this.balle;
    }

    public void setBalle(Balle b)
    {
        this.balle= b;
    }

    public Joueur[] getJoueur()
    {
        return this.Joueur;
    }

    public void setJoueur(Joueur[] j)
    {
        this.Joueur=j;
    }

    public int getindice()
    {
        return this.indice;
    }

    public void setindice(int i)
    {
        this.indice=i;
    }

    public void verif_ind(int y)
    {
        if (y == 0 )
        {
            this.setindice(1);
        }
        else
        {
            this.setindice(0);
        }
    }

    public void changer_ind()
    {
        if (this.getindice() == 0)
        {
            this.setindice(1);
        }
        else 
        {
            this.setindice(0);
        }
    }

    public void remise( )
    {
        if (this.getBalle().getPosX()<=0 || this.getBalle().getPosX()>=490){

            if(this.getBalle().getPosY()>390)
            {
            this.getBalle().setPosX(this.getJoueur()[0].getPosX()+20);
            this.getBalle().setPosY(this.getJoueur()[0].getPosY());
            this.getBalle().setsens(1);
            this.getBalle().setpause(false);
            this.getBalle().setmoveB(0);
            
            }
        

            if(this.getBalle().getPosY()<390)
            {
            this.getBalle().setPosX(this.getJoueur()[1].getPosX()+20);
            this.getBalle().setPosY(this.getJoueur()[1].getPosY());
            this.getBalle().setsens(1);
            this.getBalle().setpause(false);
            this.getBalle().setmoveB(0);
            
            }
        }
        if(this.getBalle().getPosY()>=720)
        {
            if(this.getBalle().getPosX()<this.getJoueur()[1].getPosX() | this.getBalle().getPosX()>this.getJoueur()[1].getPosX()+80)
            {
                this.getBalle().setPosX(this.getJoueur()[0].getPosX()+20);
                this.getBalle().setPosY(this.getJoueur()[0].getPosY());
                this.getBalle().setsens(1);
                this.getBalle().setpause(false);
                this.getBalle().setmoveB(0);
               
            }
        }
        if(this.getBalle().getPosY()<=20)
        {
            if(this.getBalle().getPosX()<this.getJoueur()[0].getPosX()| this.getBalle().getPosX()>this.getJoueur()[0].getPosX()+80)
            {
                this.getBalle().setPosX(this.getJoueur()[1].getPosX()+20);
                this.getBalle().setPosY(this.getJoueur()[1].getPosY());
                this.getBalle().setsens(1);    
                this.getBalle().setpause(false);
                this.getBalle().setmoveB(0);
               
            }
        }
        
    }

    public void butMarquer()
    {
      
        if (this.getBalle().getPosX()<=0 || this.getBalle().getPosX()>=490){

            if(this.getBalle().getPosY()>390)
            {

            int val1=this.getJoueur()[1].getScore();
                val1+=1;
                this.getBalle().setsens(-1);
               
            this.getJoueur()[1].setScore(val1);
            }
        
            if(this.getBalle().getPosY()<390)
            {
            int val2=this.getJoueur()[0].getScore();
                val2+=1;         
                this.getBalle().setsens(1);
                
            this.getJoueur()[0].setScore(val2);
            }
        }
        if(this.getBalle().getPosY()>=720)
        {
            if(this.getBalle().getPosX()<this.getJoueur()[1].getPosX() | this.getBalle().getPosX()>this.getJoueur()[1].getPosX()+80)
            {
                int val=this.getJoueur()[0].getScore();     
                val+=1;
                this.getJoueur()[0].setScore(val);
               
            }
        }
        if(this.getBalle().getPosY()<=20)
        {
            if(this.getBalle().getPosX()<this.getJoueur()[0].getPosX()| this.getBalle().getPosX()>this.getJoueur()[0].getPosX()+80)
            {
                int val=this.getJoueur()[1].getScore();
                val+=1;
                this.getJoueur()[1].setScore(val);
               
            }
        }
    }
}
