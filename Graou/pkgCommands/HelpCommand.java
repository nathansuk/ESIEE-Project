package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Commande Help
 *
 * @author Nathan SUK
 */
public class HelpCommand extends Command
{

    /**
     * Constructeur d'objets de classe HelpCommand
     */
    public HelpCommand()
    {
    }

    /**
     * Affiche l'ensemble des commandes
     * @param  pPlayer
     */
    public boolean execute(final Player pPlayer)
    {
        GameEngine.getGui().println( "Vous semblez être perdu ..." );
        GameEngine.getGui().println( "Voici la liste de vos commandes: " );
        GameEngine.getParser().showCommands();
        return false;
    }
}
