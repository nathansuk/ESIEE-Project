package Graou.pkgRooms;

import Graou.pkgItems.ItemList;
import java.util.HashMap;
import java.util.Set;
/**
 * Classe Room - un lieu du jeu d'aventure.
 *
 * @author Nathan SUK
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    private ItemList aItems;
    private String aImageName;
    
    /**
     * Constructeur
     * @param pDescription description de la pièce
     * @param pImage l'image de la room
     */
    public Room(final String pDescription, final String pImage)
    {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aItems = new ItemList();
        this.aImageName = pImage;
    }// Room()
    
    /**
     * @return la description de la room
     */
    public String getDescription()
    {
        return this.aDescription;
    }// getDescription()

    /**
     * @return la liste des objets se trouvant dans la room
     */
    public ItemList getItems()
    {
        return this.aItems;
    } // getItems()
    
    /**
     * Set one exit for one room.
     * @param String The direction of the exit.
     * @param Room The room attached to this exit. 
     */
    public void setExit(final String pDirection, final Room pRoom)
    {
        this.aExits.put(pDirection, pRoom);
    } // setExits()
    
    /**
     * @return the exit corresponding to the direction
     * @param String The direction of the exit.
     */
    public Room getExit(String pDirection)
    {
        return this.aExits.get(pDirection);
    } // getExit()
    
    
    /**
     * @return all exits of a room.
     */
    public String getExitString()
    {
        String vString = "Sorties : ";
        
        Set<String> vExits = this.aExits.keySet();
        for(String vSortie : vExits){
            vString += vSortie+", ";
        }
        
        return vString;
    } // getExitString()
    
    /**
     * @return the current room and the different exits.
     */
    public String getLongDescription()
    {
        return "Vous vous trouvez : " + this.aDescription + ".\n" + this.getExitString() + "\n" + "Vous pouvez ramasser ici : " + this.aItems.getItemsString();
    }// getLongDescription()
    
    /**
     * @return the room's image name
     */
    public String getImageName()
    {
         return this.aImageName;
    } // getImageName()

} // Room
