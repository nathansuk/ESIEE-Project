package Graou.pkgCommands;

import Graou.pkgCore.GameEngine;
import Graou.Player;
/**
 * Décrivez votre classe DropCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DropCommand extends Command
{

    /**
     * Constructeur d'objets de classe DropCommand
     */
    public DropCommand()
    {
    }

    public boolean execute(Player pPlayer)
    {
        if(this.hasSecondWord()){
            String vItemName = this.getSecondWord();
            if(pPlayer.getItemList().getItem(vItemName) != null){
                pPlayer.getCurrentRoom().getItems().ajouter(pPlayer.getItemList().getItem(vItemName));
                pPlayer.getItemList().retirer(vItemName);
                GameEngine.getGui().println(vItemName + "a été retiré de l'inventaire");
            } else {
                GameEngine.getGui().println("Cet objet n'est pas dans dans votre inventaire.");
            }
        } else {
            GameEngine.getGui().println("Que souhaitez-vous jeter ?");
        }
        return false;
    }
}
