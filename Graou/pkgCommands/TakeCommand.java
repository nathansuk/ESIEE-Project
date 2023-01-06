package Graou.pkgCommands;

import Graou.pkgCore.GameEngine;
import Graou.Player;
import Graou.pkgItems.Item;

/**
 * Commande Take
 *
 * @author Nathan SUK
 */
public class TakeCommand extends Command
{

    /**
     * Constructeur d'objets de classe TakeCommand
     */
    public TakeCommand()
    {
    }
    
    /**
     * Le joueur prend un des objets de la room avec le nom associé au second mot
     * @param  pPlayer Joueur concerné
     * @return boolean 
     */
    public boolean execute(final Player pPlayer)
    {
        if(this.hasSecondWord())
        {
            String vNomItem = this.getSecondWord();
            Item vItem = pPlayer.getCurrentRoom().getItems().getItem(vNomItem);
            if(vItem != null){
                
                if(pPlayer.getItemList().getTotalWeight() + vItem.getWeight() > pPlayer.getMaxWeight())
                {
                    GameEngine.getGui().println("Vous n'êtes pas en mesure de porter plus d'objet.");
                }
                else 
                {         
                    pPlayer.getItemList().ajouter(vItem);  
                    pPlayer.getCurrentRoom().getItems().retirer(vNomItem);
                    GameEngine.getGui().println(vNomItem + " a été ajouté à l'inventaire");   
                }
            } else {
                GameEngine.getGui().println("Cet objet n'est pas dans la pièce.");
            }
        } else {
            GameEngine.getGui().println("Que souhaitez-vous ramasser ?");
        }
        return false;
    }
}
