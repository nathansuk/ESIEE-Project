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
    
    /**
     * Constructeur d'objets de classe PotionForceItem
     */
    public PotionForceItem(final String pNom, final String pDescription, final double pPrix, final double pWeight) {
        super(pNom, pDescription, pPrix, pWeight);
    }

    
    public void use(Player pPlayer)
    {
        pPlayer.setMaxWeight(5);
    }
}
