package com.dsinn.musicmetadataloader;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;

public class URLNode extends HBox {
    public URLNode() {
        this.getChildren().add(this.createLabel());
        this.getChildren().add(this.createTextField());

        this.setSpacing(10);
    }

    protected Node createLabel() {
        return new Label("Album wiki page URL:");
    }

    protected TextInputControl createTextField() {
        TextField textField = new TextField();
        textField.setPrefWidth(400);
        return textField;
    }
}
