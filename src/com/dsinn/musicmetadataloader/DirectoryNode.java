package com.dsinn.musicmetadataloader;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirectoryNode extends HBox {
	public static final String BUTTON_TEXT = "Choose...";
	public static final String LABEL_TEXT = "Directory:";
	public static final String NONE_SELECTED_TEXT = "None selected";

	protected Button button;
	protected DirectoryChooser directoryChooser;
	protected File directory;
	protected Label label;
	protected Text text;

	public DirectoryNode(Stage stage) {
		this.button = this.createButton(stage);
		this.directoryChooser = this.createDirectoryChooser();
		this.label = this.createLabel();
		this.text = this.createText();

		this.getChildren().add(this.label);
		this.getChildren().add(this.text);
		this.getChildren().add(this.button);

		this.setSpacing(10);
		this.setAlignment(Pos.CENTER_LEFT);
	}

	public File getDirectory() {
		return this.directory;
	}

	protected Button createButton(Stage stage) {
		Button button = new Button();
		button.setText(BUTTON_TEXT);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				File chosenDirectory = DirectoryNode.this.directoryChooser.showDialog(stage);
				if (chosenDirectory != null) {
					DirectoryNode.this.directory = chosenDirectory;
					DirectoryNode.this.text.setText(chosenDirectory.getAbsolutePath());
				}
			}
		});
		return button;
	}

	protected DirectoryChooser createDirectoryChooser() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		return directoryChooser;
	}

	protected Label createLabel() {
		Label label = new Label(LABEL_TEXT);
		return label;
	}

	protected Text createText() {
		return new Text(NONE_SELECTED_TEXT);
	}
}
