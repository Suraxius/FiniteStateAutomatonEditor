package dev.suraxius.fsae;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application
{
    private Context.ContextHandler contextHandler = new Context.ContextHandler();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.getIcons().add(new Image("file:graphics/icon.png"));
        stage.setTitle( "Finite State Automaton Editor" );

        //Add test contexts:
        contextHandler.addContext(new Context());
        contextHandler.addContext(new Context());

        //Add UI Elements:
        BorderPane root       = new BorderPane();
        TopMenu topMenu       = new TopMenu(contextHandler);
        EditorPane editorPane = new EditorPane(contextHandler);
        root.setTop(topMenu);
        root.setCenter(editorPane);
        

        topMenu.setOnFileOpenEventHandler(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.out.println("File Opened!");
            }
        });
        
        topMenu.setOnExitEventHandler(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });

        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }

    
}
