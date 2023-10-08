/*
Miguel Angel Soto Espitia 2240019
Juan Pablo Puerta Gaviria 2240033
24/09/23-8/10/23
*/
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;


public class ThisFrame extends JFrame {
    private JLabel jlMensaje;
    private JPanel jpContenido;
    private JButton btnIngresar;
    private JButton btnLeave;
    private JButton btnInstructions;
    
    public ThisFrame(){
        startComponent();
    }
    
    /*    @Override
    public void paint(Graphics g){
    ImageIcon imagen = new ImageIcon(getClass().getResource("background.png"));
    g.drawImage(imagen.getImage(),0,0,getWidth(),getHeight(),this);
    setOpaque(true);
    super.paint(g);
}*/
    private void startComponent(){
        //Configuración de la ventana
        setTitle("Geometry Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        setLayout(null);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        /* Edicion adentro */
        jpContenido = new JPanel();
        jpContenido.setBackground(new java.awt.Color(102, 0, 204));
        jpContenido.setSize(1200,800);        
        jpContenido.setBounds(0,0, 1200, 800);
        jpContenido.setLayout(null);
        
        add(jpContenido);
        
        jlMensaje = new JLabel("¡Bienvenido/a, encontremos las figuras!",SwingConstants.CENTER);
        jlMensaje.setBounds(0,20, 1220,200);
        jlMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jlMensaje.setFont(new Font("arial", Font.BOLD, 25)); 
        jpContenido.add(jlMensaje);
        
        btnIngresar = new JButton("Juego");
        btnIngresar.setBounds(520,200, 150,35);
        jpContenido.add(btnIngresar);
        
        btnInstructions = new JButton("Instrucción");
        btnInstructions.setBounds(520,250, 150,35);
        jpContenido.add(btnInstructions);
        
        btnLeave = new JButton("Salir");
        btnLeave.setBounds(520,300, 150,35);
        jpContenido.add(btnLeave);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnLeave.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            
            }
     
        });
        btnInstructions.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"HAY 2 FIGURAS IGUALES para ganar debes de darle click a cualquiera de estas","Instrucciones de juego",JOptionPane.INFORMATION_MESSAGE);
            }
        
        });
        
        

        
        
        }

    private void startGame(){
        dispose();
        GameFrame gameFrame = new GameFrame();
        

    }




    class ManejadorDeEventos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource()== btnIngresar){
               startGame();}
           
        }

       
    
    }
}
