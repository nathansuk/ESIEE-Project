package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Décrivez votre classe BackCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BackCommand extends Command
{

    /**
     * Constructeur d'objets de classe BackCommand
     */
    public BackCommand()
    {
    }
    
    public boolean execute(Player pPlayer)
    {
         pPlayer.back();
         return false;
    }

}
