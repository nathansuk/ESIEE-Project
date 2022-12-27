package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
/**
 * Décrivez votre classe HelpCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
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
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public boolean execute(Player pPlayer)
    {
        GameEngine.getGui().println( "Vous semblez être perdu ..." );
        GameEngine.getGui().println( "Voici la liste de vos commandes: " );
        GameEngine.getParser().showCommands();
        return false;
    }
}
