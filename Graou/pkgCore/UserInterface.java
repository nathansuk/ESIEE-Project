package Graou.pkgCore;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;
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

        /* Création du panel utilisateur */
        
        // Création des boutons et assignation des évènements
        // En partie aidé depuis : https://www.javatpoint.com/java-awt-button
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
        //Places dispo : EAST WEST
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
     * Evenement déclenché par l'IHM
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
            this.println("Le jeu est terminé.");
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
     * Méthode processCommand surchargée pour effectuer les commandes depuis un fichier test.
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
     * Rafraîchit l'interface quand un changement de room est effectué (image + affichage description)
     * Check également si le joueur n'a plus de mouvement pour stoper le jeu.
     * 
     * @param pRoom la room dans laquelle le joueur se retrouve.
     */
    public void updateInterface( final Room pRoom )
    {
        this.println( pRoom.getLongDescription() );
        if ( pRoom.getImageName() != null )
            this.showImage( pRoom.getImageName() );
            
        if(!this.aEngine.getPlayer().resteMouvement()){
            this.println("La limite de mouvement a été atteinte. Vous avez perdu !");
            this.enable(false);   
        }
    }// updateInterface()
    
    /**
     * Affiche un message pour dire que le jeu a été gagné et désactive l'interface
     */
    public void gameIsWon()
    {
        this.println("Bravo ! Vous avez tué le loup, le jeu a été gagné :)");
        this.enable(false);
    }//gameIsWon()
    
    
    
} // UserInterface 
