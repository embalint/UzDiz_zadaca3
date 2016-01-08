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
public class AreaVisitor implements VisitorInterface{
    

    @Override
    public float visit(Circle circle) {
        return (float)Math.sqrt(circle.getAreaCircle()/Math.PI);
    }

    @Override
    public float visit(Triangle triangle) {
        return triangle.getCircleR()*triangle.getCircleR()*triangle.getCircleR();
    }

    @Override
    public float visit(Polygon polygon) {
        return polygon.getCircleArea()*2;
    }
   
 
}
