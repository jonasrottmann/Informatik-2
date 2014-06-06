package aufgabe_3_3_2_paint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Created by jonas on 20.05.14.
 */
public class myEllipse extends Ellipse implements myShape {

    @Override
    public void draw(double xStart, double yStart, double xPos, double yPos) {
        if(yStart - yPos > 0 && xStart - xPos > 0) {
            //nach links oben ziehen
            this.setRadiusY((yStart - yPos) / 2);
            this.setRadiusX((xStart - xPos) / 2);
            this.relocate(xStart - 2 * (this.getRadiusX()), yStart - 2 * (this.getRadiusY()));
        }
        else if (yStart - yPos > 0 && xStart - xPos < 0) {
            //nach rechts oben ziehen
            this.setRadiusY((yStart - yPos) / 2);
            this.setRadiusX((xPos - xStart) / 2);
            this.relocate(xStart, yStart - 2 * (this.getRadiusY()));
        }
        else if (yStart - yPos < 0 && xStart - xPos < 0) {
            //nach rechts unten ziehen
            this.setRadiusY((yPos - yStart) / 2);
            this.setRadiusX((xPos - xStart) / 2);
            this.relocate(xStart, yStart);
        }
        else if (yStart - yPos < 0 && xStart - xPos > 0) {
            //nach links unten ziehen
            this.setRadiusY((yPos - yStart) / 2);
            this.setRadiusX((xStart - xPos) / 2);
            this.relocate(xStart - 2 * (this.getRadiusX()), yStart);
        }
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
        this.setFill(color);
    }

    @Override
    public myShape clone() throws CloneNotSupportedException {
        myEllipse newellipse = new myEllipse();
        newellipse.setRadiusX(this.getRadiusX());
        newellipse.setRadiusY(this.getRadiusY());
        newellipse.relocate(this.getBoundsInParent().getMinX(), this.getBoundsInParent().getMinY());
        newellipse.setFill(this.getFill());
        return newellipse;
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
    public void setAlpha(double value) {
        this.setOpacity(value);
    }
}
