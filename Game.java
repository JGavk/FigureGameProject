/*
Miguel Angel Soto Espitia 2240019
Juan Pablo Puerta Gaviria 2240033
24/09/23-8/10/23
*/
package game;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Game {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        ThisFrame frame = new ThisFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
        
    }
    
}
