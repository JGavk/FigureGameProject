
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class GeometryGame{
    
    private List<List<Figure>> figureArray;
  

    public GeometryGame(){
        
        figureArray = new ArrayList<>();
        figureArray.add(new ArrayList<>());
        figureArray.add(new ArrayList<>());
        figureArray.add(new ArrayList<>());
        figureArray.add(new ArrayList<>());
        
        Random random = new Random();
        
        Triangle triangle0 = new Triangle("/pictures/triangle.png",150,150);
        figureArray.get(0).add(triangle0);
        Triangle triangle1 = new Triangle("/pictures/triangle.png",150,150);
        figureArray.get(0).add(triangle1);
        Triangle triangle2 = new Triangle("/pictures/triangle.png",random.nextInt(140) + 50, random.nextInt(140) + 50);
        figureArray.get(0).add(triangle2);
        Triangle triangle3 = new Triangle("/pictures/triangle.png",random.nextInt(130) + 50, random.nextInt(130) + 50);
        figureArray.get(0).add(triangle3);
  
        Circle circle0 = new Circle("/pictures/circle.png",150,150);
        figureArray.get(1).add(circle0);
        Circle circle1 = new Circle("/pictures/circle.png",150,150);
        figureArray.get(1).add(circle1);
        Circle circle2 = new Circle("/pictures/circle.png",random.nextInt(140) + 50, random.nextInt(130) + 50);
        figureArray.get(1).add(circle2);
        Circle circle3 = new Circle("/pictures/circle.png",random.nextInt(140) + 50, random.nextInt(150) + 50);
        figureArray.get(1).add(circle3);
        
        Rectangle rectangle0 = new Rectangle("/pictures/rectangle.jpg",150,150);
        figureArray.get(2).add(rectangle0);
        Rectangle rectangle1 = new Rectangle("/pictures/rectangle.jpg",150,150);
        figureArray.get(2).add(rectangle1);
        Rectangle rectangle2 = new Rectangle("/pictures/rectangle.jpg",random.nextInt(130) + 50, random.nextInt(130) + 50);
        figureArray.get(2).add(rectangle2);
        Rectangle rectangle3 = new Rectangle("/pictures/rectangle.jpg",random.nextInt(140) + 50, random.nextInt(140) + 50);
        figureArray.get(2).add(rectangle3);
        
        Square square0 = new Square("/pictures/square.png",150,150);
        figureArray.get(3).add(square0);
        Square square1 = new Square("/pictures/square.png",150,150);
        figureArray.get(3).add(square1);
        Square square2 = new Square("/pictures/square.png",random.nextInt(120) + 50, random.nextInt(120) + 50);
        figureArray.get(3).add(square2);
        Square square3 = new Square("/pictures/square.png",random.nextInt(120) + 50, random.nextInt(120) + 50);
        figureArray.get(3).add(square3);
        
    }

        public List<List<Figure>> getFigureArray() {
            
            return figureArray;
    } 


           
}
    




