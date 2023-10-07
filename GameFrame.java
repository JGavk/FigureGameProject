package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import logic.Figure;
import logic.GeometryGame;
import java.util.Collections;


public class GameFrame extends JFrame {
    private JPanel figurePanel;
    private List<List<Figure>> figureArray;
    private int currentIndex;

    public GameFrame() {
        setTitle("Geometry Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        GeometryGame geometryGame = new GeometryGame();
        figureArray = geometryGame.getFigureArray();
        currentIndex = 0;

        figurePanel = new JPanel();
        figurePanel.setLayout(null);

        int xOffset = 400; // Cordenada inicial de los Labels en x
        int xSpacing = 250; // Ajustar el espacio horizontal

        updateFigurePanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(figurePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void updateFigurePanel() {
        List<Figure> currentFigures = figureArray.get(currentIndex);
        Collections.shuffle(currentFigures); // Cambia las ubicaciones

        int xOffset = 400; 
        int xSpacing = 250; 

        for (int i = 0; i < currentFigures.size(); i++) {
            Figure currentFigure = currentFigures.get(i);
            JLabel label = new JLabel(currentFigure.image);
            label.setBounds(xOffset + i * xSpacing, 320, currentFigure.image.getIconWidth(), currentFigure.image.getIconHeight());

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Cambia de figura cuando se da clic
                    currentIndex = (currentIndex + 1) % figureArray.size();
                    figurePanel.removeAll(); //Remueve pantalla
                    figurePanel.repaint(); // Pinta una nueva pantalla
                    updateFigurePanel();
                }
            });

            figurePanel.add(label);
        }
    }
}
