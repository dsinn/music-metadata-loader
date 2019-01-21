package com.dsinn.musicmetadataloader;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class URLNode extends HBox {
	public URLNode() {
		this.getChildren().add(this.createLabel());
		this.getChildren().add(this.createTextField());

		this.setSpacing(10);
	}

	protected Label createLabel() {
		return new Label("Wiki page URL:");
	}

	protected TextField createTextField() {
		return new TextField();
	}
}
