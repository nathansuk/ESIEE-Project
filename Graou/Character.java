package Graou;

import Graou.pkgRooms.Room;
/**
 * Représente un personnage non jouable, présent dans une pièce.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Character
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String aNom;
    private String aDialogue;
    private Room   aCurrentRoom;

    /**
     * Constructeur d'objets de classe Character
     */
    public Character(final String pNom, final String pDialogue, final Room pCurrentRoom)
    {
        // initialisation des variables d'instance
        this.aNom = pNom;
        this.aDialogue = pDialogue;
        this.aCurrentRoom = pCurrentRoom;
        
        //Lorsqu'un personnage est assigné dans une Room, on met à jour la liste des personnages de la Room
        this.aCurrentRoom.addCharacter(this);
    }

    public String getNom()
    {
        return this.aNom;
    }
    
    public String getDialogue()
    {
        return this.aDialogue;
    }
    
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
}
