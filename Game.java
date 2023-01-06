import Graou.pkgCore.GameEngine;
import Graou.pkgCore.UserInterface;
import java.util.HashMap;
/**
 * Classe Game - génère une interface et un moteur du jeu.
 *
 * @author Nathan SUK
 */
public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Crée le jeu et instancie un nouveau Moteur et une nouvelle interface.
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI( this.aGui );
        this.aEngine.play();
    }// Game()
    
    
} // Game
