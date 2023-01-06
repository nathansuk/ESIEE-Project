package Graou.pkgItems;

import Graou.Player;
/**
 * Item utilisable grâce à la méthode use
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */
public abstract class UsableItem extends Item
{

    public UsableItem(final String pNom, final String pDescription, final double pWeight)
    {
        super(pNom, pDescription, pWeight);
    } // UsableItem()

    /**
     * Méthode exécutée lorsque la commande "use 'nomObjet' est appelée
     * @param  pPlayer Joueur sur qui effectuer l'action
     */
    abstract public void use(final Player pPlayer); // use()
}
