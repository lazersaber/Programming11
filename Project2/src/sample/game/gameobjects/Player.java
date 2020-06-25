package sample.game.gameobjects;

import javafx.scene.image.ImageView;

public class Player {
    private ImageView playerImageView;
    private double increment = 0;

    private static final double MIN_Y = -140;
    private static final double MAX_Y = 150;
    private static final double INCREMENT_Y = 7;

    //Requires: ImageView playerImageView
    //Modifies: this, playerImageView
    //Effects: saves the playerImageView
    public Player(ImageView playerImageView) {
        this.playerImageView = playerImageView;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: increment is negative so direction is up
    public void setDirectionUp() {
        increment = -INCREMENT_Y;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: increment is positive so direction is down
    public void setDirectionDown() {
        increment = INCREMENT_Y;
    }

    //Requires: nothing
    //Modifies: this, increment
    //Effects: increment = 0 so player does nothing
    public void noDirection() {
        increment = 0;
    }

    //Requires: nothing
    //Modifies: this, playerYPosition, PlayerImageView
    //Effects: moves the player in a direction, makes sure player stays within the screen
    public void move(){
        if (increment == 0){
            return;
        }
        double playerYPosition = playerImageView.getY();
        playerYPosition += increment;
        if (playerYPosition < MIN_Y) {
            playerYPosition = MIN_Y;
        } else if (playerYPosition > MAX_Y){
            playerYPosition = MAX_Y;
        }
        playerImageView.setY(playerYPosition);
    }

    //Requires: Meteor meteor
    //Modifies: nothing
    //Effects: if playerImageView boundaries intersect with enemy boundaries, return true, else return false
    public boolean isCollidingWithMeteor(Meteor meteor) {
        return playerImageView.getBoundsInParent().intersects(meteor.getBoundsInParent());
    }
}