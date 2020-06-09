package splendor.metier;

import java.io.File;
import java.util.ArrayList;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Initialisation
{
  private ArrayList Deck1 = new ArrayList<Carte>();
  private ArrayList Deck2 = new ArrayList<Carte>();
  private ArrayList Deck3 = new ArrayList<Carte>();
  private ArrayList DeckN = new ArrayList<Carte>();
  
  private static int iD = 0;


  public Initialisation()
  {
    File Fichier = new File("src/data/Cartes.data");

    String ligne;
    String[] separateur;

    int iIndice;
    String strLienImage;
    int iCoutRouge;
    int iCoutBleu;
    int iCoutVert;
    int iCoutNoir;
    int iCoutBlanc;
    int iPntPrestige;
    String strGeme;

    try {
      Scanner sc = new Scanner(Fichier);

      while(sc.hasNextLine())
      {
        ligne = sc.nextLine();
        separateur = ligne.split(" ");
        this.iD++;
        iIndice      = Integer.parseInt(separateur[0]);
        strLienImage = separateur[1];
        iCoutRouge   = Integer.parseInt(separateur[2]);
        iCoutBleu    = Integer.parseInt(separateur[3]);
        iCoutVert    = Integer.parseInt(separateur[4]);
        iCoutNoir    = Integer.parseInt(separateur[5]);
        iCoutBlanc   = Integer.parseInt(separateur[6]);
        iPntPrestige = Integer.parseInt(separateur[7]);
        strGeme      = separateur[8];
        System.out.println("test");
        switch(iIndice)
        {
          case 0:
            this.DeckN.add(new Carte(this.iD,strLienImage,iCoutRouge,iCoutBleu,iCoutVert,iCoutNoir,iCoutBlanc,iPntPrestige, ""));
            System.out.println("Carte Noble cree");
            break;
          case 1:
            this.Deck1.add(new Carte(this.iD,strLienImage,iCoutRouge,iCoutBleu,iCoutVert,iCoutNoir,iCoutBlanc,iPntPrestige,strGeme));
            System.out.println("Carte classe 1 cree");
            break;
          case 2:
            this.Deck2.add(new Carte(this.iD,strLienImage,iCoutRouge,iCoutBleu,iCoutVert,iCoutNoir,iCoutBlanc,iPntPrestige,strGeme));
            System.out.println("Carte classe 2 cree");
            break;
          case 3:
            this.Deck3.add(new Carte(this.iD,strLienImage,iCoutRouge,iCoutBleu,iCoutVert,iCoutNoir,iCoutBlanc,iPntPrestige,strGeme));
            System.out.println("Carte classe 3 cree");
            break;
          default:
            System.out.println("ERREUR CARTE");
            break;
        }
      }
    }
    catch(Exception e)
    {

    }
  }

  public ArrayList<Carte> getDeck1()
  {
    return this.Deck1;
  }
  public ArrayList<Carte> getDeck2()
  {
    return this.Deck2;
  }
  public ArrayList<Carte> getDeck3()
  {
    return this.Deck3;
  }
  public ArrayList<Carte> getDeckN()
  {
    return this.DeckN;
  }
  public void melanger(ArrayList<Carte> alCarte)
  {
    for (int i=0;i<5;i++)
    {
      Collections.shuffle(alCarte);
    }
  }
  public Carte piocher(ArrayList<Carte> alCarte)
  {
    if(alCarte == this.getDeck1())
    {
      return this.getDeck1().get(this.getDeck1().size()-1);
    }
    if (alCarte == this.getDeck2()) {
      return this.getDeck2().get(this.getDeck2().size()-1);
    }
    if (alCarte == this.getDeck3()) {
      return this.getDeck3().get(this.getDeck3().size()-1);
    }
    else{
      return this.getDeckN().get(this.getDeckN().size()-1);
    }
  }
}
