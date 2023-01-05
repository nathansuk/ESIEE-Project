package Graou;
import java.util.*;

import Graou.pkgRooms.Room;
import Graou.pkgItems.ItemList;
import Graou.pkgCore.GameEngine;
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
    private int aMouvementRestant;
    
    /**
     * Constructeur
     * @param pCurrentRoom La pièce actuelle où se trouve le joueur
     */
    public Player(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
        this.aRoomHistory = new Stack<Room>();
        this.aInventory = new ItemList();
        this.aMaxWeight = 10.0;         // Par défaut
        this.aMouvementRestant = 15;    // Par défaut*
    }// Player()
    
    /**
     * Retourne la room actuelle du joueur
     * @return La room actuelle du joueur
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    } // getCurrentRoom()
    
    /**
     * Retourne l'historique des pièces visitées
     * @return L'historique des pièces visitées
     */
    public Stack<Room> getRoomHistory()
    {
        return this.aRoomHistory;
    } // getRoomHistory()
    
    /**
     * Retourne l'inventaire du joueur
     * @return L'inventaire du joueur
     */
    public ItemList getItemList()
    {
        return this.aInventory;
    } // getItemList();
    
    /**
     * Retourne le poids maximum que peut porter le joueur
     * @return Le poids maximum de l'inventaire
     */
    public double getMaxWeight()
    {
        return this.aMaxWeight;
    }// getMaxWeight()
    
    /**
     * Modifie le poids maximum que le joueur peut porter
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
        this.aRoomHistory.pop();
    } //removeLastRoomFromHistory()
    
    /**
     * Fais retourner le joueur dans la pièce précédente de son historique
     */
    public void back()
    {
        if(!this.aRoomHistory.isEmpty()) { 
            this.setCurrentRoom(this.getRoomHistory().peek());
            this.removeLastRoomFromHistory();
            this.removeMouvement();
            GameEngine.getGui().updateInterface(this.aCurrentRoom);   
        } else {
            GameEngine.getGui().println("Vous ne pouvez pas revenir en arrière");  
        }
    } // back()
    
    /**
     * Fais changer le joueur de pièce
     */
    public void move(final Room pNextRoom)
    {
        this.addRoomToHistory(this.aCurrentRoom);
        this.setCurrentRoom(pNextRoom);
        this.removeMouvement();
        GameEngine.getGui().updateInterface(this.aCurrentRoom);
        
        //Si le joueur arrive dans la pièce où est le Loup et qu'il n'a pas d'arme (epee) logique potentiellement déplaçable dans une classe BossRoom
        if(pNextRoom.getCharacters().get("Loup") != null && this.getItemList().getItem("epee") == null){
            GameEngine.getGui().println("SACREBLEU ! Vous venez de rencontrer le loup et vous n'avez pas d'arme. Vous vous faite dévorer...");
            GameEngine.getGui().enable(false);
        }
    } // move()
    
    /**
     * Réduis de 1 le nombre de mouvement du joueur jusqu'à temps qu'il perde.
     */
    public void removeMouvement()
    {
        this.aMouvementRestant--;
    }// removeMouvement()
    
    /**
     * Retourne true si il reste des mouvements possibles pour le joueur, false sinon
     * @return true si le joueur possède encore des mouvements, false sinon
     */
    public boolean resteMouvement()
    {
        return this.aMouvementRestant > 0;
    } // resteMouvement()


    
    
}
