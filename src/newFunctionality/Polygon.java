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
public class Polygon implements VisitableInterface{
    float circleArea;
    public Polygon(float circleArea){
        this.circleArea = circleArea  ;     
    }

    @Override
    public float visited(VisitorInterface visitor) {
        return visitor.visit(this);
    }
    public float getCircleArea(){
        return circleArea;
    }
}
