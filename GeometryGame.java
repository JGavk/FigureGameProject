
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
        
        System.out.println(System.getProperty("user.dir") + "\\pictures\\triangle.png");
        
        Triangle triangle1 = new Triangle(System.getProperty("user.dir") + "\\pictures\\triangle.png",300,250);
        figureArray.get(0).add(triangle1);
        Triangle triangle2 = new Triangle(System.getProperty("user.dir") + "\\pictures\\triangle.png",random.nextInt(100) + 50, random.nextInt(100) + 50);
        figureArray.get(0).add(triangle2);
        Triangle triangle3 = new Triangle(System.getProperty("user.dir") + "\\pictures\\triangle.png",random.nextInt(100) + 50, random.nextInt(100) + 50);
        figureArray.get(0).add(triangle3);
        
        Circle circle1 = new Circle("src/pictures/circle.png",300,250);
        figureArray.get(1).add(circle1);
        Circle circle2 = new Circle("src/pictures/circle.png",random.nextInt(100) + 50, random.nextInt(100) + 50);
        figureArray.get(1).add(circle2);
        Circle circle3 = new Circle("src/pictures/circle.png",random.nextInt(100) + 50, random.nextInt(100) + 50);
        figureArray.get(1).add(circle3);
        
        Rectangle rectangle1 = new Rectangle("src/pictures/rectangle.png",300,250);
        figureArray.get(2).add(rectangle1);
        Rectangle rectangle2 = new Rectangle("src/pictures/rectangle.png",random.nextInt(100) + 50, random.nextInt(100) + 50);
        figureArray.get(2).add(rectangle2);
        Rectangle rectangle3 = new Rectangle("src/pictures/rectangle.png",random.nextInt(100) + 50, random.nextInt(100) + 50);
        figureArray.get(2).add(rectangle3);
        
    }

        public List<List<Figure>> getFigureArray() {
            
            return figureArray;
    } 


           
}
    


