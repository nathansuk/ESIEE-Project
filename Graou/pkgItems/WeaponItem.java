package Graou.pkgItems;

import Graou.Player;
import Graou.pkgCore.GameEngine;
import Graou.pkgRooms.Room;
import Graou.Character;
/**
 * Décrivez votre classe WeaponItem ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class WeaponItem extends UsableItem
{

    /**
     * Constructeur d'objets de classe WeaponItem
     */
    public WeaponItem(final String pNom, final String pDescription, final double pPrix, final double pWeight) {
        super(pNom, pDescription, pPrix, pWeight);
    }
    
    /**
     * Vérifie si le Character loup est dans la salle et le tue si l'arme est utilisée
     */
    public void use(final Player pPlayer)
    {
        Room vCurrentRoom = pPlayer.getCurrentRoom();
        
        if(vCurrentRoom.getCharacters().get("Loup") != null){
            GameEngine.getGui().gameIsWon();
        } else {
            GameEngine.getGui().println("Vous ne pouvez attaquer personne ici");
        }
    }
}
