import Graou.pkgCore.GameEngine;
import Graou.pkgCore.UserInterface;
import java.util.HashMap;
/**
 * Classe Game - le moteur du jeu.
 *
 * @author Nathan SUK
 */
public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Create the game and initialise its internal map. Create the inerface and link to it.
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI( this.aGui );
        this.aEngine.play();
    }
    
} // Game
