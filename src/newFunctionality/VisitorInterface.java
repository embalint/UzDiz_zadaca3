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
public interface VisitorInterface {
    
    public float visit(Circle circle);
    public float visit(Triangle triangle);
    public float visit(Polygon polygon);
        
    
}
