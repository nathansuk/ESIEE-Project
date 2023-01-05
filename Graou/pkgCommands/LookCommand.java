package Graou.pkgCommands;

import Graou.pkgCore.GameEngine;
import Graou.Player;
import Graou.pkgRooms.Room;
import Graou.pkgItems.Item;
/**
 * Commande permettant d'afficher les items présents dans la pièce
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LookCommand extends Command
{

    /**
     * Constructeur d'objets de classe LookCommand
     */
    public LookCommand()
    {
    }

    /**
     * Liste les items de la room et affiche une chaîne de caractère
     *
     * @param  pPlayer Joueur concerné
     * @return boolean 
     */
    public boolean execute(Player pPlayer)
    {
        
        Room vCurrentRoom = pPlayer.getCurrentRoom();
        String vString = vCurrentRoom.getItems().getItemsString();
        
        if(this.hasSecondWord()){
            Item vItem = vCurrentRoom.getItems().getItem(this.getSecondWord());
            if(vItem != null) {
                GameEngine.getGui().println("Description de l'objet '"+ vItem.getNom() +"' : " + vItem.getDescription());
            } else {
                GameEngine.getGui().println("Objet introuvable.");
            }
        } else {
            GameEngine.getGui().println("La pièce contient : \n");
            GameEngine.getGui().print(vString);   
        }
        return false;
    }
}
