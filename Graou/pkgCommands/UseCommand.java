package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
import Graou.pkgItems.BeamerItem;
import Graou.pkgItems.Usable;
/**
 * Décrivez votre classe UseCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UseCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe UseCommand
     */
    public UseCommand()
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
        if(this.hasSecondWord()){
            
            if(pPlayer.getItemList().contient(this.getSecondWord())) {
                if((pPlayer.getItemList().getItem(this.getSecondWord()) instanceof Usable)) {
                    Usable vItemUsable = (Usable)pPlayer.getItemList().getItem(this.getSecondWord());
                    vItemUsable.use(pPlayer);
                } else {
                    GameEngine.getGui().println("Cet objet n'est pas utilisable");
                }
            } else {
                GameEngine.getGui().println("Cet objet n'est pas dans votre inventaire ");
            }
            
        } else {
            GameEngine.getGui().println("Quel objet souhaitez-vous utiliser ? ");
        }
        return false;
    }
}
