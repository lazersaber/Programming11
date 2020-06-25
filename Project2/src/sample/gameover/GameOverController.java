package sample.gameover;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import sample.game.gameController;

import java.io.IOException;
import java.util.ArrayList;

public class GameOverController {
    public ListView scoreList;

    //Requires: nothing
    //Modifies: this, scoreList
    //Effects: The scoreList is assigned the score values from the file to display
    public void initialize() throws IOException {
        scoreList.getItems().clear();
        FinalScoreManager finalScoreManager = new FinalScoreManager();
        ArrayList<String> scores = finalScoreManager.getAllScores();
        for (String score : scores){
            scoreList.getItems().add(score);
        }
    }

    //Requires: ActionEvent event
    //Modifies: this, menuViewScene, window
    //Effects: menuViewParent, menuViewScene, and window are created
    public void changeSceneToMenuView(ActionEvent event) throws IOException{
        Parent menuViewParent = FXMLLoader.load(getClass().getResource("/sample/menu/menuInterface.fxml"));
        Scene menuViewScene = new Scene(menuViewParent);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(menuViewScene);
        window.show();
    }

    //Requires: ActionEvent event
    //Modifies: this, actionViewScene and window
    //Effects: gameViewParent, gameViewScene, and window are created
    public void changeSceneToGameView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/game/gameView.fxml"));
        Parent gameViewParent = loader.load();
        gameController controller = loader.getController();
        Scene gameViewScene = new Scene(gameViewParent);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setScene(gameViewScene);
        window.show();
        controller.startPlay();
    }

}
