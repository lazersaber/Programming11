package sample.game.gameobjects;

import java.util.concurrent.ThreadLocalRandom;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Meteor {
    private Pane pane;
    private ImageView imageView;
    private double speed;

    private static int WIDTH = 50;
    private static int HEIGHT = 50;
    private static int MIN_X = 10;
    private static int MAX_X = 540;
    private static int MIN_Y = 40;
    private static int MAX_Y = 340;

    //Requires: Pane pane, double meteorSpeed
    //Modifies: this, pane
    //Effects: creates a meteor by creating an imageView with Meteor.png that is added to pane
    //imageView is assigned, a width, height, and x and y position
    //Y position is a random value between MIN_Y and MAX_Y
    public Meteor(Pane pane, double meteorSpeed) {
        this.pane = pane;
        Image enemy = new Image(getClass().getResourceAsStream("/sample/images/Meteor.png"));
        imageView = new ImageView(enemy);
        pane.getChildren().add(imageView);

        imageView.setFitHeight(HEIGHT);
        imageView.setFitWidth(WIDTH);

        int randomY = ThreadLocalRandom.current().nextInt(MIN_Y, MAX_Y + 1);
        imageView.setX(MAX_X);
        imageView.setY(randomY);

        speed = meteorSpeed;
    }

    //Requires: nothing
    //Modifies: this
    //Effects: moves the meteor backwards (left) and checks if this reaches the left side of the window
    //If yes, it removes the imageView from pane and returns true, else it returns false.
    public boolean move(){
        double meteorXPosition = imageView.getX();
        imageView.setX(meteorXPosition - speed);
        if(meteorXPosition < MIN_X){
            pane.getChildren().remove(imageView);
            return true;
        } else {
            return false;
        }
    }

    //Requires: nothing
    //Modifies: nothing
    //Effects: returns the imageView boundaries in parent pane
    public Bounds getBoundsInParent() {
        return imageView.getBoundsInParent();
    }
}
