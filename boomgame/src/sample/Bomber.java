package sample;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

public class Bomber extends Entity {
    public int speed = 40;
    public Bomber(int x, int y, ImageView imageView){
        super(x,y,imageView);
    }
    public int numofBoom = 0;
    public int maxofBoom = 0;
    public int powerofBooom = 0;
    public int life = 1 ;
}
