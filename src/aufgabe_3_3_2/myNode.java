package aufgabe_3_3_2;

/**
 * Created by jonas on 22.05.14.
 */
public interface myNode extends Cloneable {
    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    myNode clone() throws CloneNotSupportedException;

    /**
     * Node bewegen.
     * @param xPos
     * @param yPos
     */
    void move(double xPos, double yPos);


    void bringToFront();
    void bringToBack();
    void setAlpha(double value);
}
