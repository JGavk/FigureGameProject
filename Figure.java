/*
Miguel Angel Soto Espitia 2240019
Juan Pablo Puerta Gaviria 2240033
24/09/23-8/10/23
*/
package logic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Clase abstracta
public abstract class Figure {
    protected ImageIcon image;

    public Figure(String imageUrl, int width, int height) {
        ImageIcon originalImage = new ImageIcon(getClass().getResource(imageUrl));
        Image scaledImage = originalImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImage);
    }

    public abstract void draw(Graphics g, int x, int y);
}

// Subclase Triangulo
class Triangle extends Figure {
    public Triangle(String imageUrl, int width, int height) {
        super(imageUrl, width, height);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image.getImage(), x, y, null);
    }
}

// Subclase Circulo
class Circle extends Figure {
    public Circle(String imageUrl, int width, int height) {
        super(imageUrl, width, height);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image.getImage(), x, y, null);
    }
}

// Subclase cuadrado
class Square extends Figure {
    public Square(String imageUrl, int width, int height) {
        super(imageUrl, width, height);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image.getImage(), x, y, null);
    }
}
