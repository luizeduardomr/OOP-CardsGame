package pucrs.ep.poo.cartas.modelo;

import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageFactory{
    private static ImageFactory imgf = new ImageFactory();
    private Map<String,Image> images;
    
    public static ImageFactory getInstance(){
      return(imgf);
    }
    
    private ImageFactory(){
        images = new HashMap<>();
    }
    
    private String id2File(String imgId){
        switch(imgId){
            //terrenos azuis
            case "islandimg" : return("file:./images/island.jpg");

            //criaturas azuis
            case "aetherimg" : return("file:./images/aether.jpg");
            case "aberrantimg" : return("file:./images/aberrant.jpg");
            case "aeronautimg" : return("file:./images/aeronaut.jpg");

            //magicas azuis
            case "aerialimg" : return("file:./images/aerial.jpg");

            //terrenos vermelhos
            case "mountainimg" : return("file:./images/mountain.jpg");

            //criatureas vermelhas
            case "anabaimg" : return("file:./images/anaba.jpg");
            case "afflictedimg" : return("file:./images/afflicted.jpg");
            case "ashenimg" : return("file:./images/ashen.jpg");

            //magicas vermelhas
            case "agilityimg" : return("file:./images/agility.jpg");

            //legacy
            case "imgBck" : return("file:./images/Back.png");

            default: throw new IllegalArgumentException("Invalid image Id");
        }
    }
    
    public ImageView createImage(String imgId){
        Image img = images.get(imgId);
        if (img == null){
            img = new Image(id2File(imgId));
            images.put(imgId,img);
        }
 
        //Image img = new Image(id2File(imgId));
        return(new ImageView(img));
    }
}

        
        
    

