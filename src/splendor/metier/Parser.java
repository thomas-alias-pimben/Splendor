package splendor.metier;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    
    public static Carte[][] getDeck() throws Exception
    {        
        //création d'un tableau de List
        ArrayList<Carte>[] tab = new ArrayList[4];
        for ( int i=tab.length; i>0; i-- )
        	tab[i-1] = new ArrayList<Carte>();
        
        //initialiser les List avec le .data
        Scanner sc = new Scanner( new File("src/data/Cartes.data") );
        String[] data;
        int id;
        
        while ( sc.hasNextLine() )
        {
            data = sc.nextLine().split( " " );
            try
            {
	            id = Integer.parseInt(data[0]);
	            tab[ id-1 ].add( new Carte( id
	            						, data[1]
	            						, Integer.parseInt(data[2])
	            						, Integer.parseInt(data[3])
	            						, Integer.parseInt(data[4])
	            						, Integer.parseInt(data[5])
	            						, Integer.parseInt(data[6])
	            						, Integer.parseInt(data[7])
	            						, data[8]) );
            } catch (Exception e) {}
        }
        
        sc.close();
        
        //transformation de tableau de List en tableau à deux dimensions
        Carte[][] deck = new Carte[4][];
        
        for( int i=0; i<4; i++ )
        {
        	deck[i] = new Carte[tab[i].size()];
        	deck[i] = tab[i].toArray( deck[i] );
        }        
        
        return deck;
    }
}