package sample.test;

import org.junit.Test;

import javafx.scene.image.ImageView;
import sample.game.gameobjects.Player;

import static org.junit.Assert.assertTrue;


public class playerTest {

    private static double MIN_Y = -140;
    private static double MAX_Y = 150;

    @Test
    public void testGoingUpStopsAtTop() {
        //tests if player reaches top of the pane and stops
        ImageView playerImageView = new ImageView();
        Player player = new Player(playerImageView);
        player.setDirectionUp();
        for (int i = 0; i < 25; i++) {
            player.move();
            System.out.println("y=" + playerImageView.getY());
        }
        assertTrue(MIN_Y == playerImageView.getY());
        player.move();
        System.out.println("y=" + playerImageView.getY());
        assertTrue(MIN_Y == playerImageView.getY());
    }

    @Test
    public void testGoingDownStopsAtBottom() {
        //tests if player reaches the bottom of pane and stops
        ImageView imageView = new ImageView();
        Player player = new Player(imageView);
        player.setDirectionDown();
        for (int i = 0; i < 25; i++) {
            player.move();
            System.out.println("y=" + imageView.getY());
        }
        assertTrue(MAX_Y == imageView.getY());
        player.move();
        System.out.println("y=" + imageView.getY());
        assertTrue(MAX_Y == imageView.getY());
    }
}
