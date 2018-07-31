package com.svenluthi.fsae;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class TopMenu extends MenuBar
{
    private Menu menuFile              = new Menu("File");
    private Menu menuEdit              = new Menu("Edit");
    private Menu menuHelp              = new Menu("Help");
    private MenuItem fileOpen          = new MenuItem("Open File");
    private MenuItem fileSave          = new MenuItem("Save File");
    private MenuItem fileSaveAs        = new MenuItem("Save File...");
    private MenuItem exit              = new MenuItem("Exit");
    private MenuItem fromExpression    = new MenuItem("Generate FSA from Expression");
    private MenuItem nfsaToDfsa        = new MenuItem("Convert to DFSA");
    private MenuItem dfsaToNfsa        = new MenuItem("Convert to NFSA");
    private MenuItem showDocumentation = new MenuItem("Show Documentation");

    public TopMenu() {
        super();

        fileSave.setDisable(true);
        fileSaveAs.setDisable(true);
        menuEdit.setDisable(true);
        showDocumentation.setDisable(true);

        getMenus().addAll(menuFile, menuEdit, menuHelp);
        menuFile.getItems().addAll(fileOpen, fileSave, fileSaveAs, fromExpression, exit);
        menuEdit.getItems().addAll(nfsaToDfsa, dfsaToNfsa);
        menuHelp.getItems().addAll(showDocumentation);
    }

    public void setOnFileOpenEventHandler( EventHandler<ActionEvent> e ) {
        fileOpen.setOnAction(e);
    }

    public void setOnFileSaveEventHandler( EventHandler<ActionEvent> e ) {
        fileSave.setOnAction(e);
    }

    public void setOnFileSaveAsEventHandler( EventHandler<ActionEvent> e ) {
        fileSaveAs.setOnAction(e);
    }

    public void setOnExitEventHandler( EventHandler<ActionEvent> e ) {
        exit.setOnAction(e);
    }

    public void setOnFromExpressionEventHandler( EventHandler<ActionEvent> e ) {
        fromExpression.setOnAction(e);
    }

    public void setOnNfsaToDfsaEventHandler( EventHandler<ActionEvent> e ) {
        nfsaToDfsa.setOnAction(e);
    }

    public void setOnDfsaToNfsaEventHandler( EventHandler<ActionEvent> e ) {
        dfsaToNfsa.setOnAction(e);
    }

    public void setOnShowDocumentationEventHandler( EventHandler<ActionEvent> e ) {
        showDocumentation.setOnAction(e);
    }
}
