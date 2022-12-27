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
        Panel vPanelUser = new Panel();
        Button buttonDir = new Button("go east");
        Button buttonDir2 = new Button("go west");
        Button button3 = new Button("inventaire");
        Label vLabel = new Label("Compteur de mouvement : ");
        GridLayout vBorder = new GridLayout(3, 2);
        vPanelUser.setLayout( vBorder );
        vPanelUser.add(buttonDir);
        vPanelUser.add(buttonDir2);
        vPanelUser.add(button3);
        vPanelUser.add(vLabel);
        

        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        vListScroller.setForeground(Color.blue);
        vListScroller.setPreferredSize( new Dimension(200, 200) );
        vListScroller.setMinimumSize( new Dimension(100,100) );

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();

        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( this.aImage, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH );
        //Places dispo : EAST WEST
        vPanel.add( vPanelUser, BorderLayout.EAST );
        

        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        // add some event listeners to some components
        this.aEntryField.addActionListener( this );
        buttonDir.addActionListener( this );

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
        this.processCommand(); // never suppress this line   
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
            this.aEngine.getGui().println("I don't understand...");
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
            this.aEngine.getGui().println("I don't understand...");
        } 
        else {
            finished = vCommande.execute(this.aEngine.getPlayer());
        }
        
    }  //processCommand()
    
    /**
     * Rafraîchit l'interface quand un changement de room est effectué (image + affichage description)
     * @param pRoom la room dans laquelle le joueur se retrouve.
     */
    public void updateRoom( final Room pRoom )
    {
        this.println( pRoom.getLongDescription() );
        if ( pRoom.getImageName() != null )
            this.showImage( pRoom.getImageName() );
    }
    
} // UserInterface 
