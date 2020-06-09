package splendor.ihm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import splendor.Controleur;
import splendor.metier.Joueur;

public class PanelJoueur extends JPanel
{
    private JPanel pnlHaut;
    private JPanel pnlMilieu;
    private JPanel pnlBas;

    private JPanel pnlInterMilieu;
    private JPanel pnlInterBas;

    private ButtonGroup btngrpRBchoix;

    private JLabel[] ensJetonImage;
    private JLabel[] ensNbJeton;

    private JRadioButton rbChoix1;
    private JRadioButton rbChoix2;
    private JRadioButton rbChoix3;
    private JRadioButton rbChoix4;

    private JButton btnValiderChoix;

    private ArrayList<JLabel> alCarte;

    private Controleur ctrl;
    private Joueur joueur;

    public PanelJoueur ( Controleur ctrl, Joueur joueur )
    {
        // Configuration début

        this.ctrl = ctrl;
        this.joueur = joueur;
        this.setLayout( new BorderLayout() );

        // Création composant

        this.pnlHaut = new JPanel();
        this.pnlMilieu = new JPanel();
        this.pnlBas = new JPanel();

        this.pnlInterMilieu = new JPanel();
        this.pnlInterBas = new JPanel();

        this.ensJetonImage = new JLabel[6];
        this.ensNbJeton = new JLabel[6];
 
        for ( int i = 0; i < 6; i++ )
        {
             this.ensJetonImage[i] = new JLabel();
             this.ensNbJeton[i] = new JLabel();
        }

        this.btngrpRBchoix = new ButtonGroup();

        this.rbChoix1 = new JRadioButton ( "Prendre 3 jetons de couleurs différentes" );
        this.rbChoix2 = new JRadioButton ( "Prendre 2 jetons de même couleur" );
        this.rbChoix3 = new JRadioButton ( "Réserver une carte développement" );
        this.rbChoix4 = new JRadioButton ( "Acheter une carte développement" );

        this.btnValiderChoix = new JButton ( "Ok" );

        this.alCarte = new ArrayList<JLabel>();

        // Configuration composants


        this.pnlInterMilieu.setLayout ( new GridLayout ( 4, 1 ) );

        //blanc=0 bleu=1  marron=2 rouge=3 vert=4 jaune=5
        this.ensJetonImage[0].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_blanc.png" ).getImage().getScaledInstance ( 50, 50, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[1].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_bleu.png" ).getImage().getScaledInstance ( 50, 50, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[2].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_marron.png" ).getImage().getScaledInstance ( 50, 50, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[3].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_rouge.png" ).getImage().getScaledInstance ( 50, 50, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[4].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_vert.png" ).getImage().getScaledInstance ( 50, 50, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[5].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_jaune.png" ).getImage().getScaledInstance ( 50, 50, Image.SCALE_DEFAULT ) ) );

        this.btngrpRBchoix.add ( this.rbChoix1 );
        this.btngrpRBchoix.add ( this.rbChoix2 );
        this.btngrpRBchoix.add ( this.rbChoix3 );
        this.btngrpRBchoix.add ( this.rbChoix4 );  
        
        int cpt = 1;
        while ( cpt * 4 < this.alCarte.size() )
        {
            cpt++;
        }

        this.pnlInterBas.setLayout ( new GridLayout ( cpt, 4 ) );

        // Ajout aux panels

        this.pnlHaut.add ( this.ensJetonImage[0] );
        this.pnlHaut.add ( new JLabel ( ""+this.joueur.getNbBlanc() ) );
        this.pnlHaut.add ( this.ensJetonImage[1] );
        this.pnlHaut.add ( new JLabel ( ""+this.joueur.getNbBleu() ) );
        this.pnlHaut.add ( this.ensJetonImage[2] );
        this.pnlHaut.add ( new JLabel ( ""+this.joueur.getNbMarron() ) );
        this.pnlHaut.add ( this.ensJetonImage[3] );
        this.pnlHaut.add ( new JLabel ( ""+this.joueur.getNbRouge() ) );
        this.pnlHaut.add ( this.ensJetonImage[4] );
        this.pnlHaut.add ( new JLabel ( ""+this.joueur.getNbVert() ) );
        this.pnlHaut.add ( this.ensJetonImage[5] );
        this.pnlHaut.add ( new JLabel ( ""+this.joueur.getNbJaune() ) );

        this.pnlInterMilieu.add ( this.rbChoix1 );
        this.pnlInterMilieu.add ( this.rbChoix2 );
        this.pnlInterMilieu.add ( this.rbChoix3 );
        this.pnlInterMilieu.add ( this.rbChoix4 );

        this.pnlMilieu.add ( this.pnlInterMilieu );
        this.pnlMilieu.add ( this.btnValiderChoix );

        this.pnlBas.add ( this.pnlInterBas );

        // Ajouts finaux

        this.add ( this.pnlHaut, BorderLayout.NORTH );
        this.add ( this.pnlMilieu, BorderLayout.CENTER );
        this.add ( this.pnlBas, BorderLayout.SOUTH );
    }
}