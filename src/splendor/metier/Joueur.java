package splendor.metier;

import java.util.ArrayList;

public class Joueur 
{
    private String nom;
    private int[] listJeton; //blanc=0 bleu=1  marron=2 rouge=3 vert=4 jaune=5

    private ArrayList<Carte> listCarte;
    private int              nbPoint;

    public Joueur(String nom)
    {
        this.nom = nom;
        this.listJeton = new int[6]; 
        
        for (int i = 0; i < 5; i++) 
            this.listJeton[i] = 3;
        
        this.listJeton[5] = 0;
        
        
        this.listCarte = new ArrayList<Carte>();
        this.nbPoint = 0;

    }

	public int getNbBlanc() {
		return listJeton[0];
	}    
    
	public int getNbBleu() {
		return listJeton[1];
	}   
	
	public int getNbMarron() {
		return listJeton[2];
	}   
	
	public int getNbRouge() {
		return listJeton[3];
	}   
	
	public int getNbVert() {
		return listJeton[4];
	}   
	
	public int getNbJaune() {
		return listJeton[5];
	}   
	  
}