package Graou.pkgCore;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.net.URL;
import Graou.pkgCommands.Command;
import Graou.pkgRooms.Room;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling, SUK Nathan
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    private boolean    aGameRunning;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
        this.aGameRunning = true;
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "Images/" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( vIcon );
            this.aMyFrame.pack();
        }
    } // showImage(.)

    /**
     * Enable or disable input in the input field.
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // enable/disable
        if ( ! pOnOff ) { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener( this ); // won't react to entry
            this.aGameRunning = false;
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "GRAOU" ); // change the title
        this.aEntryField = new JTextField( 34 );

        /* Cr??ation du panel utilisateur */
        
        // Cr??ation des boutons et assignation des ??v??nements
        // En partie aid?? depuis : https://www.javatpoint.com/java-awt-button
        
        Panel vPanelUser = new Panel();
        Button vButtonDir = new Button("go east");
        Button vButtonDir2 = new Button("go west");
        Button vButtonDir3 = new Button("go north");
        Button vButtonDir4 = new Button("go south");
        Button vButtonInventaire = new Button("inventaire");
        Button vButtonBack = new Button("back");
        
        vButtonDir.addActionListener( this );
        vButtonDir2.addActionListener( this );
        vButtonDir3.addActionListener( this );
        vButtonDir4.addActionListener( this );
        vButtonInventaire.addActionListener( this );
        vButtonBack.addActionListener( this );
        
        GridLayout vBorder = new GridLayout(3, 2);
        
        vPanelUser.setLayout( vBorder );
        vPanelUser.add(vButtonDir);
        vPanelUser.add(vButtonDir2);
        vPanelUser.add(vButtonDir3);
        vPanelUser.add(vButtonDir4);
        vPanelUser.add(vButtonInventaire);
        vPanelUser.add(vButtonBack);
        

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        this.aLog.setMargin(new Insets(0, 5, 5, 0)); // SOURCE : https://stackoverflow.com/questions/2286881/jtextarea-and-jtextfield-internal-padding-on-text
        this.aLog.setLineWrap(true);                 // SOURCE : https://stackoverflow.com/questions/6878345/stop-horizontal-scrolling-in-jtextarea
        this.aLog.setWrapStyleWord(true);            // SOURCE : https://stackoverflow.com/questions/6878345/stop-horizontal-scrolling-in-jtextarea
        
        
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setForeground(Color.blue);
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        this.aImage.setMaximumSize(new Dimension(500, 300));

        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        vPanel.add( vPanelUser, BorderLayout.EAST );
        

        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener( this );

        // to end program when window is closed
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );

        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()
    
    /**
     * Evenement d??clench?? par l'IHM
     */
    public void actionPerformed( final ActionEvent pE ) 
    {   
        if(this.aGameRunning){
            if(pE.getSource() instanceof Button) {
                Button vBoutonClique = (Button)pE.getSource();
                Command vCommande = this.aEngine.getParser().getCommand( vBoutonClique.getLabel() );
                
                this.processCommand(vCommande);
            } else {
                this.processCommand(); // never suppress this line      
            }   
        } else {
            this.println("Le jeu est termin??.");
        }
    } // actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );
        
        boolean finished = false;
        
        Command command = this.aEngine.getParser().getCommand( vInput );
        if(command == null) {
            this.aEngine.getGui().println("Je n'ai pas compris...");
        } 
        else {
            finished = command.execute(this.aEngine.getPlayer());
        }
        
    } // processCommand()
    
    /**
     * M??thode processCommand surcharg??e pour effectuer les commandes depuis un fichier test.
     */
    public void processCommand(final Command vCommande)
    {
        
        boolean finished = false;

        if(vCommande == null) {
            this.aEngine.getGui().println("Commande inconnue");
        } 
        else {
            finished = vCommande.execute(this.aEngine.getPlayer());
        }
        
    }  //processCommand()
    
    /**
     * Rafra??chit l'interface quand un changement de room est effectu?? (image + affichage description)
     * Check ??galement si le joueur n'a plus de mouvement pour stoper le jeu.
     * 
     * @param pRoom la room dans laquelle le joueur se retrouve.
     */
    public void updateInterface( final Room pRoom )
    {
        this.println( pRoom.getLongDescription() );
        if ( pRoom.getImageName() != null )
            this.showImage( pRoom.getImageName() );
            
        if(!this.aEngine.getPlayer().resteMouvement()){
            this.println("La limite de mouvement a ??t?? atteinte. Vous avez perdu !");
            this.enable(false);   
        }
    }// updateInterface()
    
    /**
     * Affiche un message pour dire que le jeu a ??t?? gagn?? et d??sactive l'interface
     */
    public void gameIsWon()
    {
        this.println("Bravo ! Vous avez tu?? le loup, le jeu a ??t?? gagn?? :)");
        this.enable(false);
    }//gameIsWon()
    
    
    
} // UserInterface 
