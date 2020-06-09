package splendor;

import splendor.ihm.FrameJoueur;
import splendor.ihm.FramePlateau;
import splendor.ihm.PanelPlateau;
import splendor.metier.Jeu;

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

    public static void main ( String[] args )
    {
        new Controleur();
    }
}