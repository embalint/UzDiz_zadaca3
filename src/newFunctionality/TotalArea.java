/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newFunctionality;



/**
 *
 * @author Emil
 */
public class TotalArea {

    float areaCircle = 40;
    Circle circle = new Circle(areaCircle);
    AreaVisitor area= new AreaVisitor();

    Triangle triangle = new Triangle(circle.visited(area));
    Polygon polygon = new Polygon(triangle.visited(area));
    
    public float totalArea(){
        return areaCircle+triangle.visited(area)+polygon.visited(area);
    }

   
    
}
