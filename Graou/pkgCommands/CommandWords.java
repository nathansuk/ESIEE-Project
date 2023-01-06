package Graou.pkgCommands;

import java.util.HashMap;
import java.util.Iterator;
import Graou.pkgCore.GameEngine;
/**
 * Classe qui initialise les commandes du jeu.
 * 
 * @author Michael Kolling and David J. Barnes, Nathan SUK (ajout des commandes)
 * @version 2011.07.31
 */

public class CommandWords
{
    private HashMap<String, Command> vCommandes;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        vCommandes = new HashMap<String, Command>();
        vCommandes.put("go", new GoCommand());
        vCommandes.put("back", new BackCommand());
        vCommandes.put("help", new HelpCommand());
        vCommandes.put("quit", new QuitCommand());
        vCommandes.put("inventaire", new InventaireCommand());
        vCommandes.put("test", new TestCommand());
        vCommandes.put("take", new TakeCommand());
        vCommandes.put("drop", new DropCommand());
        vCommandes.put("use", new UseCommand());
        vCommandes.put("talk", new TalkCommand());
        vCommandes.put("look", new LookCommand());
    }

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(final String word)
    {
        return (Command)vCommandes.get(word);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(Iterator i = vCommandes.keySet().iterator(); i.hasNext(); ) {
            GameEngine.getGui().print(i.next() + "  ");
        }
        GameEngine.getGui().println("");
    }
}