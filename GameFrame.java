package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import logic.Figure;
import logic.GeometryGame;

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

        List<Figure> currentFigures = figureArray.get(currentIndex);
        for (int i = 0; i < currentFigures.size(); i++) {
            Figure currentFigure = currentFigures.get(i);
            JLabel label = new JLabel(currentFigure.image);
            label.setBounds(50 + i * 150, 50, currentFigure.image.getIconWidth(), currentFigure.image.getIconHeight());

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Cuando se da click a una imagen se cambia al siguiente set
                    currentIndex = (currentIndex + 1) % figureArray.size();
                    figurePanel.removeAll(); // Remueve las imagenes existentes
                    figurePanel.repaint(); // Redibuja las nuevas imagenes del arreglo
                    updateFigurePanel();
                }
            });

            figurePanel.add(label);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(figurePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void updateFigurePanel() {
        List<Figure> currentFigures = figureArray.get(currentIndex);
        for (int i = 0; i < currentFigures.size(); i++) {
            Figure currentFigure = currentFigures.get(i);
            JLabel label = new JLabel(currentFigure.image);
            label.setBounds(50 + i * 150, 50, currentFigure.image.getIconWidth(), currentFigure.image.getIconHeight());

            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // When a figure is clicked, switch to the next set of images
                    currentIndex = (currentIndex + 1) % figureArray.size();
                    figurePanel.removeAll(); // Remove the existing labels
                    figurePanel.repaint(); // Redraw the panel with the new images
                    updateFigurePanel();
                }
            });

            figurePanel.add(label);
        }
    }
}

