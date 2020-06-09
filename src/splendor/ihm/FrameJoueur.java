package splendor.ihm;

import javax.swing.JFrame;

import splendor.Controleur;
import splendor.metier.Joueur;

public class FrameJoueur extends JFrame
{
    private PanelJoueur panelJoueur;
    private Controleur ctrl;
    private Joueur joueur;
    
    public FrameJoueur ( int numJoueur, Controleur ctrl, Joueur joueur )
    {
        this.ctrl = ctrl;
        this.joueur = joueur;
        this.panelJoueur = new PanelJoueur ( this.ctrl, this.joueur );

        this.add ( this.panelJoueur );
        if ( numJoueur == 1 ) this.setTitle ( "Joueur 1" ); else this.setTitle ( "Joueur 2" );
        this.setSize  ( 600, 300 ); 
        this.setUndecorated(true);
        this.setVisible ( true ); 
        this.pack();
    }
}