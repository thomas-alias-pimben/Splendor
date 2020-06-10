package splendor;

import splendor.ihm.FrameJoueur;
import splendor.ihm.FramePlateau;
import splendor.ihm.PanelPlateau;
import splendor.metier.Jeu;
import java.io.*;

public class Controleur 
{
    private FrameJoueur frameJoueur1;
    private FrameJoueur frameJoueur2;
    private FramePlateau framePlateau;

    private Jeu jeu;

    public Controleur()
    {
        this.framePlateau = new FramePlateau ( this );
        this.jeu = new Jeu ( this );
        this.frameJoueur1 = new FrameJoueur ( 1, this, this.jeu.getJoueur ( 1 ) );
        this.frameJoueur2 = new FrameJoueur ( 2, this, this.jeu.getJoueur ( 2 ) );
    }

    public void moveFrame ( String orig )
	{
		java.awt.Point p;

		if ( orig.equals ("P") && this.framePlateau != null && this.frameJoueur1 != null && this.frameJoueur2 != null )
		{
			p = this.framePlateau.getLocation();
			this.frameJoueur1.setLocation ( p.x - 470, p.y + 1 );
			this.frameJoueur2.setLocation ( p.x + 770, p.y + 1 );
		}
    }
    
    public void fermer ()
	{
		this.frameJoueur1.dispose();
		this.frameJoueur2.dispose();
    }
    
    public Jeu getJeu() { return this.jeu; }
    public PanelPlateau getPanelPlateau() { return this.framePlateau.getPanelPlateau(); }

    public void sauvegarder(String nomFichier)
    {
        try 
        {
            ObjectOutputStream out = new ObjectOutputStream(  new FileOutputStream( (nomFichier + ".data") )  );//l'objet qui écrit dans "nomfichier".dat

            out.writeObject(jeu);//on crée l'objet dans "nomfichier".dat
            out.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

    }

    public void charger(String nomFichier)
    {
        try {

             ObjectInputStream in = new ObjectInputStream(  new FileInputStream( (nomFichier + ".data") )  );//l'objet qui lit "nomfichier".dat

             this.jeu = (Jeu)in.readObject();//on lit l'objet de "nomfichier".dat
             in.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main ( String[] args )
    {
        new Controleur();
    }
}