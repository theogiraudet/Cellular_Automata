package fr.theogiraudet.automata;

import fr.theogiraudet.automata.core.Cell;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public GridPane GRID_PANE;

    @FXML
    public BorderPane ROOT;

    private SimpleBooleanProperty isLeftClick = new SimpleBooleanProperty(this, "isLeftClick", false);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final int NB_CELL = 50;

        GRID_PANE.setHgap(-1);
        GRID_PANE.setVgap(-1);
        GRID_PANE.setAlignment(Pos.CENTER);

        for(int i = 0; i < NB_CELL; i++)
            for(int j = 0; j < NB_CELL; j++) {
                Cell rec = new Cell(isLeftClick);
                rec.widthProperty().bind(ROOT.heightProperty().divide(NB_CELL).subtract(1));
                rec.heightProperty().bind(ROOT.heightProperty().divide(NB_CELL).subtract(1));
                GRID_PANE.add(rec, i, j);
            }

        GRID_PANE.setOnMousePressed( e -> isLeftClick.set(e.getButton().equals(MouseButton.PRIMARY) && !isLeftClick.get()));
        //GRID_PANE.setOnMouseReleased( e -> isLeftClick.set(false));

    }
}
