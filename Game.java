
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
