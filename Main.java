package active;

import affichage.*;
import compose.*;
import compose.Terrain;


public class Main{

    public static void main(String[] args) {

        Joueur[] joueur=new Joueur[2];
        joueur[0]=new Joueur(200, 0);
        joueur[1]=new Joueur(200, 740);
        
        Balle balle = new Balle(230,300,1,true);

        Terrain terr = new Terrain(500, 700,balle,joueur);

        // Contener contener = new Contener(terr);

        // LaFrame laframe = new LaFrame(contener,"ok");

    }
}