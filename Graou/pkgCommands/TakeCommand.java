package Graou.pkgCommands;

import Graou.pkgCore.GameEngine;
import Graou.Player;

/**
 * Décrivez votre classe TakeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TakeCommand extends Command
{

    /**
     * Constructeur d'objets de classe TakeCommand
     */
    public TakeCommand()
    {
    }

    public boolean execute(Player pPlayer)
    {
        if(this.hasSecondWord())
        {
            String vNomItem = this.getSecondWord();
            
            if(pPlayer.getCurrentRoom().getItems().getItem(vNomItem) != null){
                pPlayer.getItemList().ajouter(pPlayer.getCurrentRoom().getItems().getItem(vNomItem));  
                pPlayer.getCurrentRoom().getItems().retirer(vNomItem);
                GameEngine.getGui().println(vNomItem + " a été ajouté à l'inventaire");
            } else {
                GameEngine.getGui().println("Cet objet n'est pas dans la pièce.");
            }
        } else {
            GameEngine.getGui().println("Que souhaitez-vous ramasser ?");
        }
        return false;
    }
}
