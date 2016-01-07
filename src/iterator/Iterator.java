/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import scanner.FileAtributes;

/**
 *
 * @author ahuskano
 */
public interface Iterator {
   public boolean hasNext();
   public FileAtributes next();
}
