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
        jpContenido.setBackground(Color.YELLOW);
        jpContenido.setSize(1200,800);        
        jpContenido.setBounds(0,0, 1200, 800);
        jpContenido.setLayout(null);
        
        add(jpContenido);
        
        jlMensaje = new JLabel("¡Bienvenido/a, encontremos las figuras!",SwingConstants.CENTER);
        jlMensaje.setBounds(0,20, 1220,200);
        jlMensaje.setForeground(Color.BLUE);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 20)); 
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
        
        btnIngresar.addActionListener(manejadorEventos);
        btnIngresar.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                String nombre="";
                nombre = JOptionPane.showInputDialog(rootPane, "Para empezar a jugar por favor escribe tu nombre", "Nombre de Jugador", HEIGHT);
                String resultado = "Nombre: "+nombre;    
            
            }
        });
        btnLeave.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            
            }
     
        });
        btnInstructions.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"Tenga en cuenta la figura a su izquierda para seleccionar su igual en el trio de la izquierda","Instrucciones de juego",JOptionPane.INFORMATION_MESSAGE);
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
