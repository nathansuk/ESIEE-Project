package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgRooms.Room;
import Graou.pkgCore.GameEngine;
/**
 * Décrivez votre classe GoCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
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
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public boolean execute(Player pPlayer)
    {
        if(hasSecondWord()) {
            
            String vDirection = getSecondWord();
            Room vNextRoom = pPlayer.getCurrentRoom().getExit( vDirection );
            
            if ( vNextRoom == null )
                GameEngine.getGui().println( "Il n'y a pas de sortie par là." );
            else {
                pPlayer.move(vNextRoom);
                GameEngine.getGui().updateRoom(pPlayer.getCurrentRoom());
                pPlayer.removeMouvement();
                if(!pPlayer.resteMouvement()) {
                    GameEngine.getGui().enable(false);
                }
            }
        } else {
            GameEngine.getGui().println("Dans quelle direction souhaitez-vous aller ?");
        }
        return false;
    }
}
