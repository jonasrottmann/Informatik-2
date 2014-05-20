package aufgabe_3_3_2;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * Created by jonas on 20.05.14.
 */
public class myRectangle extends Rectangle implements myShape {

    private Rectangle rect;

    public myRectangle() {
        this.rect = new Rectangle(0, 0, Color.RED);
    }

    @Override
    public Shape get() {
        return rect;
    }

    @Override
    public void workCreate(double xStart, double yStart, double xPos, double yPos) {
        if (yStart - yPos > 0 && xStart - xPos > 0) {
            //nach links oben ziehen
            rect.setHeight(yStart - yPos);
            rect.setWidth(xStart - xPos);
            rect.relocate(xStart - rect.getWidth(), yStart - rect.getHeight());
        }
        else if (yStart - yPos > 0 && xStart - xPos < 0) {
            //nach rechts oben ziehen
            rect.setHeight(yStart - yPos);
            rect.setWidth(xPos - xStart);
            rect.relocate(xStart, yStart - rect.getHeight());
        }
        else if (yStart - yPos < 0 && xStart - xPos < 0) {
            //nach rechts unten ziehen
            rect.setHeight(yPos - yStart);
            rect.setWidth(xPos - xStart);
        }
        else if (yStart - yPos < 0 && xStart - xPos > 0) {
            //nach links unten ziehen
            rect.setHeight(yPos - yStart);
            rect.setWidth(xStart - xPos);
            rect.relocate(xStart - rect.getWidth(), yStart);
        }
    }
}
