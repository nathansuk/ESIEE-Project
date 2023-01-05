package Graou.pkgItems;

import Graou.Player;
/**
 * Décrivez votre classe abstraite UsableItem ici.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 */
public abstract class UsableItem extends Item
{
    // variable d'instance - remplacez cet exemple par le vôtre
    int x;

    public UsableItem(final String pNom, final String pDescription, final double pPrix, final double pWeight)
    {
        super(pNom, pDescription, pPrix, pWeight);
    }

    /**
     * Méthode exécutée lorsque la commande "use 'nomObjet' est appelée
     * @param  pPlayer Joueur sur qui effectuer l'action
     */
    abstract public void use(final Player pPlayer);
}
