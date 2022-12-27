package Graou;
import java.util.*;

import Graou.pkgRooms.Room;
import Graou.pkgItems.ItemList;
/**
 * Classe représentant le joueur.
 *
 * @author Nathan SUK
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aCurrentRoom;
    private Stack<Room> aRoomHistory;
    private ItemList aInventory;
    private double aMaxWeight;
    
    /**
     * Constructeur
     * @param pCurrentRoom La pièce actuelle où se trouve le joueur
     */
    public Player(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
        this.aRoomHistory = new Stack<Room>();
        this.aInventory = new ItemList();
        this.aMaxWeight = 0;
    }// Player()
    
    /**
     * @return La room actuelle du joueur
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    } // getCurrentRoom()
    
    /**
     * @return L'historique des pièces visitées
     */
    public Stack<Room> getRoomHistory()
    {
        return this.aRoomHistory;
    } // getRoomHistory()
    
    /**
     * @return L'inventaire du joueur
     */
    public ItemList getItemList()
    {
        return this.aInventory;
    } // getItemList();
    
    /**
     * @return Le poids maximum de l'inventaire
     */
    public double getMaxWeight()
    {
        return this.aMaxWeight;
    }// getMaxWeight()
    
    /**
     * @param pMaxWeight La nouvelle valeur de poids maximum
     */
    public void setMaxWeight( final double pMaxWeight )
    {
        this.aMaxWeight = pMaxWeight;
    } // setMaxWeight()
    
    /**
     * @param pCurrentRoom Change la pièce actuelle où se trouve le joueur
     */
    public void setCurrentRoom( final Room pCurrentRoom )
    {
        this.aCurrentRoom = pCurrentRoom;
    } // setCurrentRoom()
    
    /**
     * Ajoute une nouvelle room dans l'historique du joueur
     * @param pNewRoom 
     */
    public void addRoomToHistory( final Room pNewRoom )
    {
        this.aRoomHistory.push(pNewRoom);
    } //addRoomToHistory()
    
    /**
     * Retire la dernière pièce dans la stack
     */
    public void removeLastRoomFromHistory()
    {
        if( this.aRoomHistory.size() > 1 ) {
            this.aRoomHistory.pop();
        }    
    } //removeLastRoomFromHistory()
    
    /**
     * Fais retourner le joueur dans la pièce précédente de son historique
     */
    public void back()
    {
        this.removeLastRoomFromHistory();
        this.setCurrentRoom(this.getRoomHistory().peek());
    } // back()
    
    /**
     * Fais changer le joueur de pièce
     */
    public void move(final Room pNextRoom)
    {
        this.setCurrentRoom(pNextRoom);
        this.addRoomToHistory(pNextRoom);
    }


    
    
}
