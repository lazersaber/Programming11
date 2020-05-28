package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    public TextField friendAge;
    public TextField friendAnimal;
    public TextField friendName;
    public TextField friendColour;
    public Button btnCreate;

    public TextField deleteFriendName;
    public Button btnDelete;

    public TextField namePrintFriend;
    public TextField displayFriend;
    public Button btnPrintFriend;

    public TextArea listAll;
    public Button btnListAll;

    ArrayList<Friend> friends = new ArrayList<>();

    public void createFriend(ActionEvent actionEvent) {
        String name = friendName.getText();
        int age = Integer.parseInt(friendAge.getText());
        String favouriteAnimal = friendAnimal.getText();
        String favouriteColour = friendColour.getText();
        Friend friend = new Friend(name, age, favouriteAnimal, favouriteColour);
        friends.add(friend);
        friendName.setText("");
        friendAge.setText("");
        friendAnimal.setText("");
        friendColour.setText("");
        deleteFriendName.setDisable(false);
        btnDelete.setDisable(false);
        namePrintFriend.setDisable(false);
        displayFriend.setDisable(false);
        btnPrintFriend.setDisable(false);
        listAll.setDisable(false);
        btnListAll.setDisable(false);
    }

    public void deleteFriend(ActionEvent actionEvent) {
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).getName().equals(deleteFriendName.getText())){
                friends.remove(i);
                break;
            }
        }
        deleteFriendName.setText("");
        //deletes a friend
    }

    public void listFriends(ActionEvent actionEvent) {
        String friendStorage = "";
        for (int i = 0; i < friends.size(); i++){
            if (i > 0){
                friendStorage += "\n";
            }
            friendStorage += friends.get(i).toString();
        }
        listAll.setText(friendStorage);
        //lists the friendStorage
        //prints out each friend and their properties
    }

    public void printFriend(ActionEvent actionEvent) {
        for (int i = 0; i < friends.size(); i++){
            if (friends.get(i).getName().equals(namePrintFriend.getText())){
                displayFriend.setText(friends.get(i).toString());
                break;
            }
        }
        namePrintFriend.setText("");
        //prints out a specific friend and their properties
    }
}
