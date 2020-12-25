package sample;
import javafx.scene.image.ImageView;
public class Ballon extends Entity {
    public int dir = 1 ;
    public int ballonSpeed = 40 ;
    public Ballon(int x , int y, ImageView imageView){
        super(x,y,imageView);
    } ;

}