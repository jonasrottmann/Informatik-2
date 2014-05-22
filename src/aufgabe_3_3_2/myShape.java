package aufgabe_3_3_2;

import javafx.scene.paint.Color;

/**
 * Created by jonas on 22.05.14.
 */
public interface myShape extends myNode {
    /**
     * Das aufziehen der Form
     * @param xStart
     * @param yStart
     * @param xPos
     * @param yPos
     */
    void draw(double xStart, double yStart, double xPos, double yPos);

    /**
     * Linienfarbe festlegen
     * @param color
     */
    void setBorderColor(Color color);

    /**
     * Linienbreite festlegen
     * @param width
     */
    void setBorderWidth(double width);

    /**
     * Füllfarbe festlegen
     * @param color
     */
    void setFillColor(Color color);

}
