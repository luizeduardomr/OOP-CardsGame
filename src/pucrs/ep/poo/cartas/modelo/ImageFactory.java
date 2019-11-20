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
            case "arenaimg" : return("file:./images/arena.png");

            //criaturas azuis
            case "aetherimg" : return("file:./images/aether.jpg");
            case "aberrantimg" : return("file:./images/aberrant.jpg");
            case "aeronautimg" : return("file:./images/aeronaut.jpg");
            case "aleximg" : return("file:./images/alex.png");
            case "aloisioimg" : return("file:./images/aloisio.png");
            case "gabiimg" : return("file:./images/gabi.png");
            case "bluejimg" : return("file:./images/bluej.png");
            case "lucasimg" : return("file:./images/lucas.png");
            case "luizimg" : return("file:./images/luiz.png");
            case "nosimg" : return("file:./images/nos.png");
            case "pedroimg" : return("file:./images/pedro.png");
            case "renatoimg" : return("file:./images/renato.png");
            case "robertoimg" : return("file:./images/roberto.png");

            //terrenos vermelhos
            case "beiraimg" : return("file:./images/beira.png");

            //criaturas vermelhas
            case "anabaimg" : return("file:./images/anaba.jpg");
            case "afflictedimg" : return("file:./images/afflicted.jpg");
            case "ashenimg" : return("file:./images/ashen.jpg");
            case "amorimg" : return("file:./images/amor.png");
            case "aprendizimg" : return("file:./images/aprendiz.png");
            case "forcaimg" : return("file:./images/forca.png");
            case "intellijimg" : return("file:./images/intellij.png");
            case "magnataimg" : return("file:./images/magnata.png");
            case "magoimg" : return("file:./images/mago.png");
            case "mekimg" : return("file:./images/mek.png");
            case "meximg" : return("file:./images/mex.png");
            case "raimg" : return("file:./images/ra.png");

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

        
        
    

