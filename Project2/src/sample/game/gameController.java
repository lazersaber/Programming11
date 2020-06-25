package sample.game;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.game.gameobjects.Meteor;
import sample.game.gameobjects.Player;
import sample.gameover.FinalScoreManager;

public class gameController {
    public AnchorPane anchorPane;
    private FinalScoreManager finalScoreManager;
    public Label score;

    private ArrayList<Meteor> meteors;
    private double meteorSpeed = 7;
    private double meteorSpeedCounter = 0;
    private long timeOfNextMeteor = 0;
    private long meteorDelay = 700000000;
    private int meteorDelayCounter = 0;

    public ImageView playerImageView;
    private Player player;
    private AnimationTimer animationTimer;

    //Requires: KeyEvent keyEvent
    //Modifies: nothing
    //Effects: up and down keys make the player go up and down, all other keys do nothing
    public void handleKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP){
            player.setDirectionUp();
        } else if (keyEvent.getCode() == KeyCode.DOWN){
            player.setDirectionDown();
        } else {
            player.noDirection();
        }
    }

    //Requires: KeyEvent keyEvent
    //Modifies: this, keyEvent
    //Effects: player does not move when keys are released
    public void handleKeyRelease(KeyEvent keyEvent) {
        player.noDirection();
    }

    //Requires: nothing
    //Modifies: scene
    //Effects: initializes key handlers, the player, and empty list of meteors, starts animation timer
    public void startPlay(){
        Scene scene = score.getScene();
        scene.setOnKeyPressed(this::handleKeyPress);
        scene.setOnKeyReleased(this::handleKeyRelease);

        finalScoreManager = new FinalScoreManager();

        player = new Player(playerImageView);
        meteors = new ArrayList<>();

        animationTimer = new AnimationTimer() {
            public void handle(long now){
                try {
                    animationTick(now);
                } catch(Exception x) {
                }
            }
        };
        animationTimer.start();
    }

    //Requires: long now
    //Modifies: scene components
    //Effects: moves the player, moves/removes/creates meteors, updates the score
    private void animationTick(long now) throws IOException{
        player.move();
        ArrayList<Meteor> remainingMeteors = new ArrayList<>();
        for(Meteor meteor: meteors){
            boolean isOffScreen = meteor.move();
            if(isOffScreen){
                incrementScore();
            }
            else {
                if(player.isCollidingWithMeteor(meteor)){
                    endGame();
                    return;
                } else {
                    remainingMeteors.add(meteor);
                }
            }
        }
        meteors = remainingMeteors;

        if (now < timeOfNextMeteor){
            return;
        }

        if (meteorDelayCounter == 15){
            meteorDelay -= 100050000;
            meteorDelayCounter++;
        }
        long randomDelay = meteorDelay;
        timeOfNextMeteor = now + randomDelay;

        if (meteorSpeedCounter == 10){
            meteorSpeedCounter = 0;
            meteorSpeed += 2;
        }
        Meteor meteor = new Meteor(anchorPane, meteorSpeed);
        meteorSpeedCounter++;
        meteors.add(meteor);
    }

    //Requires: nothing
    //Modifies: this, numberOfMeteorsDodged, score
    //Effects: increases score by increments of 1
    private void incrementScore(){
        int numberOfMeteorsDodged = Integer.parseInt(score.getText());
        numberOfMeteorsDodged++;
        score.setText(Integer.toString(numberOfMeteorsDodged));
    }

    //Requires: nothing
    //Modifies: this, animationTimer, finalScoreManager
    //Effects: stops the animation timer, records final score, and calls changeSceneToGameOverView()
    private void endGame() throws IOException{
        animationTimer.stop();
        int meteorsDodged = Integer.parseInt(score.getText());
        finalScoreManager.addScore(meteorsDodged);
        changeSceneToGameOverView();
    }

    //Requires: nothing
    //Modifies: this, gameOverViewScene, window
    //Effects: creates gameOverViewParent and gameOverViewScene
    private void changeSceneToGameOverView() throws IOException {
        Parent gameOverViewParent = FXMLLoader.load(getClass().getResource("/sample/gameover/GameOverView.fxml"));
        Scene gameOverViewScene = new Scene(gameOverViewParent);
        Stage window = (Stage)score.getScene().getWindow();
        window.setScene(gameOverViewScene);
        window.show();
    }
}
