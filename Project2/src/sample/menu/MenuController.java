package sample.menu;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.game.gameController;

public class MenuController {

    //Requires: ActionEvent event
    //Modifies: this, actionViewScene, window
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

    //Requires: ActionEvent event
    //Modifies: this, window
    //Effects: closes the program
    public void exitProgram(ActionEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

}