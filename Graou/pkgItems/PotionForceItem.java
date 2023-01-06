package Graou.pkgItems;

import Graou.pkgItems.Item;
import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Augmente le poids possible dans l'inventaire
 *
 * @author Nathan SUK
 */
public class PotionForceItem extends DestroyableItem
{
    private final int AUGMENTATION_FORCE = 100; //Pour être changé plus facilement et à l'avenir accessible ailleurs
    
    /**
     * Constructeur d'objets de classe PotionForceItem
     */
    public PotionForceItem(final String pNom, final String pDescription, final double pWeight) {
        super(pNom, pDescription, pWeight);
    } // PotionForce()

    /**
     * Modifie le nombre d'objet qu'un joueur peut porter.
     * @param pPlayer le joueur ciblé
     */
    public void use(final Player pPlayer)
    {
        pPlayer.setMaxWeight(AUGMENTATION_FORCE);
        GameEngine.getGui().println("Vous pouvez désormais porter : " + AUGMENTATION_FORCE + " grammes dans votre inventaire.");
        this.destroyItem(pPlayer); // détruite car utilisable qu'une seule fois
    }
}
