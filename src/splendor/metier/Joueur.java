package splendor.metier;

import java.util.ArrayList;

public class Joueur 
{
	//pseudo du joueur
    private String nom;
    
    //ensemble de quantité de jeuton par couleur
    //0 pour blanc
    //1 pour bleu
    //2 pour marron
    //3 pour rouge
    //4 pour vert
    //5 pour jaune
    private int[] listJeton; 

    //liste de Carte du joueur
    private ArrayList<Carte> listCarte;
    
    //nombre de  point accumulé par le joueur
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

    /**
     * @return le nombre de jeton blanc
     */
	public int getNbBlanc() {
		return listJeton[0];
	}    
    
    /**
     * @return le nombre de jeton bleu
     */
	public int getNbBleu() {
		return listJeton[1];
	}   
	
    /**
     * @return le nombre de jeton marron
     */
	public int getNbMarron() {
		return listJeton[2];
	}   
	
    /**
     * @return le nombre de jeton rouge
     */
	public int getNbRouge() {
		return listJeton[3];
	}   
	
    /**
     * @return le nombre de jeton vert
     */
	public int getNbVert() {
		return listJeton[4];
	}   
	
    /**
     * @return le nombre de jeton jaune
     */
	public int getNbJaune() {
		return listJeton[5];
	}   
	  
}