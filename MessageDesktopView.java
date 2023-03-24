
package com.example.views;

import com.example.exceptions.MessageException;
import com.example.models.entities.MessageEntity;
import com.example.repositories.MessageRepository;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;
import com.example.models.binders.*;

public class MessageDesktopView extends Application {

    private final TableView<MessageBinder> table = new TableView<>();
    private final ObservableList<MessageBinder> data = FXCollections.observableArrayList();
    private final MessageRepository repository = new MessageRepository();
    final HBox actBox = new HBox();
    final HBox navBox = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(new Group());
        stage.setTitle("Message Desktop View");
        stage.setWidth(500);
        stage.setHeight(650);

        final Label header = new Label("Message Records");
        header.setFont(new Font("Arial", 14));

        final Label message = new Label("Status: Form loaded.");
        header.setFont(new Font("Arial", 10));

        table.setEditable(true);

        TableColumn column0 = new TableColumn("id");
        column0.setCellValueFactory(
                new PropertyValueFactory<MessageBinder, Integer>("id"));
        column0.setEditable(false);
        TableColumn column1 = new TableColumn("subject");
        column1.setCellValueFactory(
                new PropertyValueFactory<MessageBinder, String>("subject"));
        column1.setEditable(true);
        column1.setOnEditCommit((EventHandler<CellEditEvent<MessageBinder, String>>) t -> {

                    // UPDATE COLUMN IN THE REPO


                    // UPDATE TABLE COLUMN

                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setSubject(t.getNewValue());
                }
        );
        TableColumn column2 = new TableColumn("body");
        column2.setCellValueFactory(
                new PropertyValueFactory<MessageBinder, String>("body"));
        column2.setEditable(true);
        column2.setOnEditCommit((EventHandler<CellEditEvent<MessageBinder, String>>) t -> {

                    // UPDATE COLUMN IN THE REPO


                    // UPDATE TABLE COLUMN

                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setBody(t.getNewValue());
                }
        );
        TableColumn column3 = new TableColumn("senderId");
        column3.setCellValueFactory(
                new PropertyValueFactory<MessageBinder, Integer>("senderId"));
        column3.setEditable(true);
        column3.setOnEditCommit((EventHandler<CellEditEvent<MessageBinder, Integer>>) t -> {

                    // UPDATE COLUMN IN THE REPO


                    // UPDATE TABLE COLUMN

                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setSenderId(t.getNewValue());
                }
        );

        table.setItems(data);
        table.getColumns().addAll(column0, column1, column2, column3);

        final TextField column1EditField = new TextField();
        column1EditField.setPromptText("subject");
        column1EditField.setMaxWidth(column1.getPrefWidth());
        final TextField column2EditField = new TextField();
        column2EditField.setPromptText("body");
        column2EditField.setMaxWidth(column2.getPrefWidth());
        final TextField column3EditField = new TextField();
        column3EditField.setPromptText("senderId");
        column3EditField.setMaxWidth(column3.getPrefWidth());

        final Button addButton = new Button("Add");
        addButton.setOnAction(onClick -> {

            // SAVE NEW RECORD TO DB
            try {
                int noOfNewRecords = repository.create(
                        new MessageEntity()
                                .withParsedSubject(column1EditField.getText())
                                .withParsedBody(column2EditField.getText())
                                .withParsedSenderId(column3EditField.getText())
                );

                if (noOfNewRecords > 0) {

            // CLEAR TABLE
            table.getItems().clear();

            // MAP DB RECORDS TO VIEW COMPONENTS
            List<MessageEntity> itemList = repository.read();

            for (MessageEntity item : itemList) {
                data.add(new MessageBinder(
                        item.getId(), 
                        item.getSubject(), 
                        item.getBody(), 
                        item.getSenderId()
                ));
            }

            table.setItems(data);

            message.setText("New records from Message are created and to the list.");
                    column1EditField.clear();
                    column2EditField.clear();
                    column3EditField.clear();

                    message.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
                    message.setText("Message created!");

                } else {
                    message.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                    message.setText("ERROR: Message could NOT be created!");
                }
            } catch (MessageException messageException) {
                message.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                message.setText(messageException.getMessage());
            }

        });

        final Button viewButton = new Button("View");
        viewButton.setOnAction(onClick -> {

            // CLEAR TABLE
            table.getItems().clear();

            // MAP DB RECORDS TO VIEW COMPONENTS
            List<MessageEntity> itemList = repository.read();

            for (MessageEntity item : itemList) {
                data.add(new MessageBinder(
                        item.getId(), 
                        item.getSubject(), 
                        item.getBody(), 
                        item.getSenderId()
                ));
            }

            table.setItems(data);

            message.setText("Message records are refreshed");

        });

        final Button backButton = new Button("Back");
        backButton.setOnAction(onClick -> {
            scene.getWindow().hide();
            new MainMenuDesktopView().start(stage);
        });

        navBox.getChildren().addAll(backButton);
        navBox.setSpacing(3);

        actBox.getChildren().addAll(column1EditField,column2EditField,column3EditField, addButton, viewButton);
        actBox.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(header, table, actBox, navBox, message);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);

        stage.show();
    }

}

