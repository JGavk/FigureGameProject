
package game;

import java.awt.*;
import java.awt.event.ActionEvent;
package game;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import logic.*;

public class GameFrame extends JFrame {
    private JPanel figurePanel;
    public GameFrame() {
    setTitle("Geometry Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 800);
    setLocationRelativeTo(null);
    
    // Inicializa el panel
    figurePanel = new JPanel();
    figurePanel.setSize(1200, 800);
    figurePanel.setBounds(0, 110, 1200, 800);
    figurePanel.setLayout(null);

    GeometryGame geometryGame = new GeometryGame();
    List<List<Figure>> figureArray = geometryGame.getFigureArray();

    JPanel figurePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = 50;
            int y = 50;

            for (List<Figure> figureList : figureArray) {
                for (Figure figure : figureList) {
                    figure.draw(g, x, y);
                    x += 450; // Ajusta el eje x por cada iteracion
                }
                x = 50; // Toma posicion en el eje x
                y += 250;
            }
        }
    };

    // Añade el panel de figuras
    add(figurePanel);

    setVisible(true);
}
}
    
    
}

