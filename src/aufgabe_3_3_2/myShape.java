package aufgabe_3_3_2;

import javafx.scene.shape.Shape;

/**
 * Created by jonas on 20.05.14.
 */
public interface myShape {

    /**
     * Gibt die Form zurück.
     * @return
     */
    Shape get();

    /**
     * Zieht die Form auf.
     * @param xStart
     * @param yStart
     * @param xPos
     * @param yPos
     */
    void workCreate(double xStart, double yStart, double xPos, double yPos);

}
