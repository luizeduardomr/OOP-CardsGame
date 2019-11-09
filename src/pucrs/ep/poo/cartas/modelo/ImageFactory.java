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
            case "img1" : return("file:./images/Um.jpg");
            case "aetherimg" : return("file:./images/aether.jpg");
            case "aberrantimg" : return("file:./images/aberrant.jpg");
            case "aeronautimg" : return("file:./images/aeronaut.jpg");
            case "img5" : return("file:./images/Cinco.jpg");
            case "img6" : return("file:./images/Seis.jpg");
            case "img7" : return("file:./images/Sete.jpg");
            case "img8" : return("file:./images/Oito.jpg");
            case "img9" : return("file:./images/Nove.jpg");
            case "img10" : return("file:./images/Dez.jpg");
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

        
        
    

