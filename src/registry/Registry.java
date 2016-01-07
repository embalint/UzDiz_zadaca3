/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registry;

import java.util.HashMap;

public class Registry {

    volatile HashMap<String, Object> items = new HashMap<String, Object>();

    private static volatile Registry instance = null;

    protected Registry() {
        // Exists only to defeat instantiation.
    }

    public static Registry getInstance() {
        if (instance == null) {
            instance = new Registry();
        }
        return instance;
    }

    public void set(String key, Object value) {
        this.items.put(key, value);
    }

    public Object get(String key) {
        return this.items.get(key);
    }

}
