package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class Controller {
    public TextField friendAge;
    public TextField friendAnimal;
    public TextField friendName;
    public TextField friendColour;

    public TextField groupName;
    public ListView<String> groupList;

    public ListView<String> allFriends;
    public Label selectedGroupName;

    List<Group> groups = null;

    FileManager fileManager = new FileManager();

    public void createFriend(ActionEvent actionEvent) throws IOException {
        String groupName = selectedGroupName.getText();
        Group group = fileManager.findGroupByName(groupName);
        if (group == null) {
            return;
        }

        String name = friendName.getText();
        int age = Integer.parseInt(friendAge.getText());
        String favouriteAnimal = friendAnimal.getText();
        String favouriteColour = friendColour.getText();
        Friend friend = new Friend(name, age, favouriteAnimal, favouriteColour);
        fileManager.putFriendInGroup(friend, group);
        friendName.clear();
        friendAge.clear();
        friendAnimal.clear();
        friendColour.clear();
    }

    public void loadFriends(ActionEvent actionsEvent)throws IOException {
        allFriends.getItems().clear();
        String groupName = selectedGroupName.getText();
        Group group = fileManager.findGroupByName(groupName);
        if (group == null) {
            return;
        }
        List<Friend> friends = fileManager.getFriends(group);
        for (Friend friend : friends) {
            allFriends.getItems().add(friend.toString());
        }
    }

    public void addNewGroup(ActionEvent actionEvent) throws IOException {
        String groupNameText = groupName.getText();
        if (groupNameText != null && !groupNameText.isEmpty()) {
            Group group = new Group(
                    groupNameText,
                    "group." + groupNameText.replaceAll(" ", "") + ".txt");

            fileManager.addGroupInTxt(group);
            groupName.clear();
            loadAllGroups(actionEvent);
        }
    }

    public void selectGroup(ActionEvent actionEvent) {
        String selectedName = groupList.getSelectionModel().getSelectedItem();
        selectedGroupName.setText(selectedName);
    }

    public void loadAllGroups(ActionEvent actionEvent) throws IOException {
        groupList.getItems().clear();
        groups = fileManager.loadGroups();
        List<String> names = Group.convertGroupsToNames(groups);
        ObservableList<String> observableNames = FXCollections.observableArrayList(names);
        groupList.setItems(observableNames);
    }
}

