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
    private Room aBeamerRoom;
    
    public BeamerItem(final String pNom, final String pDescription, final double pPrix, final double pWeight) {
        super(pNom, pDescription, pPrix, pWeight);
        this.aBeamerRoom = null; //Le beamer n'a pas chargé de Room
    }

    public void use(final Player pPlayer)
    {
        if(this.aBeamerRoom == null) {
            this.aBeamerRoom = pPlayer.getCurrentRoom();
            GameEngine.getGui().println("Le beamer a été chargé. Réutilisez-le pour vous téléporter.");
        }
        else {
            GameEngine.getGui().println("Le beamer vous a téléporté.");
            pPlayer.move(this.aBeamerRoom);
            this.aBeamerRoom = null;
        }
    }
}
