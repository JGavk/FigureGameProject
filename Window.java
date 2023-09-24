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
    frame.setSize(1200, 800);  /*Tamaño de ventana */
    frame.setVisible(true); /*Visibilidad de la ventana */
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* Set de simbolo de cierre por default */
    frame.setResizable(false); /* Sin posibilidad de cambiar tamaño */
    frame.setLocationRelativeTo(null); /* Inicia en el medio de la pantalla */
    frame.add(game); 
    game.start();
    }
    
    
}
