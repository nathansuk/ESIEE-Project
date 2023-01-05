package Graou.pkgCommands;

import Graou.pkgCore.GameEngine;
import Graou.Player;
/**
 * Commande Drop
 *
 * @author Nathan SUK
 */
public class DropCommand extends Command
{

    /**
     * Constructeur d'objets de classe DropCommand
     */
    public DropCommand()
    {
    }
    
    /**
     * Supprime l'item de l'inventaire de l'utilisateur et le repose dans la pièce où le joueur se trouve
     * @param pPlayer joueur
     */
    public boolean execute(final Player pPlayer)
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
