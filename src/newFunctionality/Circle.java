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
public class Circle implements VisitableInterface{
    float areaCircle;
    public Circle (float areaCircle){
        this.areaCircle = areaCircle;
    }
    
    public float getAreaCircle(){
        return areaCircle;
    }

    @Override
    public float visited(VisitorInterface visitor) {
        return visitor.visit(this);
    }

    
    
}
