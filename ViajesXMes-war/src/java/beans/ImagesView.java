/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author inesm
 */
@Named(value = "imagesView")
@SessionScoped
public class ImagesView implements Serializable {

    
   
     protected List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            images.add("FOTOM" + i + ".png");
             
          
             
                   
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
