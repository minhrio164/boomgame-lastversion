package sample;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Main extends Application {

    Stage stage;
    Pane root = new Pane();
    Scene scene = new Scene(root);



    String Bomber_Path = "/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/font-01.png";
    Image Bomber_image = new Image(new FileInputStream(Bomber_Path));
    Image Bomber_back = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/back-01.png"));
    Image Bomber_right = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/right-01.png"));
    Image Bomber_left = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/left-01.png"));
    ImageView Bomber_ImageView = new ImageView(Bomber_image);

    Image Boom_right = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/boom_right.png"));
    Image Boom_left = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/boom_right.png"));
    Image Boom_up = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/boom_up.png"));
    Image Boom_down = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/boom_up.png"));
    Image Boom_center = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/boom_center.png"));


    String Grass_Path = "/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/Grass-01.png";
    Image Grass_Image = new Image(new FileInputStream(Grass_Path));
    ImageView Grass_ImageView = new ImageView(Grass_Image);

    String Wall_path = "/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/Wall-01.png";
    Image Wall_image = new Image(new FileInputStream(Wall_path));
    ImageView Wall_ImageView = new ImageView(Wall_image);

    String Brick_path = "/Users/mac/Desktop/Code/boomgame/src/image/Brick-01.png";
    Image Brick_Image = new Image(new FileInputStream(Brick_path));
    ImageView Brick_ImageView = new ImageView(Brick_Image);

    Image Ballon_Image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/ballon-left-01.png"));
    ImageView Ballon_ImageView = new ImageView(Ballon_Image);
    Image Ballon_Image_right = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/ballon-right-01.png"));

    Image Oneal_Image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Oneal-01.png"));
    ImageView Oneal_ImageView = new ImageView(Oneal_Image);

    Image Boom_image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/boom.png"));
    ImageView Boom_ImageView = new ImageView(Boom_image);

    Image Boomitems_image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/boomitem-01.png"));
    ImageView Boomitems_ImaageView = new ImageView(Boomitems_image);

    Image Poweritems_image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/Xmas-Kit/poweritem-01.png"));
    ImageView Poweritems_ImageView = new ImageView(Poweritems_image);

    Image Monster_Image = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/monster.png"));
    ImageView Monster_Imageview = new ImageView(Monster_Image);




    int Pixel_Height = 40;
    int Pixel_Width = 40;
    ImageView[] imageviewofBomber = new ImageView[10000];
    List<Bomber> listofBomber = new ArrayList<Bomber>(1000);
    int bomberSpeed = 40;
    ImageView[] imageviewofWall = new ImageView[10000];
    List<Wall> listofWall = new ArrayList<Wall>(1000);
    List<Grass> listofGlass = new ArrayList<Grass>(1000);
    ImageView[] imageviewofGlass = new ImageView[10000];
    ImageView[] imageviewofBrick = new ImageView[10000];
    List<Brick> listofBrick = new ArrayList<Brick>(1000);
    ImageView[] imageviewofBallon = new ImageView[10000];
    List<Ballon> listofBallon = new ArrayList<Ballon>(1000);
    ImageView[] imageviewofMonster = new ImageView[1000];
    List<Monster> listofMonster = new ArrayList<>();

    ImageView[] imageviewofOneal = new ImageView[10000];
    List<Oneal> listofOneal = new ArrayList<Oneal>(1000);
    ImageView[] imageviewofBoom = new ImageView[100];

    List<Boom> listofBoom = new ArrayList<Boom>(1000);

    List<Boomitems> listofBoomitems = new ArrayList<>(1000);
    ImageView[] imageviewofBoomitems = new ImageView[1000];

    List<Poweritem> listofPoweritems = new ArrayList<Poweritem>(1000);
    ImageView[] imageviewofPoweritems = new ImageView[1000];



    Image imageofPortal = new Image(new FileInputStream("/Users/mac/Desktop/Code/boomgame/src/image/portal-01.png"));
    ImageView imageviewofPortal = new ImageView(imageofPortal);


    String ssound = "/Users/mac/Desktop/Code/boomgame/footsteps.mp3";
    Media sound = new Media(new File(ssound).toURI().toString());

    String musicbackground = "/Users/mac/Desktop/Code/boomgame/music_1.wav";
    Media musicmediabg = new Media(new File(musicbackground).toURI().toString());

    String itemsoundstring ="/Users/mac/Desktop/Code/boomgame/pickItem.wav";
    Media itemmedia = new Media(new File(itemsoundstring).toURI().toString());

    String gameoverstring = "/Users/mac/Desktop/Code/boomgame/gameover.wav";
    Media gameovermedia = new Media(new File(gameoverstring).toURI().toString());

    String tictacstring = "/Users/mac/Desktop/Code/boomgame/tictac.wav";
    Media tictacmedia = new Media(new File(tictacstring).toURI().toString());

    String explotisonstring = "/Users/mac/Desktop/Code/boomgame/Explosion.wav";
    Media explosionmedia = new Media(new File(explotisonstring).toURI().toString());

    String winstring = "/Users/mac/Desktop/Code/boomgame/win.wav" ;
    Media winmedia = new Media(new File(winstring).toURI().toString());



    ImageView[] Boom_up_imageview = new ImageView[1000];
    ImageView[] Boom_down_imageview = new ImageView[1000];
    ImageView[] Boom_right_imageview = new ImageView[1000];
    ImageView[] Boom_left_imageview = new ImageView[1000];
    ImageView[] Boom_center_imageview = new ImageView[1000];

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void rendermap() {
        File file = new File("/Users/mac/Desktop/Code/boomgame/src/map.txt");
        try {
            Scanner scanner = new Scanner(file);
            String firstline = scanner.nextLine();
            String[] mapsize = firstline.split(" ", 3);
            stage.setWidth(Integer.parseInt(mapsize[2]) * Pixel_Width);
            stage.setHeight((Integer.parseInt(mapsize[1]) * Pixel_Width) + 20);
            int temp = 1;
            while (scanner.hasNextLine()) {

                String data = scanner.nextLine();
                for (int i = 0; i < Integer.parseInt(mapsize[2]); i++) {
                    char key = data.charAt(i);
                    Grass grass = new Grass(i * Pixel_Width, (temp - 1) * Pixel_Height, Grass_ImageView);
                    listofGlass.add(grass);

                    if (key == '#') {
                        Wall wall = new Wall(i * Pixel_Width, (temp - 1) * Pixel_Height, Wall_ImageView);
                        listofWall.add(wall);
                    } else if (key == '*') {
                        Brick brick = new Brick(i * Pixel_Width, (temp - 1) * Pixel_Height, Brick_ImageView);
                        listofBrick.add(brick);
                    } else if (key == 'p') {
                        Bomber bomber = new Bomber(i * Pixel_Width, (temp - 1) * Pixel_Height, Bomber_ImageView);
                        listofBomber.add(bomber);
                    } else if (key == '1') {
                        Ballon ballon = new Ballon(i * Pixel_Width, (temp - 1) * Pixel_Height, Ballon_ImageView);
                        listofBallon.add(ballon);
                    } else if (key == '2') {
                        Monster monster = new Monster(i * Pixel_Width, (temp - 1) * Pixel_Height, Monster_Imageview);
                        listofMonster.add(monster);
                    }
                    else if (key == 'x'){
                        Boomitems boomitems = new Boomitems(i*Pixel_Width,(temp-1)*Pixel_Height,Boomitems_ImaageView);
                        listofBoomitems.add(boomitems);
                    }

                }
                temp++;
            }
            scanner.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }

    public void createEntity() throws FileNotFoundException {


        for (int i = 0; i < listofGlass.size(); i++) {
            imageviewofGlass[i] = new ImageView(Grass_Image);
            imageviewofGlass[i].setX(listofGlass.get(i).x);
            imageviewofGlass[i].setY(listofGlass.get(i).y);
            imageviewofGlass[i].setFitHeight(Pixel_Height);
            imageviewofGlass[i].setFitWidth(Pixel_Width);
            root.getChildren().add(imageviewofGlass[i]);

        }
        for (int i = 0; i < listofWall.size(); i++) {
            imageviewofWall[i] = new ImageView(Wall_image);
            imageviewofWall[i].setX(listofWall.get(i).x);
            imageviewofWall[i].setY(listofWall.get(i).y);
            imageviewofWall[i].setFitHeight(Pixel_Height);
            imageviewofWall[i].setFitWidth(Pixel_Width);
            root.getChildren().add(imageviewofWall[i]);

        }

        for (int i = 0; i < listofBomber.size(); i++) {
            imageviewofBomber[i] = new ImageView(Bomber_image);
            imageviewofBomber[i].setX(listofBomber.get(i).x);
            imageviewofBomber[i].setY(listofBomber.get(i).y);
            imageviewofBomber[i].setFitWidth(Pixel_Width);
            imageviewofBomber[i].setFitHeight(Pixel_Height);
            root.getChildren().add(imageviewofBomber[i]);

        }
        for (int i = 0; i < listofBallon.size(); i++) {
            imageviewofBallon[i] = new ImageView(Ballon_Image);
            imageviewofBallon[i].setX(listofBallon.get(i).x);
            imageviewofBallon[i].setY(listofBallon.get(i).y);
            imageviewofBallon[i].setFitWidth(Pixel_Width);
            imageviewofBallon[i].setFitHeight(Pixel_Height);
            root.getChildren().add(imageviewofBallon[i]);

        }
        for (int i = 0; i < listofMonster.size(); i++) {
            imageviewofMonster[i] = new ImageView(Monster_Image);
            imageviewofMonster[i].setX(listofMonster.get(i).x);
            imageviewofMonster[i].setY(listofMonster.get(i).y);
            imageviewofMonster[i].setFitHeight(Pixel_Height);
            imageviewofMonster[i].setFitWidth(Pixel_Width);
            root.getChildren().add(imageviewofMonster[i]);
        }




        Random rd = new Random();
        int a = 3;
        imageviewofPortal.setX(listofBrick.get(a).x);
        imageviewofPortal.setY(listofBrick.get(a).y);
        imageviewofPortal.setFitHeight(Pixel_Height);
        imageviewofPortal.setFitWidth(Pixel_Width);
        root.getChildren().add(imageviewofPortal);


        int b = rd.nextInt(listofBrick.size());
        Boomitems boomitems = new Boomitems(listofBrick.get(b).x,listofBrick.get(b).y,Boomitems_ImaageView);
        listofBoomitems.add(boomitems);

        int c = rd.nextInt(listofBrick.size());
        Poweritem poweritem = new Poweritem(listofBrick.get(c).x,listofBrick.get(c).y,Poweritems_ImageView);
        listofPoweritems.add(poweritem) ;
        imageviewofPoweritems[2] = new ImageView(Poweritems_image);
        imageviewofPoweritems[2].setX(listofPoweritems.get(0).x);
        imageviewofPoweritems[2].setY(listofPoweritems.get(0).y);
        imageviewofPoweritems[2].setFitHeight(Pixel_Height);
        imageviewofPoweritems[2].setFitWidth(Pixel_Width);
        root.getChildren().addAll(imageviewofPoweritems[2]);

        for ( int i=0; i<listofBoomitems.size(); i++){
            imageviewofBoomitems[i] = new ImageView(Boomitems_image);
            imageviewofBoomitems[i].setX(listofBoomitems.get(i).x);
            imageviewofBoomitems[i].setY(listofBoomitems.get(i).y);
            imageviewofBoomitems[i].setFitHeight(Pixel_Height);
            imageviewofBoomitems[i].setFitWidth(Pixel_Width);
            root.getChildren().add(imageviewofBoomitems[i]);

        }

        for (int i = 0; i < listofBrick.size(); i++) {
            imageviewofBrick[i] = new ImageView(Brick_Image);
            imageviewofBrick[i].setX(listofBrick.get(i).x);
            imageviewofBrick[i].setY(listofBrick.get(i).y);
            imageviewofBrick[i].setFitWidth(Pixel_Width);
            imageviewofBrick[i].setFitHeight(Pixel_Height);
            root.getChildren().add(imageviewofBrick[i]);

        }
    }


    public void win(Scene scene){
        if (imageviewofBomber[0].getX() == imageviewofPortal.getX() && imageviewofBomber[0].getY() == imageviewofPortal.getY() && monster == -5){
            stage.setScene(scene);
            MediaPlayer winmediaPlayer = new MediaPlayer(winmedia);
            winmediaPlayer.play();
        }
    }

    public void CreateBoom(int y) {

        imageviewofBoom[y] = new ImageView(Boom_image);
        imageviewofBoom[y].setX(listofBoom.get(listofBoom.size() - 1).x);
        imageviewofBoom[y].setY(listofBoom.get(listofBoom.size() - 1).y);
        imageviewofBoom[y].setFitWidth(Pixel_Width);
        imageviewofBoom[y].setFitHeight(Pixel_Height);
        root.getChildren().add(imageviewofBoom[y]);

    }

    public int check_move(double x, double y) {
        int a = 0;
        for (int i = 0; i < listofWall.size(); i++) {
            if ((x - imageviewofWall[i].getX()) == 0
                    && (y - imageviewofWall[i].getY()) == 0) {
                a++;
                break;
            }
            for (int k = 0; k < listofBrick.size(); k++) {
                if ((x - imageviewofBrick[k].getX() == 0
                        && (y - imageviewofBrick[k].getY()) == 0)) {
                    a++;
                    break;
                }
            }
            for (int j = 0; j < listofBoom.size(); j++) {
                if ((x - imageviewofBoom[j].getX()) == 0
                        && (y - imageviewofBoom[j].getY() == 0)) {
                    a++;
                    break;
                }

            }
        }
        return a;
    }

    public void ballon_move() {

        for (int i = 0; i < listofBallon.size(); i++) {
            double move_left = imageviewofBallon[i].getX() - listofBallon.get(i).ballonSpeed;
            double move_right = imageviewofBallon[i].getX() + listofBallon.get(i).ballonSpeed;

            if (check_move(move_left, imageviewofBallon[i].getY()) != 0) {
                listofBallon.get(i).dir = 1 - listofBallon.get(i).dir;
                imageviewofBallon[i].setX(move_right);
                imageviewofBallon[i].setImage(Ballon_Image_right);
                GameOver();

            } else if (check_move(move_right, imageviewofBallon[i].getY()) != 0) {
                listofBallon.get(i).dir = 1 - listofBallon.get(i).dir;
                imageviewofBallon[i].setX(move_left);
                imageviewofBallon[i].setImage(Ballon_Image);
                GameOver();

            } else if (listofBallon.get(i).dir == 1) {
                imageviewofBallon[i].setX(move_left);
                imageviewofBallon[i].setImage(Ballon_Image);
                GameOver();


            } else if (listofBallon.get(i).dir == 0) {
                imageviewofBallon[i].setX(move_right);
                imageviewofBallon[i].setImage(Ballon_Image_right);
                GameOver();

            }


        }
    }
    public void monster_move(){
        for(int i=0; i<listofMonster.size();i++){
            double move_up = imageviewofMonster[i].getY() - listofMonster.get(i).monsterSpeed;
            double move_down = imageviewofMonster[i].getY() + listofMonster.get(i).monsterSpeed;

            if(check_move(imageviewofMonster[i].getX(),move_down )!= 0){
                listofMonster.get(i).dir = 1 -listofMonster.get(i).dir ;
                imageviewofMonster[i].setY(move_up);
                GameOver();

            }
            if(check_move(imageviewofMonster[i].getX(),move_up)!=0){
                listofMonster.get(i).dir = 1 - listofMonster.get(i).dir ;
                imageviewofMonster[i].setY(move_down);
                GameOver();
            }
            else if (listofMonster.get(i).dir ==1 ){
                imageviewofMonster[i].setY(move_down);
                GameOver();
            }
            else if ( listofMonster.get(i).dir ==0){
                imageviewofMonster[i].setY(move_up);
                GameOver();
            }

        }
    }
    public void eat(){
        MediaPlayer itemsound = new MediaPlayer(itemmedia);
        itemsound.setVolume(0.6);
        for(int i=0 ; i<listofBoomitems.size() ; i++){
            if(imageviewofBomber[0].getX() == imageviewofBoomitems[i].getX() && imageviewofBomber[0].getY() == imageviewofBoomitems[i].getY()){
                listofBomber.get(0).maxofBoom ++;
                listofBomber.get(0).numofBoom ++ ;
                imageviewofBoomitems[i].setVisible(false);
                listofBoomitems.get(i).x = -300 ;
                itemsound.play();
            }
        }

            if(imageviewofBomber[0].getX() == imageviewofPoweritems[2].getX() && imageviewofBomber[0].getY() == imageviewofPoweritems[2].getY()){
                listofBomber.get(0).powerofBooom ++ ;
                imageviewofPoweritems[2].setVisible(false);
                listofPoweritems.get(0).x=-400;
                itemsound.play();
            }

    }

    public void GameOver() {
        for (int i = 0; i < listofBallon.size(); i++) {
            if (imageviewofBomber[0].getX() == imageviewofBallon[i].getX()
                    && imageviewofBomber[0].getY() == imageviewofBallon[i].getY()) {
                listofBomber.get(0).life -- ;

            }

        }
        for ( int i= 0 ; i <listofMonster.size(); i++){
            if(imageviewofBomber[0].getX() == imageviewofMonster[i].getX()
            && imageviewofBomber[0].getY() == imageviewofMonster[i].getY()){
                listofBomber.get(0).life -- ;
            }
        }
    }
    int monster = 0;
    public void BoomDestroy(double x, double y, int i) {
        Timer t = new Timer();
        for(int j = 0 ; j<= listofBomber.get(0).powerofBooom; j++) {
            Boom_up_imageview[i + j] = new ImageView(Boom_up);
            Boom_up_imageview[i + j].setY(y + Pixel_Height * (j+1));
            Boom_up_imageview[i + j].setX(x);
            Boom_up_imageview[i + j].setFitHeight(Pixel_Height );
            Boom_up_imageview[i + j].setFitWidth(Pixel_Width );

            Boom_down_imageview[i +j] = new ImageView(Boom_down);
            Boom_down_imageview[i +j].setY(y - Pixel_Height * (j+1));
            Boom_down_imageview[i + j].setX(x);
            Boom_down_imageview[i + j].setFitWidth(Pixel_Width);
            Boom_down_imageview[i + j].setFitHeight(Pixel_Height);

            Boom_right_imageview[i +j] = new ImageView(Boom_right);
            Boom_right_imageview[i + j].setY(y);
            Boom_right_imageview[i +j].setX(x + Pixel_Width * ( j+1));
            Boom_right_imageview[i +j].setFitHeight(Pixel_Height);
            Boom_right_imageview[i +j].setFitWidth(Pixel_Width);

            Boom_left_imageview[i +j] = new ImageView(Boom_left);
            Boom_left_imageview[i +j].setY(y);
            Boom_left_imageview[i +j].setX(x - Pixel_Width * (j+1));
            Boom_left_imageview[i +j].setFitWidth(Pixel_Width);
            Boom_left_imageview[i +j].setFitHeight(Pixel_Height);
            Boom_center_imageview[i+j] = new ImageView(Boom_center);
            Boom_center_imageview[i+j].setX(x);
            Boom_center_imageview[i+j].setY(y);
            Boom_center_imageview[i+j].setFitWidth(40);
            Boom_center_imageview[i+j].setFitHeight(40);

            root.getChildren().addAll(Boom_down_imageview[i+j], Boom_left_imageview[i+j], Boom_up_imageview[i+j], Boom_right_imageview[i+j], Boom_center_imageview[i+j]);
        }


        for (int k = 0; k < listofBrick.size(); k++) {
            if (imageviewofBrick[k].getX() == Boom_up_imageview[i].getX() &&
                    imageviewofBrick[k].getY() == Boom_up_imageview[i].getY()
            ) {

                imageviewofBrick[k].setX(-1000);
                listofBrick.get(k).x = -1000 ;
                break;
            }

        }
        for (int k = 0; k < listofBrick.size(); k++) {
            if (imageviewofBrick[k].getX() == Boom_down_imageview[i].getX() &&
                    imageviewofBrick[k].getY() == Boom_down_imageview[i].getY()
            ) {

                imageviewofBrick[k].setX(-900);
                listofBrick.get(k).x = -1000 ;
                break;
            }

        }
        for (int k = 0; k < listofBrick.size(); k++) {
            if (imageviewofBrick[k].getX() == Boom_right_imageview[i].getX() &&
                    imageviewofBrick[k].getY() == Boom_right_imageview[i].getY()
            ) {

                imageviewofBrick[k].setX(-800);
                listofBrick.get(k).x = -1000 ;
                break;
            }

        }
        for (int k = 0; k < listofBrick.size(); k++) {
            if (imageviewofBrick[k].getX() == Boom_left_imageview[i].getX() &&
                    imageviewofBrick[k].getY() == Boom_left_imageview[i].getY()
            ) {

                imageviewofBrick[k].setX(-700);
                listofBrick.get(k).x = -1000 ;
                break;
            }

        }

        for(int j = 0 ; j<=listofBomber.get(0).powerofBooom ; j++) {

            for (int k = 0; k < listofBallon.size(); k++) {
                if (imageviewofBallon[k].getX() == Boom_up_imageview[i+j].getX() &&
                        imageviewofBallon[k].getY() == Boom_up_imageview[i+j].getY()
                ) {

                    imageviewofBallon[k].setX(-1000);
                    listofBallon.get(k).ballonSpeed = 0;
                    monster--;
                    break;
                }

            }
            for (int k = 0; k < listofBallon.size(); k++) {
                if (imageviewofBallon[k].getX() == Boom_down_imageview[i+j].getX() &&
                        imageviewofBallon[k].getY() == Boom_down_imageview[i+j].getY()
                ) {
                    imageviewofBallon[k].setX(-1000);
                    listofBallon.get(k).ballonSpeed = 0;
                    monster--;
                    break;
                }

            }
            for (int k = 0; k < listofBallon.size(); k++) {
                if (imageviewofBallon[k].getX() == Boom_right_imageview[i+j].getX() &&
                        imageviewofBallon[k].getY() == Boom_right_imageview[i+j].getY()
                ) {
                    imageviewofBallon[k].setX(-1000);
                    listofBallon.get(k).ballonSpeed = 0;
                    monster--;
                    break;
                }

            }
            for (int k = 0; k < listofBallon.size(); k++) {
                if (imageviewofBallon[k].getX() == Boom_left_imageview[i+j].getX() &&
                        imageviewofBallon[k].getY() == Boom_left_imageview[i+j].getY()
                ) {

                    imageviewofBallon[k].setX(-1000);
                    listofBallon.get(k).ballonSpeed = 0;
                    monster--;
                    break;
                }

            }

            for ( int k=0 ; k<listofMonster.size();k++){
                if(imageviewofMonster[k].getX() == Boom_left_imageview[i+j].getX() &&
                        imageviewofMonster[k].getY() == Boom_left_imageview[i+j].getY()
                ) {
                    imageviewofMonster[k].setX(-1000);
                    listofMonster.get(k).monsterSpeed =0;
                    monster -- ;
                    break ;
                }
            }

            for ( int k=0 ; k<listofMonster.size();k++){
                if(imageviewofMonster[k].getX() == Boom_right_imageview[i+j].getX() &&
                        imageviewofMonster[k].getY() == Boom_right_imageview[i+j].getY()
                ) {
                    imageviewofMonster[k].setX(-1000);
                    listofMonster.get(k).monsterSpeed =0;
                    monster -- ;
                    break ;
                }
            }

            for ( int k=0 ; k<listofMonster.size();k++){
                if(imageviewofMonster[k].getX() == Boom_up_imageview[i+j].getX() &&
                        imageviewofMonster[k].getY() == Boom_up_imageview[i+j].getY()
                ) {
                    imageviewofMonster[k].setX(-1000);
                    listofMonster.get(k).monsterSpeed =0;
                    monster -- ;
                    break ;
                }
            }

            for ( int k=0 ; k<listofMonster.size();k++){
                if(imageviewofMonster[k].getX() == Boom_down_imageview[i+j].getX() &&
                        imageviewofMonster[k].getY() == Boom_down_imageview[i+j].getY()
                ) {
                    imageviewofMonster[k].setX(-1000);
                    listofMonster.get(k).monsterSpeed =0;
                    monster -- ;
                    break ;
                }
            }














            for (int k = 0; k < listofWall.size(); k++) {
                if (imageviewofWall[k].getY() == Boom_down_imageview[i].getY() && imageviewofWall[k].getX() == Boom_down_imageview[i].getX()) {
                    for(int n=0 ; n<=listofBomber.get(0).powerofBooom ; n++) {
                        Boom_down_imageview[i+n].setVisible(false);

                    }
                }
            }
            for (int k = 0; k < listofWall.size(); k++) {
                if (imageviewofWall[k].getY() == Boom_up_imageview[i].getY() && imageviewofWall[k].getX() == Boom_up_imageview[i].getX()) {
                    for(int n=0 ; n<=listofBomber.get(0).powerofBooom ; n++) {
                        Boom_up_imageview[i + n].setVisible(false);
                    }
                }
            }
            for (int k = 0; k < listofWall.size(); k++) {
                if (imageviewofWall[k].getY() == Boom_left_imageview[i].getY() && imageviewofWall[k].getX() == Boom_left_imageview[i].getX()) {
                    for(int n=0 ; n<=listofBomber.get(0).powerofBooom ; n++) {
                        Boom_left_imageview[i + n].setVisible(false);
                    }
                }
            }
            for (int k = 0; k < listofWall.size(); k++) {
                if (imageviewofWall[k].getY() == Boom_right_imageview[i].getY() && imageviewofWall[k].getX() == Boom_right_imageview[i].getX()) {
                    for(int n=0 ; n<=listofBomber.get(0).powerofBooom ; n++) {
                        Boom_right_imageview[i + n].setVisible(false);
                    }
                }
            }

        }



    }


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        this.stage = stage;
        rendermap();
        createEntity();
        MediaPlayer backgroundmedia = new MediaPlayer(musicmediabg);
        backgroundmedia.play();
        backgroundmedia.setVolume(0.1);


        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                ballon_move();
                monster_move();


            }
        }, 0, 200);

        //pri();
        Pane winpane = new Pane() ;
        Scene winscene = new Scene(winpane);
        winpane.setId("winpane");
        winscene.getStylesheets().add(getClass().getResource("mainScreen.css").toExternalForm());

        Pane overpane = new Pane();
        Scene overscene = new Scene(overpane);
        overpane.setId("overpane");
        overscene.getStylesheets().add(getClass().getResource("mainScreen.css").toExternalForm());


        Pane mainScreen = new Pane();
        mainScreen.setId("pane");
        Scene sceneScreen = new Scene(mainScreen);
        stage.setScene(sceneScreen);
        stage.show();
        Button startButton = new Button();
        startButton.setLayoutX(100);
        startButton.setLayoutY(250);
        startButton.setPrefSize(200, 60);
        startButton.setId("startButton");
        mainScreen.getChildren().addAll(startButton);
        sceneScreen.getStylesheets().add(getClass().getResource("mainScreen.css").toExternalForm());
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene);
                stage.show();
            }
        });
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                Platform.runLater(() -> {
                    if(listofBomber.get(0).life <= 0){
                        stage.setScene(overscene);
                        MediaPlayer gameoversound = new MediaPlayer(gameovermedia);
                        gameoversound.play();
                        t.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.exit(0);
                            }
                        },800,800);

                    }

                });

            }
        }, 0, 1000);


        System.out.println(listofBomber.get(0).numofBoom);
        stage.setTitle("BomberMan");
        stage.setResizable(false);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()) {

                    case UP:
                        double Up_move = imageviewofBomber[0].getY() - bomberSpeed;
                        if (check_move(imageviewofBomber[0].getX(), Up_move) == 0) {
                            imageviewofBomber[0].setY(Up_move);
                            imageviewofBomber[0].setImage(Bomber_back);
                            eat();
                            GameOver();
                            win(winscene);
                            MediaPlayer mediaPlayer = new MediaPlayer(sound);
                            mediaPlayer.play();
                        }
                        break;
                    case DOWN:

                        double Down_move = (imageviewofBomber[0].getY() + bomberSpeed);
                        if (check_move(imageviewofBomber[0].getX(), Down_move) == 0) {
                            imageviewofBomber[0].setY(Down_move);
                            imageviewofBomber[0].setImage(Bomber_image);
                            eat();
                            GameOver();
                            win(winscene);
                            MediaPlayer mediaPlayer = new MediaPlayer(sound);
                            mediaPlayer.play();
                        }
                        break;
                    case RIGHT:
                        double Right_move = (imageviewofBomber[0].getX() + bomberSpeed);
                        if (check_move(Right_move, imageviewofBomber[0].getY()) == 0) {
                            imageviewofBomber[0].setX(Right_move);
                            imageviewofBomber[0].setImage(Bomber_right);
                            eat();
                            GameOver();
                            win(winscene);
                            MediaPlayer mediaPlayer = new MediaPlayer(sound);
                            mediaPlayer.play();
                        }
                        break;
                    case LEFT:
                        double Left_move = (imageviewofBomber[0].getX() - bomberSpeed);
                        if (check_move(Left_move, imageviewofBomber[0].getY()) == 0) {
                            imageviewofBomber[0].setX(Left_move);
                            imageviewofBomber[0].setImage(Bomber_left);
                            eat();
                            GameOver();
                            win(winscene);
                            MediaPlayer mediaPlayer = new MediaPlayer(sound);
                            mediaPlayer.play();
                        }
                        break;
                    case SPACE:
                        int boom_index = listofBomber.get(0).maxofBoom - listofBomber.get(0).numofBoom;

                        if (listofBomber.get(0).numofBoom >= 0) {
                            Boom boom = new Boom((int) Math.round(imageviewofBomber[0].getX()), (int) Math.round(imageviewofBomber[0].getY()), Boom_ImageView);
                            listofBoom.add(boom);
                            CreateBoom(boom_index);
                            MediaPlayer tictacsound = new MediaPlayer(tictacmedia);
                            tictacsound.play();
                            listofBomber.get(0).numofBoom--;
                            t.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    imageviewofBoom[boom_index].setVisible(false);
                                    Platform.runLater(() -> {
                                        BoomDestroy(imageviewofBoom[boom_index].getX(), imageviewofBoom[boom_index].getY(), boom_index);
                                        listofBomber.get(0).numofBoom++;

                                    });
                                    t.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            for ( int j =0 ; j<=listofBomber.get(0).powerofBooom ; j++) {
                                                Boom_down_imageview[boom_index +j].setVisible(false);
                                                Boom_up_imageview[boom_index +j].setVisible(false);
                                                Boom_left_imageview[boom_index +j].setVisible(false);
                                                Boom_right_imageview[boom_index + j ].setVisible(false);
                                                Boom_center_imageview[boom_index +j].setVisible(false);
                                            }
                                            MediaPlayer explosionsound = new MediaPlayer(explosionmedia);
                                            explosionsound.play();
                                            listofBoom.remove(0);

                                        }
                                    }, 300);

                                }
                            }, 2000);
                            System.out.println(monster);
                            System.out.println(listofBallon.size());


/*
                            t.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    imageviewofBoom[listofBoom.size()-1].setVisible(false);
                                    t.schedule(new TimerTask() {
                                        @Override
                                        public void run() {
                                            Platform.runLater(() -> {
                                                BoomDestroy(listofBoom.get(listofBoom.size()-1).x,listofBoom.get(listofBoom.size()-1).y);
                                            });
                                            t.schedule(new TimerTask() {
                                                @Override
                                                public void run() {
                                                    Boom_down_imageview[listofBoom.size()-1].setVisible(false);
                                                    Boom_up_imageview[listofBoom.size()-1].setVisible(false);
                                                    Boom_left_imageview[listofBoom.size()-1].setVisible(false);
                                                    Boom_right_imageview[listofBoom.size()-1].setVisible(false);
                                                    listofBoom.remove(listofBoom.size()-1);
                                                    listofBomber.get(0).numofBoom++;
                                                }
                                            },1000);
                                        }

                                    },1);
                                }
                            },2000);
                            */
                        } else {
                            break;
                        }

                }
            }
        });

    }
}




