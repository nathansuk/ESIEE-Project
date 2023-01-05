package Graou.pkgCommands;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import Graou.pkgCore.GameEngine;
import Graou.Player;
/**
 * Commande Test
 *
 * @author Nathan SUK
 */
public class TestCommand extends Command
{

    /**
     * Constructeur d'objets de classe TestCommand
     */
    public TestCommand()
    {
    }

    /**
     * Va chercher le fichier de test dans le dossier /Tests
     * Execute chaque commande une à une.
     * @return false
     */
    public boolean execute(Player pPlayer)
    {
        String vFichier = "Tests/"+this.getSecondWord()+".txt"; 
        try (Scanner vScanner = new Scanner(new File(vFichier))) {
            while(vScanner.hasNext()) {
                String vCommandeString = vScanner.nextLine();
                Command vCommande = GameEngine.getParser().getCommand(vCommandeString);
                GameEngine.getGui().println("Test command : " + vCommandeString);
                GameEngine.getGui().processCommand(vCommande);
            }
        } catch (FileNotFoundException message) {
            GameEngine.getGui().println("Attention ! Le fichier de test n'a pas été trouvé");
        }
        return false;
    }// execute()
}
