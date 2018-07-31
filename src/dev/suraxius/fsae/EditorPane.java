package dev.suraxius.fsae;

import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


class EditorPane extends TabPane
{
    public EditorPane() {
        super();
        Tab startTab = new Tab("Welcome");
        StackPane startPage = new StackPane();
        startPage.setAlignment(Pos.CENTER);
        Image logo = new Image("file:graphics/logo.png");
        ImageView logoView = new ImageView(logo);
        startPage.getChildren().add(logoView);
        startTab.setContent(startPage);

        getTabs().addAll(startTab, new Document());
    }

    class Document extends Tab {
        BorderPane layout = new BorderPane();

        public Document() {
            setText("Untitled Document");
            layout.setCenter(new VisualEditorPane());
            layout.setBottom(new EditorBottomPane());
            setContent(layout);
        }
    }

    class EditorBottomPane extends VBox
    {
        private TextArea regularLanguageExpressionDisplay = new TextArea();

        public EditorBottomPane() {
            super();
            regularLanguageExpressionDisplay.setPrefRowCount(1);
            regularLanguageExpressionDisplay.setEditable(false);
            regularLanguageExpressionDisplay.setText("Regular Expression Display");
            
            getChildren().add(regularLanguageExpressionDisplay);
        }
    }
}
