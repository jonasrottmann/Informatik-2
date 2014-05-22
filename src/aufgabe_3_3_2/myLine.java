package aufgabe_3_3_2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Created by jonas on 20.05.14.
 */
public class myLine extends Line implements myShape {

    @Override
    public void draw(double xStart, double yStart, double xPos, double yPos) {
        //TODO positionen stimmen nicht
        this.setEndX(xPos);
        this.setEndY(yPos);
        this.setStrokeWidth(4);
    }

    @Override
    public void move(double xPos, double yPos) {
        this.relocate(xPos, yPos);
    }

    @Override
    public void bringToFront() {
        this.toFront();
    }

    @Override
    public void bringToBack() {
        this.toBack();
    }

    @Override
    public void setBorderColor(Color color) {
        this.setStroke(color);
    }

    @Override
    public void setBorderWidth(double width) {
        this.setStrokeWidth(width);
    }

    @Override
    public void setFillColor(Color color) {
        this.setStroke(color);
    }

    @Override
    public myShape clone() throws CloneNotSupportedException {
        myLine newline = new myLine();
        newline.setStartX(this.getStartX());
        newline.setStartY(this.getStartY());
        newline.setEndX(this.getEndX());
        newline.setEndY(this.getEndY());
        newline.setStrokeWidth(this.getStrokeWidth());
        newline.relocate(this.getBoundsInParent().getMinX(), this.getBoundsInParent().getMinY());
        return newline;
    }

    @Override
    public void setAlpha(double value) {
        this.setOpacity(value);
    }
}
