package Graou.pkgCore;

import Graou.Player;
import Graou.pkgRooms.Room;
import Graou.pkgItems.BeamerItem;
import Graou.pkgItems.PotionForceItem;
import Graou.pkgRooms.TransporterRoom;
import Graou.pkgItems.Item;
import java.util.*;
import java.io.*;

/**
 *  Classe du moteur du jeu. 
 * 
 * @author  Michael Kolling and David J. Barnes and Nathan SUK
 */
public class GameEngine
{
    private static Parser aParser;
    private static UserInterface aGui;
    private Player aPlayer;
    private static ArrayList<Room> aRooms;

    /**
     * Constructeur
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aRooms = new ArrayList<Room>();
        this.createRooms();
    } // GameEngine()
    
    /**
     * @return l'interface graphique du jeu, est rendue accessible pour afficher des messages
     */
    public static UserInterface getGui()
    {
        return aGui;
    } // getGui()
    
    public static ArrayList<Room> getRooms()
    {
        return aRooms;
    }
    
    /**
     * Met en place l'interface utilisateur
     * @param pUserInterface l'interface utilisateur à instancier
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    } // setGui()
    
    /**
     * @return le Parser du moteur de jeu
     */
    public static Parser getParser()
    {
        return aParser;
    } // getParser()
    
    /**
     * @return le joueur
     */
    public Player getPlayer()
    {
        return this.aPlayer;
    } // getPlayer()
    
    /**
     *  Lance le jeu
     */
    public void play() 
    {            
        this.printWelcome();
    } // play()

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        this.aGui.print( "\n" );
        this.aGui.println( "Bienvenue dans le village de Esye." );
        this.aGui.println( "Une terrible malédiction plane sur ce petit village, vous êtes appelé pour résoudre ce mystère." );
        this.aGui.println( "Trouvez des indices afin de définir qui sont les personnes responsables de tous ces maux." );
        this.aGui.print( "\n" );
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
    } // printWelcome()

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room entreeVillage, placePrincipale, placeGauche, placeDroite, placeNord;
        Item cle, carte;

        // Initialisation des rooms
        entreeVillage = new Room("Vous êtes à l'entrée du village", "entree.png");
        placePrincipale = new Room("Vous êtes sur la place principale du village", "placeprincipale.png");
        placeGauche = new Room("Vous êtes sur la place à l'ouest du village", "placegauche.png");
        placeDroite = new Room("Vous êtes sur la place à l'est du village", "placedroite.png");
        placeNord = new TransporterRoom("Vous êtes sur la place au nord du village", "placenord.png");

        // Initialisation des sorties
        
        entreeVillage.setExit("north", placePrincipale);
        
        placePrincipale.setExit("south", entreeVillage);
        placePrincipale.setExit("north", placeNord);
        placePrincipale.setExit("west", placeGauche);
        placePrincipale.setExit("east", placeDroite);
        
        placeNord.setExit("south", placePrincipale);
        
        aRooms.add(entreeVillage);
        aRooms.add(placePrincipale);
        aRooms.add(placeGauche);
        aRooms.add(placeDroite);
        aRooms.add(placeNord);
        
        Item vCarte = new Item("carte", "carta", 100, 0.8);
        Item vBeamer = new BeamerItem("beamer", "Test description", 10, 10); 
        Item vPotion = new PotionForceItem("potion", "Test description", 10, 10);
        
        entreeVillage.getItems().ajouter(vPotion);
        
        placePrincipale.getItems().ajouter(vCarte);
        placePrincipale.getItems().ajouter(vBeamer);
        
        
                
        this.aPlayer = new Player(entreeVillage); // à déplacer
        this.aPlayer.addRoomToHistory(entreeVillage);// start game outside

    } // createRooms()

    
    

    
}
