package Graou.pkgCommands;

import Graou.pkgCore.GameEngine;
import Graou.Player;
/**
 * Commande Quit
 *
 * @author Nathan SUK
 */
public class QuitCommand extends Command
{
    public QuitCommand()
    {
    }
    
    /**
     * Désactive l'interface si executée.
     */
    public boolean execute(final Player pPlayer)
    {
        GameEngine.getGui().println( "Merci d'avoir joué à GRAOU. Au revoir !." );
        GameEngine.getGui().enable( false );
        return false;
    }
}
