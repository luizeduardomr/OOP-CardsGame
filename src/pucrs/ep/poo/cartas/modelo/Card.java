package pucrs.ep.poo.cartas.modelo;

import java.util.*;



public class Card extends Observable{
    private String id;
    private String imageId;
    private boolean turned;
    
    public Card(String anId,String anImageId){
        id = anId;
        imageId = anImageId;
        turned = false;
    }
    
    public String getId(){
        return(id);
    }
    
    public String getImageId(){
        return(imageId);
    }
    
    public boolean isTurned(){
        return(turned);
    }

    public String toString(){
        return "Carta: " + id + " ";
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
        

