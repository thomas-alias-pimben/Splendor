package splendor.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;

import splendor.Controleur;

public class Jeu implements Serializable
{

	// 0 niveau 1, 1 niveau 2, 2 niveau 3, 3 noble
    private Deck[] decks;

    private int[] ensJetons; //blanc=0 bleu=1 marron=2 rouge=3 vert=4 jaune=5

    private ArrayList<Carte> alCarte;
    
    private Carte[][] ensCarte = new Carte[3][4];
    private Carte[] ensCarteNoble = new Carte[3];

    private Joueur j1;
    private Joueur j2;

    private Initialisation initDeck;

    private Controleur ctrl;

    //constructeur
    public Jeu ( Controleur ctrl )
    {
        this.ctrl = ctrl;
        this.initDeck = new Initialisation();
        initJeu();

        /*while ( !j1.aAuMoins15Points() || !j2.aAuMoins15Points() )
        {
            //tourDeJeu ( j1 );
        }*/
    }

    //methodes
    public void initJeu ()
    {
        initJeton();
        initJoueur();
        initCarte();
    }

    public void initJeton ()
    {
        this.ensJetons = new int[6];

        for( int i = 0; i < 5; i++ )
            this.ensJetons[i] = 4;
        
        this.ensJetons[5] = 5;

        for ( int i = 0; i < 6; i++ )
            this.ctrl.getPanelPlateau().getEnsNbJeton()[i].setText ( "" + this.ensJetons[i] );
    }

    public void initJoueur ()
    {
        this.j1 = new Joueur("J1");
        this.j2 = new Joueur("J2");
    }

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

    public void melanger()
    {
        for ( Deck temp:decks )
        	temp.melanger();
    }

    public Carte piocher ( int niveauDeck )
    {
        return decks[niveauDeck].depiler();
    }

    public Joueur getJoueur ( int numJoueur ) 
    { 
        if ( numJoueur == 1 ) 
            return this.j1;
        else 
            return this.j2; 
    }
}
