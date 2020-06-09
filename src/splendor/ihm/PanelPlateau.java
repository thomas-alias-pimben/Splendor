package splendor.ihm;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import splendor.Controleur;

public class PanelPlateau extends JPanel
{
    private JPanel pnlCarteNoble;
    private JPanel pnlCarteN1;
    private JPanel pnlCarteN2;
    private JPanel pnlCarteN3;
    private JPanel pnlJeton;

    private JLabel[][] ensCarteEnJeu;
    private JLabel[] ensCarteNobleEnJeu;
    private JLabel[] ensJetonImage;
    private JLabel[] ensNbJeton;

    private JLabel lblDeck3;
    private JLabel lblDeck2;
    private JLabel lblDeck1;

    private Controleur ctrl;

    public PanelPlateau ( Controleur ctrl )
    {
        // Configuration début

        this.ctrl = ctrl;
        this.setLayout ( new GridLayout ( 5, 1 ) );
        

        // Création composant

       this.pnlCarteNoble = new JPanel();
       this.pnlCarteN1 = new JPanel();
       this.pnlCarteN2 = new JPanel();
       this.pnlCarteN3 = new JPanel();
       this.pnlJeton = new JPanel();

       this.ensCarteEnJeu = new JLabel[3][4];
       this.ensCarteNobleEnJeu = new JLabel[3];
       this.ensJetonImage = new JLabel[6];
       this.ensNbJeton = new JLabel[6];

       for ( int i = 0; i < 6; i++ )
       {
            this.ensJetonImage[i] = new JLabel();
            this.ensNbJeton[i] = new JLabel();
       }


       for ( int i = 0; i < 3; i++ )
       {
           for ( int j = 0; j < 4; j++ )
               this.ensCarteEnJeu[i][j] = new JLabel();
           this.ensCarteNobleEnJeu[i] = new JLabel();
       }

       this.lblDeck3 = new JLabel();
       this.lblDeck2 = new JLabel();
       this.lblDeck1 = new JLabel();

        // Configuration composants

        this.pnlCarteNoble.setLayout ( new GridLayout ( 1, 5 ) );
        this.pnlCarteN1.setLayout ( new GridLayout ( 1, 5 ) );
        this.pnlCarteN2.setLayout ( new GridLayout ( 1, 5 ) );
        this.pnlCarteN3.setLayout ( new GridLayout ( 1, 5 ) );

        //blanc=0 bleu=1  marron=2 rouge=3 vert=4 jaune=5
        this.ensJetonImage[0].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_blanc.png" ).getImage().getScaledInstance ( 100, 100, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[1].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_bleu.png" ).getImage().getScaledInstance ( 100, 100, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[2].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_marron.png" ).getImage().getScaledInstance ( 100, 100, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[3].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_rouge.png" ).getImage().getScaledInstance ( 100, 100, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[4].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_vert.png" ).getImage().getScaledInstance ( 100, 100, Image.SCALE_DEFAULT ) ) );
        this.ensJetonImage[5].setIcon ( new ImageIcon ( new ImageIcon ( "src/images/jeton_jaune.png" ).getImage().getScaledInstance ( 100, 100, Image.SCALE_DEFAULT ) ) );

        this.lblDeck3.setIcon ( new ImageIcon ( "src/images/dev_III_dos.png" ) );
        this.lblDeck2.setIcon ( new ImageIcon ( "src/images/dev_II_dos.png" ) );
        this.lblDeck1.setIcon ( new ImageIcon ( "src/images/dev_I_dos.png" ) );

        // Ajout aux panels

        this.pnlCarteNoble.add ( new JLabel("") );
        this.pnlCarteNoble.add ( new JLabel("") );
        for ( int i = 0; i < 3; i++ )
            this.pnlCarteNoble.add ( this.ensCarteNobleEnJeu[i] );


        this.pnlCarteN3.add ( this.lblDeck3 );
        for ( int i = 0; i < 4; i++ )
            this.pnlCarteN3.add ( this.ensCarteEnJeu[0][i] );


        this.pnlCarteN2.add ( this.lblDeck2 );
        for ( int i = 0; i < 4; i++ )
            this.pnlCarteN2.add ( this.ensCarteEnJeu[1][i] );


        this.pnlCarteN1.add ( this.lblDeck1 );
        for ( int i = 0; i < 4; i++ )
            this.pnlCarteN1.add ( this.ensCarteEnJeu[2][i] );


        for ( int i = 0; i < 6; i++ )
        {
            this.pnlJeton.add ( this.ensJetonImage[i] );
            this.pnlJeton.add ( this.ensNbJeton[i] );
        }
       
        // Ajouts finaux

        this.add ( this.pnlCarteNoble );
        this.add ( this.pnlCarteN3 );
        this.add ( this.pnlCarteN2 );
        this.add ( this.pnlCarteN1 );
        this.add ( this.pnlJeton );
    }

    public JLabel[][] getEnsJLabelC() { return this.ensCarteEnJeu; }
    public JLabel[] getEnsJLabelN() { return this.ensCarteNobleEnJeu; }
    public JLabel[] getEnsNbJeton() { return this.ensNbJeton; }
}