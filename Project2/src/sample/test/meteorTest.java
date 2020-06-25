package sample.test;

import org.junit.Test;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.game.gameobjects.Meteor;

import static org.junit.Assert.assertTrue;


public class meteorTest {

    @Test
    public void testMeteorReachesLeftOfScreen() {
        //tests if the meteor has reached the left side of the pane and stopped
        double speed = 10;
        long MIN_X = 10;
        AnchorPane pane = new AnchorPane();
        Meteor meteor = new Meteor(pane, speed);
        ImageView meteorImageView = (ImageView)pane.getChildren().get(0);
        // the ImageView of the meteor
        boolean reachedLeftEdge = false;
        while (!reachedLeftEdge) {
            reachedLeftEdge = meteor.move();
            System.out.println("x=" + meteorImageView.getX());
        }
        //Check that the while loop stops when the meteor reaches the left edge of the pane.
        assertTrue(meteorImageView.getX() <= MIN_X);
    }

}