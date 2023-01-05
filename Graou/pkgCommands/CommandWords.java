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
    private HashMap<String, Command> commands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        commands = new HashMap<String, Command>();
        commands.put("go", new GoCommand());
        commands.put("back", new BackCommand());
        commands.put("help", new HelpCommand());
        commands.put("quit", new QuitCommand());
        commands.put("inventaire", new InventaireCommand());
        commands.put("test", new TestCommand());
        commands.put("take", new TakeCommand());
        commands.put("drop", new DropCommand());
        commands.put("use", new UseCommand());
        commands.put("talk", new TalkCommand());
        commands.put("look", new LookCommand());
    }

    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(final String word)
    {
        return (Command)commands.get(word);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
        for(Iterator i = commands.keySet().iterator(); i.hasNext(); ) {
            GameEngine.getGui().print(i.next() + "  ");
        }
        GameEngine.getGui().println("");
    }
}