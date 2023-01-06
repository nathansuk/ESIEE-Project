package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgRooms.Room;
import Graou.pkgCore.GameEngine;
/**
 * Commande Go
 *
 * @author Nathan SUK
 */
public class GoCommand extends Command
{

    /**
     * Constructeur d'objets de classe GoCommand
     */
    public GoCommand()
    {
    }

    /**
     * Execution de la commande "go [direction]"
     * @param  pPlayer joueur
     */
    public boolean execute(final Player pPlayer)
    {
        if(hasSecondWord()) {
            
            String vDirection = getSecondWord();
            Room vNextRoom = pPlayer.getCurrentRoom().getExit( vDirection );
            
            if ( vNextRoom == null )
                GameEngine.getGui().println( "Il n'y a pas de sortie par là." );
            else {
                pPlayer.move(vNextRoom);
            }
        } else {
            GameEngine.getGui().println("Dans quelle direction souhaitez-vous aller ?");
        }
        return false;
    }
}
