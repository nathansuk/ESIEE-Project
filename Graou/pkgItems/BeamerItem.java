package Graou.pkgItems;

import Graou.pkgItems.Item;
import Graou.Player;
import Graou.pkgCore.GameEngine;
import Graou.pkgRooms.Room;

/**
 * Décrivez votre classe BeamerItem ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BeamerItem extends UsableItem
{
    private Room aBeamerRoom; // la room du beamer
    
    public BeamerItem(final String pNom, final String pDescription, final double pWeight) {
        super(pNom, pDescription, pWeight);
        this.aBeamerRoom = null; //Le beamer n'a pas chargé de Room
    }

    /**
     * Charge le Beamer si son attribut est null, sinon téléporter le joueur dans la room stockée
     */
    public void use(final Player pPlayer)
    {
        if(this.aBeamerRoom == null) {
            this.aBeamerRoom = pPlayer.getCurrentRoom();
            GameEngine.getGui().println("Le beamer a été chargé. Réutilisez-le pour vous téléporter.");
        }
        else {
            GameEngine.getGui().println("Le beamer vous a téléporté.");
            pPlayer.move(this.aBeamerRoom);
            this.aBeamerRoom = null; // La room est supprimée, le beamer doit être rechargé
        }
    }
}
