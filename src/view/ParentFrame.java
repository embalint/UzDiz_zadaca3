/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import utils.Settings;
import utils.Writer;

/**
 *
 * @author ahuskano
 */
public class ParentFrame extends Frame{

    public static final int VERTICAL = 1;
    public static final int HORIZONTAL = 2;
    
    private int MODE;
    private List<ChildFrame> childrens;
    private InputFrame inputFrame;
    
    public ParentFrame(Settings settings, String mode) {
        super(settings);
        if (mode.equals("V")){
            this.MODE=VERTICAL;
        }
        else{
            this.MODE=HORIZONTAL;
        }
        
        childrens=new ArrayList<ChildFrame>();
        clear();
        generateChildrens();
        inputFrame=new InputFrame(new Settings(getSettings().getX(),getSettings().getHeight(),5,getSettings().getWidth()));
    }

    private void generateChildrens(){
        Settings settings=getSettings();
        int x=settings.getX();
        int y=settings.getY();
        int height=settings.getHeight();
        int width=settings.getWidth();
               
        switch(MODE){
            case VERTICAL:
                childrens.add(new ChildFrame(new Settings(x,y,height, width/2)));
                childrens.add(new ChildFrame(new Settings(x+width/2,y,height, width/2)));
                break;
            case HORIZONTAL:
                childrens.add(new ChildFrame(new Settings(x,y,height/2, width)));
                childrens.add(new ChildFrame(new Settings(x,y+height/2,height/2, width)));
                break;
        }
    }
    
    @Override
    protected void show() {
    }

    @Override
    protected void clear() {
               Writer.clear();

    }
    
}
