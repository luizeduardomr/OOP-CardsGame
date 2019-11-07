package pucrs.ep.poo.cartas.modelo;

import java.util.*;



public class Card extends Observable{
    private String id;
    private String imageId;
    private int value;
    private boolean turned;
    
    public Card(String anId,String anImageId,int val){
        id = anId;
        imageId = anImageId;
        value = val;
        turned = false;
    }
    
    public String getId(){
        return(id);
    }
    
    public String getImageId(){
        return(imageId);
    }
    
    public int getValue(){
        return(value);
    }

    public boolean isTurned(){
        return(turned);
    }


    public void turn(){
        if(turned == true){
            turned = false;
        }else{
            turned = true;
        }
        setChanged();
        notifyObservers();
    }

}
        

