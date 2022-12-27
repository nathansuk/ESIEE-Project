package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Décrivez votre classe InventaireCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class InventaireCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe InventaireCommand
     */
    public InventaireCommand()
    {
    }

    public boolean execute(Player pPlayer)
    {
        GameEngine.getGui().println(" Votre inventaire contient : " + pPlayer.getItemList().getItemsString());
        return false;
    }
}
