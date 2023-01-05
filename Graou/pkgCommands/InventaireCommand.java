package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Commande Inventaire
 *
 * @author Nathan SUK
 */
public class InventaireCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe InventaireCommand
     */
    public InventaireCommand()
    {
    }
    
    /**
     * Liste les items présents dans l'inventaire
     * @param pPlayer joueur
     */
    public boolean execute(Player pPlayer)
    {
        GameEngine.getGui().println(" Votre inventaire contient : " + pPlayer.getItemList().getItemsString());
        return false;
    }
}
