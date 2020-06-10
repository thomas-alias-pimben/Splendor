package splendor.metier;

/**
 * Classe Carte
 * classe qui rassemble toutes les propriété d'une Carte
 * @author
 */
public class Carte
{
  private String strLienImage;
  private String strGemme;
  private boolean bReserve;
  private int iPntPrestige;
  private int iD;
  private int[]  iTabCout = new int[5];

  public Carte(int iD,String strLienImage, int iCoutRouge,int iCoutBleu,int iCoutVert, int iCoutNoir, int iCoutBlanc,int iPntPrestige,String strGemme )
  {
    this.iD = iD;
    this.bReserve   = false;
    this.strLienImage  = strLienImage;
    this.iTabCout[0] = iCoutRouge;
    this.iTabCout[1] = iCoutBleu;
    this.iTabCout[2] = iCoutVert;
    this.iTabCout[3] = iCoutNoir;
    this.iTabCout[4] = iCoutBlanc;
  }

  /**
   * @return l'identifiant numérique de la Carte
   */
  public int getID()
  {
    return this.iD;
  }
  
  /**
   * @return le chemin de l'image de la carte
   */
  public String getLien()
  {
    return this.strLienImage;
  }

  /**
   * 0 pour blanc
   * 1 pour bleu
   * 2 pour marron
   * 3 pour rouge
   * 4 pour vert
   * 5 pour jaune
   * @return l'ensemble de quantité de jeton nécessaire à l'achat de la Carte
   */
  public int[] getCout()
  {
    return this.iTabCout;
  }

  /**
   * @return le cout en jeton rouge de la Carte
   */
  public int getCoutRouge()
  {
    return this.iTabCout[0];
  }

  /**
   * @return le cout en jeton bleu de la Carte
   */
  public int getCoutBleu()
  {
    return this.iTabCout[1];
  }

  /**
   * @return le cout en jeton vert de la Carte
   */
  public int getCoutVert()
  {
    return this.iTabCout[2];
  }

  /**
   * @return le cout en jeton marron de la Carte
   */
  public int getCoutNoir()
  {
    return this.iTabCout[3];
  }

  /**
   * @return le cout en jeton blanc de la Carte
   */
  public int getCoutBlanc()
  {
    return this.iTabCout[4];
  }

  /**
   * @return si l'état de la Carte est réservé
   */
  public boolean estReserve()
  {
    return this.bReserve;
  }

  /**
   * @return le nom de la gemme que représente cette Carte
   */
  public String getGemme()
  {
    return this.strGemme;
  }
  
  /**
   * @return le nombre de point de prestige de la Carte
   */
  public int getPntPrestige()
  {
    return this.iPntPrestige;
  }
  
  public String toString()
  {
    return ""+this.iD;
  }
}
