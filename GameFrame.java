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

        int xOffset = 200; // Cordenada inicial de los Labels en x
        int xSpacing = 250; // Ajustar el espacio horizontal

        updateFigurePanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(figurePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void updateFigurePanel() {
        List<Figure> currentFigures = figureArray.get(currentIndex);
        Collections.shuffle(currentFigures); // Cambia las ubicaciones
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
        btnLeave.setBounds(900,700, 150,35);
        btnLeave.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){
                String nombre="";
                nombre = JOptionPane.showInputDialog(rootPane, "Para terminar el juego por favor escribe tu nombre", "Nombre de Jugador", HEIGHT);
                String resultado = "Nombre: "+nombre; 
                JOptionPane.showMessageDialog(rootPane, resultado, "Game Over", HEIGHT);
                System.exit(0);
                
            }
     
        });
        figurePanel.add(btnLeave);
        
        
        jlPuntaje = new JLabel("0",SwingConstants.CENTER);
        jlPuntaje.setBounds(0,40, 1220,200);
        jlPuntaje.setForeground(Color.BLUE);
        jlPuntaje.setFont(new Font("arial", Font.BOLD, 20)); 
        
        
        figurePanel.add(jlPuntaje);
        
        jlTextoPuntaje = new JLabel("Puntaje: ",SwingConstants.CENTER);
        jlTextoPuntaje.setBounds(0,20, 1220,200);
        jlTextoPuntaje.setForeground(Color.BLUE);
        jlTextoPuntaje.setFont(new Font("arial", Font.BOLD, 20)); 
        figurePanel.add(jlTextoPuntaje);
        int xOffset = 200; 
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
