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
public class Triangle implements VisitableInterface{
    float R;
    
    public  Triangle(float R){
        this.R = R;
    }

    @Override
    public float visited(VisitorInterface visitor) {
        return visitor.visit(this);
    }
    
    public float getCircleR(){
        return R;
    }
}
