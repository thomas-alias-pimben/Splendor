package splendor.metier;


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
  public int getID()
  {
    return this.iD;
  }
  public String getLien()
  {
    return this.strLienImage;
  }

  public int[] getCout()
  {
    return this.iTabCout;
  }

  public int getCoutRouge()
  {
    return this.iTabCout[0];
  }

  public int getCoutBleu()
  {
    return this.iTabCout[1];
  }

  public int getCoutVert()
  {
    return this.iTabCout[2];
  }

  public int getCoutNoir()
  {
    return this.iTabCout[3];
  }

  public int getCoutBlanc()
  {
    return this.iTabCout[4];
  }

  public boolean estReserve()
  {
    return this.bReserve;
  }

  public String getGemme()
  {
    return this.strGemme;
  }
  public int getPntPrestige()
  {
    return this.iPntPrestige;
  }

  public String toString()
  {
    return ""+this.iD;
  }
}
