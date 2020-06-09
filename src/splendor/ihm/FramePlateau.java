package splendor.ihm;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import splendor.Controleur;

public class FramePlateau extends JFrame
{
    private PanelPlateau panelPlateau;
    private Controleur ctrl;

    public FramePlateau ( Controleur ctrl )
    {
        this.ctrl = ctrl;
        this.panelPlateau = new PanelPlateau ( this.ctrl );

        this.add ( this.panelPlateau );
        this.addWindowListener ( new GereWindow       () );
		this.addComponentListener ( new GereDeplacerFrame() );
        this.setTitle ( "plateau" );            
        this.setSize ( 900, 1000 );              
        this.setLocation ( 509, 15 );
        this.pack();
        this.setVisible ( true );
    }

    public PanelPlateau getPanelPlateau() { return this.panelPlateau; }

	private class GereWindow extends WindowAdapter
	{
		public void windowClosing ( WindowEvent e )
		{
			FramePlateau.this.ctrl.fermer();
		}
	}

    private class GereDeplacerFrame extends ComponentAdapter
	{
		public void componentMoved ( ComponentEvent e )
		{
			FramePlateau.this.ctrl.moveFrame ( "P" );
		}
	}
}