package Graou.pkgItems;

import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Item se supprimant automatiquement de l'inventaire après avoir été utilisé
 *
 * @author  Nathan SUK
 */
public abstract class DestroyableItem extends UsableItem
{
    public DestroyableItem(final String pNom, final String pDescription, final double pPrix, final double pWeight)
    {
        super(pNom, pDescription, pPrix, pWeight);
    }
    
    /**
     * Supprime l'item de l'ItemList du player une fois utilisé
     */
    public void destroyItem(Player pPlayer)
    {
        ItemList vItemList = pPlayer.getItemList();
        vItemList.getItemList().remove(this.getNom());
        GameEngine.getGui().println(this.getNom() + " a été utilisé et a disparu de l'inventaire.");
    } // destroyItem()

}
