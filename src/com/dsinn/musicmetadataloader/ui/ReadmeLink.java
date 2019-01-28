package com.dsinn.musicmetadataloader.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.HBox;

public class ReadmeLink extends HBox {
    public static final String LINK_DESTINATION = "https://github.com/dsinn/music-metadata-loader#user-content-music-metadata-loader";
    public static final String LINK_TEXT = "Readme";

    private Application application;
    private Node link;

    public ReadmeLink(Application application) {
        this.application = application;
        this.link = this.createLink();

        this.getChildren().add(this.link);

        this.setAlignment(Pos.CENTER_RIGHT);
    }

    protected Node createLink() {
        Hyperlink link = new Hyperlink(LINK_TEXT);
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                ReadmeLink.this.application.getHostServices().showDocument(LINK_DESTINATION);
            }
        });
        return link;
    }
}
