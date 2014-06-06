package aufgabe_3_3_2_paint;

import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Created by jonas on 22.05.14.
 */
public class myGroup extends Group implements myNode {

    private double xStart;

    public double getyStart() {
        return yStart;
    }

    public double getxStart() {
        return xStart;
    }

    private double yStart;

    @Override
    public myGroup clone() throws CloneNotSupportedException {

        myGroup newgroup = new myGroup();

        for (Node item : this.getChildren()) {
            if (item instanceof myGroup) {
                myGroup newgroup2 = ((myGroup) item).clone();
                newgroup.getChildren().add(newgroup2);
            } else {
                try {
                    myNode newitem = ((myNode) item).clone();
                    newgroup.getChildren().add((Node) newitem);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        newgroup.relocate(this.getBoundsInParent().getMinX(), this.getBoundsInParent().getMinY());
        return newgroup;
    }

    public void setStart(double xStart, double yStart) {
        this.xStart = xStart;
        this.yStart = yStart;
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
