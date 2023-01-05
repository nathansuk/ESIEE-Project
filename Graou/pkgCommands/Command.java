package Graou.pkgCommands;

import Graou.Player;
/**
 * Classe Commande qui définit une commande
 *
 * @author votre nom
 */
public abstract class Command
{
    
    private String aSecondWord;
    
    /**
     * Natural constructor of Command
     * @params String the first word of the command
     * @params String the second word of the command
     */
    public Command()
    {
        this.aSecondWord = null;
    }// Command()
    
    
    /**
     * @return the second command word.
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }// getSecondWord()
    
    /**
     * @return true if the command has a second word
     * false if not.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }// hasSecondWord()
    
    public void setSecondWord(final String pSecondWord)
    {
        this.aSecondWord = pSecondWord;
    }
    
    /**
     * Execute la logique associée à une commande
     * @return boolean
     */
    public abstract boolean execute(Player pPlayer);
} // Command
