
package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.GeometryGame;
import javax.swing.*;

public class GameFrame extends JFrame {
    private JLabel jpPoints;
    private JButton btnLeave, btn1, btn2, btn3;
    private JPanel jpContenido;                           
    private GeometryGame geometryGame;
    private ImageIcon image1, image2, image3;
    private ImageIcon scale1, scale2, scale3;
    
    public GameFrame(){
        setTitle("Geometry Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        setLayout(null);
        
        
        
        jpContenido = new JPanel();
        jpContenido.setSize(1200,800);        
        jpContenido.setBounds(0,110, 1200, 800);
        jpContenido.setLayout(null);
        add(jpContenido); 
        btnLeave = new JButton("Salir");
        btnLeave.putClientProperty("JButton.buttonType", "roundRect");
        btnLeave.setBounds(1000,600, 150,35);
        jpContenido.add(btnLeave);
        
        image1 = new ImageIcon("pictures/circle.png");
        this.scale1=new ImageIcon(image1.getImage().getScaledInstance(90,90,java.awt.Image.SCALE_DEFAULT));
        btn1 = new JButton(image1);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        btn2 = new JButton(image1);
        btn2.setBorderPainted(false);
        btn2.setContentAreaFilled(false);
        btn3 = new JButton();
        // Create a random size for the button
        Random random = new Random();
        int width = random.nextInt(250) + 60;  // Random width between 50 and 249
        int height = random.nextInt(150) + 40; // Random height between 30 and 129

            // Create the button with the random size
        JButton randomSizeButton = new JButton();
        randomSizeButton.setPreferredSize(new Dimension(width, height));
        randomSizeButton.setBounds(352,100, width, height);
        randomSizeButton.setIcon(this.image1);
        randomSizeButton.setBorderPainted(false);
        randomSizeButton.setContentAreaFilled(false);
            // Add the button to the frame
        jpContenido.add(randomSizeButton);
        JButton randomSizeButton2 = new JButton();
        randomSizeButton2.setPreferredSize(new Dimension(width, height));
        randomSizeButton2.setBounds(899,100, width,height);
        randomSizeButton2.setIcon(this.scale1);
        randomSizeButton2.setBorderPainted(false);
        randomSizeButton2.setContentAreaFilled(false);
            // Add the button to the frame
        jpContenido.add(randomSizeButton2);
        btn1.setIcon(this.scale1);
        btn1.setBounds(100,120, 100,100);
        btn2.setBounds(690,100,150,150);
        jpContenido.add(btn1);
        jpContenido.add(btn2);
        
        btnLeave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    
    
}

