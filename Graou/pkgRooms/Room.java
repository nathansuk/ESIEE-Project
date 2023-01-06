package Graou.pkgRooms;

import Graou.Character;
import Graou.pkgItems.ItemList;
import java.util.HashMap;
import java.util.Set;
/**
 * Classe Room - un lieu du jeu.
 *
 * @author Nathan SUK
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    private ItemList aItems;
    private String aImageName;
    private HashMap<String, Character> aCharacters;
    
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
        this.aCharacters = new HashMap<String, Character>();
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
     * Retourne la room correspondant à la direction souhaitée
     * @return the exit corresponding to the direction
     * @param String The direction of the exit.
     */
    public Room getExit(String pDirection)
    {
        return this.aExits.get(pDirection);
    } // getExit()
    
    
    /**
     * Retourne une string contenant la liste des sorties (directions) possibles.
     * @return Les sorties de la pièce sous forme de String.
     */
    public String getExitString()
    {
        String vString = "Sorties possibles : ";
        
        Set<String> vExits = this.aExits.keySet();
        for(String vSortie : vExits){
            vString += vSortie+" ";
        }
        
        return vString;
    } // getExitString()
    
    /**
     * Retourne une String contenant la description de la room
     * @return the current room and the different exits.
     */
    public String getLongDescription()
    {
        String vString = this.aDescription + ".\n" + this.getExitString() + "\n";
        
        if(!this.aItems.estVide()) {
             vString += "Vous pouvez ramasser ici : " + this.aItems.getItemsString();
        }
                
        if(this.hasCharacter())
        {
            vString += "Il y a " + this.aCharacters.size() + " personne à qui vous pouvez parler : " + this.getCharactersString();
        }
        return vString;
    }// getLongDescription()
    
    /**
     * @return the room's image name
     */
    public String getImageName()
    {
         return this.aImageName;
    } // getImageName()
    
    /**
     * Retourne la liste des personnages présents dans la room
     * @return La HashMap contenant les String (nom des personnages) et l'objet Character associé.
     */
    public HashMap<String, Character> getCharacters()
    {
        return this.aCharacters;
    } // getCharacters()
    
    /**
     * Retourne un Character en particulier parmis la liste
     * @param pNom le nom du personnage recherché.
     * @return l'objet Character correspondant au nom
     */
    public Character getCharacter(final String pNom)
    {
        return this.aCharacters.get(pNom);
    } // getCharacter()
    
    /**
     * Ajoute un Character à la liste
     */
    public void addCharacter(final String pNom, final Character pCharacter)
    {
        this.aCharacters.put(pNom, pCharacter);
    } //addCharacter()
    
    /**
     * Retourne true si la pièce contient des personnages, false sinon
     * @return si la room contient des Character
     */
    public boolean hasCharacter()
    {
        return this.aCharacters.size() > 0;
    } // hasCharacter()
    
    /**
     * Retourne une String contenant la liste des personnages
     * @return une chaîne de charactère listant les personnages non jouables présents dans la pièce
     */
    public String getCharactersString()
    {
        String vString = "";
        Set<String> vPersonnages = this.aCharacters.keySet();
        for(String vNomPersonnage : vPersonnages){
            vString += vNomPersonnage+" ";
        }
        return vString;
    } // getCharactersString()


} // Room
