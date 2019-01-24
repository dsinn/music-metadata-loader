package com.dsinn.musicmetadataloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirectoryNode extends HBox {
	public static final String BUTTON_TEXT = "Choose...";
	public static final String LABEL_TEXT = "Directory:";
	public static final String LAST_SELECTED_FILE = "./lastSelected.txt";
	public static final String NONE_SELECTED_TEXT = "None selected";

	protected Node button;
	protected DirectoryChooser directoryChooser;
	protected File directory;
	protected Node label;
	protected Labeled text;

	public DirectoryNode(Stage stage) {
		this.button = this.createButton(stage);
		this.directoryChooser = this.createDirectoryChooser();
		this.label = this.createLabel();
		this.text = this.createText();

		this.getChildren().add(this.label);
		this.getChildren().add(this.button);
		this.getChildren().add(this.text);

		this.setSpacing(10);
		this.setAlignment(Pos.CENTER_LEFT);
	}

	public File getDirectory() {
		return this.directory;
	}

	protected Node createButton(Stage stage) {
		Button button = new Button();
		button.setMinWidth(Button.USE_PREF_SIZE);
		button.setText(BUTTON_TEXT);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				File chosenDirectory = DirectoryNode.this.directoryChooser.showDialog(stage);
				if (chosenDirectory != null) {
					DirectoryNode.this.directory = chosenDirectory;
					DirectoryNode.this.text.setText(chosenDirectory.getAbsolutePath());
					DirectoryNode.this.directoryChooser.setInitialDirectory(chosenDirectory);
					try {
						Files.write(Paths.get(LAST_SELECTED_FILE), chosenDirectory.getAbsolutePath().getBytes());
					} catch (IOException e) {
					}
					System.out.println(chosenDirectory.getAbsolutePath());
				}
			}
		});
		return button;
	}

	protected DirectoryChooser createDirectoryChooser() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		try {
			directoryChooser
					.setInitialDirectory(new File(new String(Files.readAllBytes(Paths.get(LAST_SELECTED_FILE)))));
		} catch (IOException e) {
		}
		return directoryChooser;
	}

	protected Node createLabel() {
		Label label = new Label(LABEL_TEXT);
		label.setMinWidth(Label.USE_PREF_SIZE);
		return label;
	}

	protected Labeled createText() {
		return new Label(NONE_SELECTED_TEXT);
	}
}
