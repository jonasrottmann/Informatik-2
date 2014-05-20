package aufgabe_3_3_2;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

/**
 * Created by jonas on 20.05.14.
 */
public class myEllipse implements myShape {

    private Ellipse ellipse;

    public myEllipse() {
        this.ellipse = new Ellipse(0, 0);
    }

    @Override
    public Shape get() {
        return ellipse;
    }

    @Override
    public void workCreate(double xStart, double yStart, double xPos, double yPos) {
        if(yStart - yPos > 0 && xStart - xPos > 0) {
            //nach links oben ziehen
            ellipse.setRadiusY((yStart - yPos) / 2);
            ellipse.setRadiusX((xStart - xPos) / 2);
            ellipse.relocate(xStart - 2 * (ellipse.getRadiusX()), yStart - 2 * (ellipse.getRadiusY()));
        }
        else if (yStart - yPos > 0 && xStart - xPos < 0) {
            //nach rechts oben ziehen
            ellipse.setRadiusY((yStart - yPos) / 2);
            ellipse.setRadiusX((xPos - xStart) / 2);
            ellipse.relocate(xStart, yStart - 2 * (ellipse.getRadiusY()));
        }
        else if (yStart - yPos < 0 && xStart - xPos < 0) {
            //nach rechts unten ziehen
            ellipse.setRadiusY((yPos - yStart) / 2);
            ellipse.setRadiusX((xPos - xStart) / 2);
            ellipse.relocate(xStart, yStart);
        }
        else if (yStart - yPos < 0 && xStart - xPos > 0) {
            //nach links unten ziehen
            ellipse.setRadiusY((yPos - yStart) / 2);
            ellipse.setRadiusX((xStart - xPos) / 2);
            ellipse.relocate(xStart - 2 * (ellipse.getRadiusX()), yStart);
        }
    }
}
