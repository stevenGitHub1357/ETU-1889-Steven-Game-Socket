package compose;

import affichage.LaFrame;

public class Joueur{
    int PositionX;
    int PositionY;
    int score=0;


    public Joueur(int x,int y)
    {
        this.PositionX=x;
        this.PositionY=y;
        this.setPosX(x);
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getPosX()
    {
        return this.PositionX;
    }

    public int getPosY()
    {
        return this.PositionY;
    }

    public void setPosX(int x)
    {
        this.PositionX=x;
        this.PositionX=this.PositionX-this.move_left()+this.move_right();
    }

    public void reinPos(int x ,int y)
    {
        this.PositionX=x;
        this.PositionY=y;
    }

    public int move_left()
    {
        this.PositionX =this.PositionX-6;
        return this.PositionX;
    }

    public int  move_right()
    {
       this.PositionX =this.PositionX+6;
        return this.PositionX;
    }

    public int move_left(int x)
    {
        this.PositionX =this.PositionX-x;
        return this.PositionX;
    }

    public int  move_right(int x)
    {
       this.PositionX =this.PositionX+x;
        return this.PositionX;
    }
    
}
    