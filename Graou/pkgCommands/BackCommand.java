package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Commande Back
 *
 * @author (votre nom)
 */
public class BackCommand extends Command
{

    /**
     * Constructeur d'objets de classe BackCommand
     */
    public BackCommand()
    {
    }
    
    /**
     * Fais retourner le joueur dans la pièce précédente dans la Stack
     */
    public boolean execute(Player pPlayer)
    {
         pPlayer.back();
         return false;
    }

}
