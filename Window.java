package visual;

import java.awt.Canvas;
import javax.swing.JFrame;

/**
 *
 * @author juanp
 */

/* Clase ventana, maneja los atributos de la ventana del juego */
public class Window extends Canvas{
    
    
    public Window(int width, int height, String title, Game game){
    JFrame frame = new JFrame(title);
    frame.setSize(800,600);
    frame.setVisible(true);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.add(game);
    game.start();
    }
    
    
}
