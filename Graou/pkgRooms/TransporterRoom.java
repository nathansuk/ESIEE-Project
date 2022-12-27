package Graou.pkgRooms;

import java.util.Random;
import Graou.pkgCore.GameEngine;
/**
 * TransporterRoom est une sorte de Room, qui une fois quittée téléporte dans une Room aléatoire du jeu.
 *
 * @author SUK Nathan
 */
public class TransporterRoom extends Room
{

    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public TransporterRoom(final String pDescription, final String pImage)
    {
        super(pDescription, pImage);
    } //TransporterRoom()
    
    /**
     * @param pDirection la direction (qui importe peu ici.)
     * @return la sortie générée aléatoirement
     */
    public Room getExit(final String pDirection)
    {
        return this.findRandomRoom();
    } // getExit()
    
    /**
     * @return Une room choisie aléatoirement dans l'ArrayList contenant toutes les pièces du jeu.
     */
    private Room findRandomRoom()
    {
        int vNbreRandom = new Random().nextInt(GameEngine.getRooms().size());
        Room vNextRoom = GameEngine.getRooms().get(vNbreRandom);
        if(vNextRoom.equals(this)) {
            return this.findRandomRoom();
        }
        else {
            return vNextRoom;
        }
    } // findRandomRoom()
}
