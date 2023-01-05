package Graou;

import Graou.pkgRooms.Room;
/**
 * Représente un personnage non jouable, présent dans une pièce.
 *
 * @author Nathan SUK
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
        this.aCurrentRoom.addCharacter(pNom, this);
    }
    
    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom()
    {
        return this.aNom;
    } // getNom()
    
    /**
     * Retourne le dialogue du personnage
     * @return la/les ligne.s de dialogue du personnage
     */
    public String getDialogue()
    {
        return this.aDialogue;
    }
    
    /**
     * Retourne la pièce dans laquelle se trouve le personnage
     * @return la Room dans laquelle se trouve le personnage
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
}
