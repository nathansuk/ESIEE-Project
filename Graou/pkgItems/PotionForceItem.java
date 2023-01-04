package Graou.pkgItems;

import Graou.pkgItems.Item;
import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Décrivez votre classe PotionForceItem ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PotionForceItem extends Item implements Usable
{
    private final int AUGMENTATION_FORCE = 100;
    
    /**
     * Constructeur d'objets de classe PotionForceItem
     */
    public PotionForceItem(final String pNom, final String pDescription, final double pPrix, final double pWeight) {
        super(pNom, pDescription, pPrix, pWeight);
    }

    /**
     * Modifie le nombre d'objet qu'un joueur peut porter.
     * @param pPlayer le joueur ciblé
     */
    public void use(final Player pPlayer)
    {
        pPlayer.setMaxWeight(AUGMENTATION_FORCE);
        GameEngine.getGui().println("Vous pouvez désormais porter : " + AUGMENTATION_FORCE + "grammes dans votre inventaire.");
    }
}
