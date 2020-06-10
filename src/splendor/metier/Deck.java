package splendor.metier;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{

    private ArrayList<Carte> deck;


    public Deck()
    {
        deck = new ArrayList<Carte>();

        //initialisation à faire
    }

   public void empiler(Carte carte)
    {
        this.deck.add(carte);
    }

    //depiler
    public Carte depiler()
    {
        return deck.remove(deck.size()-1);
    }


    //mélanger
    public void melanger()
    {
       Collections.shuffle(deck);
    }
    
}