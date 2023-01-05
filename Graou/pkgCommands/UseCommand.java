package Graou.pkgCommands;

import Graou.Player;
import Graou.pkgCore.GameEngine;
import Graou.pkgItems.BeamerItem;
import Graou.pkgItems.UsableItem;
/**
 * Commande Use
 *
 * @author Nathan SUK
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
     * Regarde si l'item passé en deuxième mot est présent dans l'inventaire et si c'est un item Utilisable, si oui, l'utiliser en appelant Item.use()
     *
     * @param  pPlayer joueur
     */
    public boolean execute(Player pPlayer)
    {
        if(this.hasSecondWord()){
            
            if(pPlayer.getItemList().contient(this.getSecondWord())) {
                if((pPlayer.getItemList().getItem(this.getSecondWord()) instanceof UsableItem)) {
                    UsableItem vItemUsable = (UsableItem)pPlayer.getItemList().getItem(this.getSecondWord());
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
