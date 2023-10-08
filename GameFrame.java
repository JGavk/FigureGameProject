/*
Miguel Angel Soto Espitia 2240019
Juan Pablo Puerta Gaviria 2240033
24/09/23-8/10/23
*/
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import logic.Figure;
import logic.GeometryGame;
import java.util.Collections;

public class GameFrame extends JFrame {
    private JPanel figurePanel;
    private JPanel statusPanel; // NUEVO PANEL PARA LOS CONTEOS Y BOTONES
    private List<List<Figure>> figureArray;
    private int currentIndex;
    private int matchingPairsCounter;
    private int failedClicksCounter;
    private JLabel countLabel; // Label para el conteo++
    private JLabel failedClics; // Label para el conteo --
    private JButton btnLeave, btnInstructions;

    public GameFrame() {
        setTitle("Geometry Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        GeometryGame geometryGame = new GeometryGame();
        figureArray = geometryGame.getFigureArray();
        currentIndex = 0;
        matchingPairsCounter = 0;
        failedClicksCounter = 0;
        figurePanel = new JPanel();
        figurePanel.setBackground(new java.awt.Color(102, 0, 204));
        figurePanel.setLayout(null);

        statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        int xOffset = 200;
        int xSpacing = 250;

        countLabel = new JLabel("Aciertos: " + matchingPairsCounter);
        failedClics = new JLabel("Fallos: " + failedClicksCounter);



        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(figurePanel, BorderLayout.CENTER);

        updateFigurePanel();
        
        setVisible(true);
    }

    private void updateFigurePanel() {
        List<Figure> currentFigures = figureArray.get(currentIndex);
        Collections.shuffle(currentFigures); // Cambia las posiciones
        
        
        
        failedClics = new JLabel("Fallos: "+ failedClicksCounter ,SwingConstants.CENTER);
        failedClics.setBounds(0,50, 1220,200);
        failedClics.setForeground(new java.awt.Color(255, 255, 255));
        failedClics.setFont(new Font("arial", Font.BOLD, 25)); 
        figurePanel.add(failedClics);
        
        
        countLabel = new JLabel("Aciertos: "+ matchingPairsCounter ,SwingConstants.CENTER);
        countLabel.setBounds(0,20, 1220,200);
        countLabel.setForeground(new java.awt.Color(255, 255, 255));
        countLabel.setFont(new Font("arial", Font.BOLD, 25)); 
        figurePanel.add(countLabel);
        btnInstructions = new JButton("Instrucción");
        btnInstructions.setBounds(900,15, 150,35);
        btnInstructions.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"HAY 2 FIGURAS IGUALES para ganar debes de darle click a cualquiera de estas","Instrucciones de juego",JOptionPane.INFORMATION_MESSAGE);
            }
        
        });
        figurePanel.add(btnInstructions);
        
        btnLeave = new JButton("Salir");
        btnLeave.setBounds(900,645, 150,35);
        btnLeave.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                String nombre="";
                nombre = JOptionPane.showInputDialog(rootPane, "Para terminar el juego por favor escribe tu nombre", "Nombre de Jugador", HEIGHT);
                float resultado2 = ((float)(matchingPairsCounter)/(float)(matchingPairsCounter+failedClicksCounter))*100;
                DecimalFormat formato = new DecimalFormat("0.0");
                String resultado = "Nombre: "+nombre+"\nPuntaje: "+countLabel.getText()+"\nPuntaje de fallos: "+failedClicksCounter+"\nPorcentaje de aciertos: "+formato.format(resultado2)+"%"; 
                JOptionPane.showMessageDialog(rootPane, resultado, "Game Over", HEIGHT);
                System.exit(0);
                
            }
     
        });
        figurePanel.add(btnLeave);

        int xOffset = 200;
        int xSpacing = 250;

        for (int i = 0; i < currentFigures.size(); i++) {
            Figure currentFigure = currentFigures.get(i);
            JLabel label = new JLabel(currentFigure.image);
            label.setBounds(xOffset + i * xSpacing, 320, currentFigure.image.getIconWidth(), currentFigure.image.getIconHeight());
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (matchesSize(currentFigure, currentFigures)) {
                        // Incrementa el numero de aciertos
                        matchingPairsCounter++;
                        countLabel.setText("Aciertos: " + matchingPairsCounter);
                    } else {
                        // Incrementa el numero de fallos
                        failedClicksCounter++;
                        failedClics.setText("Errores: " + failedClicksCounter);
                    }
                    // Cambia al siguiente set de imagenes
                    currentIndex = (currentIndex + 1) % figureArray.size();
                    figurePanel.removeAll();
                    figurePanel.repaint();
                    updateFigurePanel();
                }
            });

            figurePanel.add(label);
        }
    }

    // Si las figuras son iguales aumenta
    private boolean matchesSize(Figure clickedFigure, List<Figure> currentFigures) {
        int matchingSizeCount = 0;
        for (Figure figure : currentFigures) {
            if (figure.getClass() == clickedFigure.getClass() && figure.image.getIconWidth() == clickedFigure.image.getIconWidth() && figure.image.getIconHeight() == clickedFigure.image.getIconHeight()) {
                matchingSizeCount++;
            }
        }
        
        return matchingSizeCount >= 2;
    }
}
