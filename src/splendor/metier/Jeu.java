package splendor.metier;

import java.io.Serializable;

import javax.swing.ImageIcon;

import splendor.Controleur;

/**
 * Classe Jeu
 * classe qui gère le métier
 * @author 
 *
 */
public class Jeu implements Serializable
{

	//ensemble des decks
	// 0 pour niveau 1,
    // 1 pour niveau 2, 
    // 2 pour niveau 3, 
    // 3 pour noble
    private Deck[] decks;

    //ensemble de quantité de jeuton par couleur
    //0 pour blanc
    //1 pour bleu
    //2 pour marron
    //3 pour rouge
    //4 pour vert
    //5 pour jaune
    private int[] ensJetons; 

    //ensemble de carte du plateau
    //0 pour la ligne 
    //1 pour la ligne 
    //2 pour la ligne 
    private Carte[][] ensCarte = new Carte[3][4];
    
    //ensemble de carte noble du plateau
    private Carte[] ensCarteNoble = new Carte[3];

    private Joueur j1;
    private Joueur j2;

    private Controleur ctrl;

    //constructeur
    public Jeu ( Controleur ctrl )
    {
        this.ctrl = ctrl;
        new Initialisation();
        initJeu();

        /*while ( !j1.aAuMoins15Points() || !j2.aAuMoins15Points() )
        {
            //tourDeJeu ( j1 );
        }*/
    }

    //methodes
    /**
     * Apelle toute les méthodes d'initialisation
     */
    public void initJeu ()
    {
        initJeton();
        initJoueur();
        initCarte();
    }

    /**
     * Initialise les jetons pour une partie classique
     */
    public void initJeton ()
    {
        this.ensJetons = new int[6];

        for( int i = 0; i < 5; i++ )
            this.ensJetons[i] = 4;
        
        this.ensJetons[5] = 5;

        for ( int i = 0; i < 6; i++ )
            this.ctrl.getPanelPlateau().getEnsNbJeton()[i].setText ( "" + this.ensJetons[i] );
    }

    /**
     * Initialise les joueurs
     */
    public void initJoueur ()
    {
        this.j1 = new Joueur("J1");
        this.j2 = new Joueur("J2");
    }

    /**
     * Initialise les decks et le plateau pour une partie classique
     */
    public void initCarte ()
    {
    	Carte[][] ensDeck = null;
    	try {
    		ensDeck = Parser.getDeck();
		} catch (Exception e) {}
    	
    	this.decks = new Deck[4];
    	for ( int i=0; i<4; i++)
    		decks[i] = new Deck();
    	
    	for ( int i=0; i<4; i++ )
    		for( Carte carteTemp:ensDeck[i] )
    			decks[i].empiler(carteTemp);
        
    	
        melanger();

        for ( int i = 0; i < 3; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                if ( i == 0 )
                    this.ensCarte[i][j] = piocher ( 2 );
                if ( i == 1 )
                    this.ensCarte[i][j] = piocher ( 1 );
                if ( i == 2 )
                    this.ensCarte[i][j] = piocher ( 0 );

                this.ctrl.getPanelPlateau().getEnsJLabelC()[i][j].setIcon ( new ImageIcon ( this.ensCarte[i][j].getLien() ) );
            }
            this.ensCarteNoble[i] = piocher ( 3 );
            this.ctrl.getPanelPlateau().getEnsJLabelN()[i].setIcon ( new ImageIcon ( this.ensCarteNoble[i].getLien() ) );
        }
    }

    /*public void tourDeJeu ( Joueur j, int numChoix )
    {
        switch ( numChoix ) 
        {
            case 1 :
                prendre3Jetons( j );
                break;
            case 2 :
                prendre2Jetons( j );      
                break;
            case 3 :

                break;
            case 4 :

                break; 
        }
    }*/


    /*public void prendre3Jetons ( Joueur j, int numChoix, Jeton jeton1, Jeton jeton2, Jeton jeton3 )
    {
        //Jeton jeton1 =controleur machin
        //Jeton jeton2 =controleur machin
        //Jeton jeton3 =controleur machin    

        chercherJeton ( jeton1 ).remove( jeton1 );
        chercherJeton ( jeton2 ).remove( jeton2 );
        chercherJeton ( jeton3 ).remove( jeton3 );

        j.ajouterJeton ( jeton1 );
        j.ajouterJeton ( jeton2 );
        j.ajouterJeton ( jeton3 );

        while ( j.getNbJeton() > 10 )
        {
            // MESSAGE POUR DIRE QU IL DOIT SUPPRIMER UN JETON
            // DANS LIHM SUPPRIMER JETON
        }
    }*/

    /*public void prendre2jetons ( Joueur j )
    {
        //Jeton jeton =controleur machin  
        


        while ( chercherJeton ( jeton ).size() < 4 ) // A COMPLETER POUR LA CONDITION QUIL NY AIT PA ASSEZ DE JETON
        {
            // MESSAGE POUR DIRE QU IL Y A PAS ASSEZ DE JETON DANS CETTE COULEUR
            // DANS LIHM CHANGER DE JETON
            //Jeton jeton =controleur machin  
        } 

        chercherJeton ( jeton ).remove( jeton );
        chercherJeton ( jeton ).remove( jeton );

        j.ajouterJeton ( jeton );
        j.ajouterJeton ( jeton );
    }*/

    /*public void achatCarte ( Joueur j, Carte carte )
    {
        //Carte Carte =controleur machin  

        j.ajouterCarte ( carte );
        chercherCarte ( carte ) = 
    }*/


    // méthode utilitaire

    /*public ArrayList<Jeton> chercherJeton ( Jeton jeton )
    {
        switch ( jeton.getCouleur() )
        {
            case "vert" :
                return this.alJetonVert;
                break;
            case "bleu" :
                return this.alJetonBleu;
                break;
            case "rouge" :
                return this.alJetonRouge;
                break;
            case "blanc" :
                return this.alJetonBlanc;
                break;
            case "noir" :
                return this.alJetonNoir;
                break;
        }
    }*/

    /*public Carte chercherCarte ( Carte carte )
    {
        for ( Carte tmpCarte : this.alCarte )
        {
            if ( tmpCarte.equals ( carte ) )
                return tmpCarte;
        }
    }*/

    /**
     * Mélange tout les decks
     */
    public void melanger()
    {
        for ( Deck temp:decks )
        	temp.melanger();
    }

    /**
     * Retourne la Carte pour un deck choisi
     * 0 pour niveau 1,
     * 1 pour niveau 2, 
     * 2 pour niveau 3, 
     * 3 pour noble
     * @param niveauDeck id du deck, entre 0 et 3
     * @return la Carte au dessus du deck choisi 
     */
    public Carte piocher ( int niveauDeck )
    {
        return decks[niveauDeck].depiler();
    }

    /**
     * Retourne le joueur souhaité
     * 1 pour le joueur 1, par défaut joueur 2
     * @param numJoueur numéro du joueur souhaité
     * @return le Joueur
     */
    public Joueur getJoueur ( int numJoueur ) 
    { 
        if ( numJoueur == 1 ) 
            return this.j1;
        else 
            return this.j2; 
    }
}
