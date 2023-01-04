package Graou.pkgCommands;

import Graou.Player;
import Graou.Character;
import Graou.pkgCore.GameEngine;
import Graou.pkgRooms.Room;
/**
 * Décrivez votre classe TalkCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TalkCommand extends Command
{

    /**
     * Constructeur d'objets de classe BackCommand
     */
    public TalkCommand()
    {
    }
    
    public boolean execute(final Player pPlayer)
    {
         if(this.hasSecondWord())
         {
             
             Room vCurrentRoom = pPlayer.getCurrentRoom();
             String vNomPersonnage = this.getSecondWord();
             
             if(vCurrentRoom.hasCharacter()) {
                 
                 if(vCurrentRoom.getCharacters().containsKey(vNomPersonnage)){
                     Character vPersonnage = vCurrentRoom.getCharacter(vNomPersonnage);
                     GameEngine.getGui().println(vPersonnage.getNom() + " : " + vPersonnage.getDialogue());
                 } else {
                     GameEngine.getGui().println("Ce personnage n'est pas dans la pièce.");
                 }
                 
             } else {
                 GameEngine.getGui().println("Il n'y a personne à qui parler ici.");
             }
             
         } else {
             GameEngine.getGui().println("Parler à qui ?");
         }
    
         return false;
    }

}

