
package com.example.views;

import com.example.exceptions.ShareException;
import com.example.models.entities.ShareEntity;
import com.example.repositories.ShareRepository;
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

public class ShareDesktopView extends Application {

    private final TableView<ShareBinder> table = new TableView<>();
    private final ObservableList<ShareBinder> data = FXCollections.observableArrayList();
    private final ShareRepository repository = new ShareRepository();
    final HBox actBox = new HBox();
    final HBox navBox = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(new Group());
        stage.setTitle("Share Desktop View");
        stage.setWidth(500);
        stage.setHeight(650);

        final Label header = new Label("Share Records");
        header.setFont(new Font("Arial", 14));

        final Label message = new Label("Status: Form loaded.");
        header.setFont(new Font("Arial", 10));

        table.setEditable(true);

        TableColumn column0 = new TableColumn("messageId");
        column0.setCellValueFactory(
                new PropertyValueFactory<ShareBinder, Integer>("messageId"));
        column0.setEditable(false);
        TableColumn column1 = new TableColumn("receiverId");
        column1.setCellValueFactory(
                new PropertyValueFactory<ShareBinder, Integer>("receiverId"));
        column1.setEditable(true);
        column1.setOnEditCommit((EventHandler<CellEditEvent<ShareBinder, Integer>>) t -> {

                    // UPDATE COLUMN IN THE REPO


                    // UPDATE TABLE COLUMN

                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setReceiverId(t.getNewValue());
                }
        );

        table.setItems(data);
        table.getColumns().addAll(column0, column1);

        final TextField column1EditField = new TextField();
        column1EditField.setPromptText("receiverId");
        column1EditField.setMaxWidth(column1.getPrefWidth());

        final Button addButton = new Button("Add");
        addButton.setOnAction(onClick -> {

            // SAVE NEW RECORD TO DB
            try {
                int noOfNewRecords = repository.create(
                        new ShareEntity()
                                .withParsedReceiverId(column1EditField.getText())
                );

                if (noOfNewRecords > 0) {

            // CLEAR TABLE
            table.getItems().clear();

            // MAP DB RECORDS TO VIEW COMPONENTS
            List<ShareEntity> itemList = repository.read();

            for (ShareEntity item : itemList) {
                data.add(new ShareBinder(
                        item.getMessageId(), 
                        item.getReceiverId()
                ));
            }

            table.setItems(data);

            message.setText("New records from Share are created and to the list.");
                    column1EditField.clear();

                    message.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
                    message.setText("Share created!");

                } else {
                    message.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                    message.setText("ERROR: Share could NOT be created!");
                }
            } catch (ShareException shareException) {
                message.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                message.setText(shareException.getMessage());
            }

        });

        final Button viewButton = new Button("View");
        viewButton.setOnAction(onClick -> {

            // CLEAR TABLE
            table.getItems().clear();

            // MAP DB RECORDS TO VIEW COMPONENTS
            List<ShareEntity> itemList = repository.read();

            for (ShareEntity item : itemList) {
                data.add(new ShareBinder(
                        item.getMessageId(), 
                        item.getReceiverId()
                ));
            }

            table.setItems(data);

            message.setText("Share records are refreshed");

        });

        final Button backButton = new Button("Back");
        backButton.setOnAction(onClick -> {
            scene.getWindow().hide();
            new MainMenuDesktopView().start(stage);
        });

        navBox.getChildren().addAll(backButton);
        navBox.setSpacing(3);

        actBox.getChildren().addAll(column1EditField, addButton, viewButton);
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

