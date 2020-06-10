package splendor.metier;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Deck
 * se comporte comme une pile de Carte
 * @author 
 */
public class Deck 
{
	//ensemble de carte du deck
    private ArrayList<Carte> deck;


    public Deck()
    {
        deck = new ArrayList<Carte>();

        //initialisation à faire
    }

    /*
     * Empile la carte passée en paramètre
     */
    public void empiler(Carte carte)
    {
        this.deck.add(carte);
    }

    //depiler
    /**
     * Dépile et retourne la carte du dessus de la pile
     * @return la carte du dessus de la pile
     */
    public Carte depiler()
    {
        return deck.remove(deck.size()-1);
    }


    //mélanger
    /**
     * Attribut une place aléatoire dans la pile pour chaque Carte
     */
    public void melanger()
    {
       Collections.shuffle(deck);
    }
    
}