package com.dsinn.musicmetadataloader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static final String RUN_TEXT = "Check metadata";

	public static void main(String[] args) {
		launch(args);
	}

    @Override
    public void start(Stage stage) {
        this.setUpStage(stage);
    }

    public void validate() {
        System.out.println("@TODO");
    }

    protected Node createDirectoryNode(Stage stage) {
        return new DirectoryNode(stage);
    }

    protected Pane createRootPane(Stage stage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().add(this.createDirectoryNode(stage));
        root.getChildren().add(this.createURLNode());
        root.getChildren().add(this.createRunNode());
        return root;
    }

    protected Node createRunNode() {
        Button button = new Button();
        button.setText(RUN_TEXT);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.this.validate();
            }
        });
        return button;
    }

    protected Node createURLNode() {
        return new URLNode();
    }

    protected Image getIcon() {
        return new Image(getClass().getResourceAsStream("icon.png"));
    }

    protected void setUpStage(Stage stage) {
        stage.setTitle("Music Metadata Loader");
        stage.setScene(new Scene(this.createRootPane(stage)));
        stage.getIcons().add(this.getIcon());
        stage.show();
    }
}
