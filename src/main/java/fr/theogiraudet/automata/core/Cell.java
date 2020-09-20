package fr.theogiraudet.automata.core;

import com.sun.javafx.scene.DirtyBits;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Parent {

    private final Rectangle background;
    private final BooleanProperty leftClick;


    public Cell(BooleanProperty leftClick) {
        background = new Rectangle();
        this.leftClick = leftClick;

        background.setStroke(Color.valueOf("#414141"));
        background.setFill(Color.valueOf("#212121"));
        background.heightProperty().bind(height);
        background.widthProperty().bind(width);

        setOnMouseEntered(e -> { if(leftClick.get()) this.paint(e); });

        getChildren().add(background);
    }

    private void paint(MouseEvent event) {
            background.setFill(Color.valueOf("#f28028"));
    }

    private final DoubleProperty width = new DoublePropertyBase() {

        @Override
        public void invalidated() {
            impl_markDirty(DirtyBits.NODE_GEOMETRY);
            impl_geomChanged();
        }

        @Override
        public Object getBean() {
            return Cell.this;
        }

        @Override
        public String getName() {
            return "width";
        }
    };

    public final void setWidth(double value) {
        width.set(value);
    }

    public final double getWidth() {
        return width.get();
    }

    public final DoubleProperty widthProperty() {
        return width;
    }

    private final DoubleProperty height = new DoublePropertyBase() {

        @Override
        public void invalidated() {
            impl_markDirty(DirtyBits.NODE_GEOMETRY);
            impl_geomChanged();
        }

        @Override
        public Object getBean() {
            return Cell.this;
        }

        @Override
        public String getName() {
            return "height";
        }
    };


    public final void setHeight(double value) {
        height.set(value);
    }

    public final double getHeight() {
        return height.get();
    }

    public final DoubleProperty heightProperty() {
        return height;
    }


}
