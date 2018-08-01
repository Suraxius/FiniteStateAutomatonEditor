package dev.suraxius.fsae;

import java.util.Observer;
import java.util.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

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


class EditorPane extends TabPane implements Observer
{
    public EditorPane(Context.ContextHandler contextHandler) {
        super();
        //Add the Welcome Tab
        Tab startTab = new Tab("Welcome");
        StackPane startPage = new StackPane();
        startPage.setAlignment(Pos.CENTER);
        Image logo = new Image("file:graphics/logo.png");
        ImageView logoView = new ImageView(logo);
        startPage.getChildren().add(logoView);
        startTab.setContent(startPage);
        getTabs().add(startTab);
        //Start a new tab for each Context in the list:
        for (Context context : contextHandler.getAllContexts()) {
            getTabs().add(new Document(context));
        }
        //update contextHandler on switching of Tab
        getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> ov, Tab oldTab, Tab newTab) {
                System.out.println("Tab Selection changed");
                //contextHandler.setActiveContext(newTab.getContext());
            }
        });
    }

    //If the contextHandler gets updated outside the EditorPane module, update is called:
    @Override
    public void update(Observable obs, Object obj) {}

    class Document extends Tab {
        BorderPane layout = new BorderPane();
        Context context;

        public Document() {
            this(new Context());
        }

        public Document(Context context) {
            this.context = context;
            setText(context.getTitle());
            layout.setCenter(new VisualEditorPane());
            layout.setBottom(new EditorBottomPane());
            setContent(layout);
        }

        public Context getContext() { return context; }
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
