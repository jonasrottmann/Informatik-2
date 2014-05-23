package aufgabe_3_3_2;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by jonas on 20.05.14.
 */
public class myRectangle extends Rectangle implements myShape {

    @Override
    public void draw(double xStart, double yStart, double xPos, double yPos) {
        if (yStart - yPos > 0 && xStart - xPos > 0) {
            //nach links oben ziehen
            this.setHeight(yStart - yPos);
            this.setWidth(xStart - xPos);
            this.relocate(xStart - this.getWidth(), yStart - this.getHeight());
        }
        else if (yStart - yPos > 0 && xStart - xPos < 0) {
            //nach rechts oben ziehen
            this.setHeight(yStart - yPos);
            this.setWidth(xPos - xStart);
            this.relocate(xStart, yStart - this.getHeight());
        }
        else if (yStart - yPos < 0 && xStart - xPos < 0) {
            //nach rechts unten ziehen
            this.setHeight(yPos - yStart);
            this.setWidth(xPos - xStart);
            this.relocate(xStart, yStart);
        }
        else if (yStart - yPos < 0 && xStart - xPos > 0) {
            //nach links unten ziehen
            this.setHeight(yPos - yStart);
            this.setWidth(xStart - xPos);
            this.relocate(xStart - this.getWidth(), yStart);
        }
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
        this.setFill(color);
    }

    @Override
    public myShape clone() throws CloneNotSupportedException {
        myRectangle newrect = new myRectangle();
        newrect.setWidth(this.getWidth());
        newrect.setHeight(this.getHeight());
        newrect.relocate(this.getBoundsInParent().getMinX(), this.getBoundsInParent().getMinY());
        newrect.setFill(this.getFill());
        return newrect;
    }

    @Override
    public void setAlpha(double value) {
        this.setOpacity(value);
    }
}
