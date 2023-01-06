package Graou.pkgCore;

import java.util.ArrayList;
import Graou.Player;
import Graou.Character;
import Graou.pkgRooms.Room;
import Graou.pkgItems.BeamerItem;
import Graou.pkgItems.PotionForceItem;
import Graou.pkgItems.WeaponItem;
import Graou.pkgRooms.TransporterRoom;
import Graou.pkgItems.Item;

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
    
    /**
     * Retourne le tableau contenant toutes les Room du jeu
     * @return l'ArrayList contenant les rooms du jeu
     */
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
        this.aGui.updateInterface(this.aPlayer.getCurrentRoom());
    } // printWelcome()

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room entreeVillage, placePrincipale, placeGauche, placeDroite, placeNord, maison1, maison1Cellar, maison2, maison3, maison3attic, maison4, maison5, maison5cellar;

        // Initialisation des rooms
        entreeVillage = new Room("Vous êtes à l'entrée du village", "entreeVillage.png");
        placePrincipale = new Room("Vous êtes sur la place principale du village", "placeprincipale.png");
        placeGauche = new Room("Vous êtes sur la place à l'ouest du village", "placegauche.png");
        placeDroite = new Room("Vous êtes sur la place à l'est du village", "placedroite.png");
        placeNord = new Room("Vous êtes sur la place au nord du village", "placenord.png");
        
        maison1 = new Room("Vous êtes dans la maison du boulanger, une odeur émane du plancher.", "maison1.png");
        maison1Cellar = new Room("Vous êtes dans la cave du boulanger", "maison1cellar.png");
        
        maison2 = new TransporterRoom("Vous êtes dans la maison du forgeron, une aura étrange émane de cette maison...", "maison2.png");
        
        maison3 = new Room("Vous êtes dans la maison du bûcheron", "maison3.png");
        maison3attic = new Room("Vous êtes dans le grenier du bûcheron", "maison3attic.png");
        
        
        maison5 = new Room("Vous êtes dans le château du village.", "maison5.png");
        maison5cellar = new Room("Vous êtes dans les sous-sols du château.", "maison5cellar.png");
        
        // Initialisation des sorties
        entreeVillage.setExit("north", placePrincipale);
        
        //Sorties place principale
        placePrincipale.setExit("south", entreeVillage);
        placePrincipale.setExit("north", placeNord);
        placePrincipale.setExit("west", placeGauche);
        placePrincipale.setExit("east", placeDroite);
        
        //Sorties place nord
        placeNord.setExit("south", placePrincipale);
        placeNord.setExit("north", maison5);
        maison5.setExit("south", placeNord);
        maison5.setExit("down", maison5cellar);
        maison5cellar.setExit("up", maison5);
        
        
        //Sorties place west
        placeGauche.setExit("east", placePrincipale);
        placeGauche.setExit("south", maison3);
        maison3.setExit("north", placeGauche);
        maison3.setExit("up", maison3attic);
        maison3attic.setExit("down", maison3);
        
        //Sorties place est
        placeDroite.setExit("west", placePrincipale);
        placeDroite.setExit("north", maison1);
        maison1.setExit("south", placeDroite);
        maison1.setExit("down", maison1Cellar);
        maison1Cellar.setExit("up", maison1);
        placeDroite.setExit("east", maison2);
        maison2.setExit("west", placeDroite);
        
        //Création des items
        Item vBeamer = new BeamerItem("beamer", "Un mystérieux objet vous permettant de vous téléporter dans une room.", 10); 
        Item vPotion = new PotionForceItem("potion", "Une potion augmentant votre force", 10);
        Item vEpee = new WeaponItem("epee", "Une puissante épée permettant de tuer le loup", 10);
        
        //Ajout des items dans les rooms
        entreeVillage.getItems().ajouter(vPotion);
        maison5cellar.getItems().ajouter(vEpee);
        maison3attic.getItems().ajouter(vBeamer);
        
        //Ajout de toutes les pièces dans la liste des rooms du jeu.
        aRooms.add(entreeVillage);
        aRooms.add(placePrincipale);
        aRooms.add(placeGauche);
        aRooms.add(placeDroite);
        aRooms.add(placeNord);
        aRooms.add(maison1);
        aRooms.add(maison1Cellar);
        aRooms.add(maison2);
        aRooms.add(maison3);
        aRooms.add(maison3attic);
        aRooms.add(maison5);
        aRooms.add(maison5cellar);
        
        //Création des personnages
        Character vVillageois = new Character("Villageois", "Je pense que tu devrais ramasser cette potion afin de pouvoir transporter plus de choses", entreeVillage);
        Character vBucheron = new Character("Bucheron", "J'ai trouvé un objet étrange dans la rue, vous pouvez le prendre au grenier, je ne sais pas m'en servir..", maison3);
        Character vBoulanger = new Character("Boulanger", "En ce moment il y a une odeur bizarre dans cette boulangerie ! Je devrai arrêter de picoler vous pensez ?", maison1);
        Character vRoi = new Character("Roi", "Je suis un piètre guerrier, je ne peux chasser le loup, prenez mon épée dans les sous-sols et battez-vous !", maison5);
        Character vLoup = new Character("Loup", "Je suis invincible !! Meurt ! ", maison1Cellar);
        
        //Création du Player et assignation dans la Room de départ 
        this.aPlayer = new Player(entreeVillage);

    } // createRooms()
    
    
}
