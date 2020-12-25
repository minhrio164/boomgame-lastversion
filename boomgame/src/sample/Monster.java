package sample;
import javafx.scene.image.ImageView;
public class Monster extends Entity {
    public int dir = 1 ;
    public int monsterSpeed = 40 ;
    public Monster(int x , int y, ImageView imageView){
        super(x,y,imageView);
    } ;

}