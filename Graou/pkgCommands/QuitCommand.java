package Graou.pkgCommands;

import Graou.pkgCore.GameEngine;
import Graou.Player;
/**
 * Décrivez votre classe QuitCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class QuitCommand extends Command
{
    public QuitCommand()
    {
    }
    
    public boolean execute(Player pPlayer)
    {
        GameEngine.getGui().println( "Merci d'avoir joué à GRAOU. Au revoir !." );
        GameEngine.getGui().enable( false );
        return false;
    }
}
