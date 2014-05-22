package aufgabe_3_3_2;

import javafx.scene.Group;
import javafx.scene.Node;

/**
 * Created by jonas on 22.05.14.
 */
public class myGroup extends Group implements myNode {
    @Override
    public myNode clone() throws CloneNotSupportedException {
        myGroup newgroup = new myGroup();

        for (Node item : this.getChildren()) {
            if (!(item instanceof myGroup)) {
                try {
                    myNode newitem = ((myNode) item).clone();
                    newgroup.getChildren().add((Node) newitem);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            } else {
                myGroup newgroup2 = (myGroup) ((myGroup) item).clone();
                newgroup.getChildren().add(newgroup2);
            }
        }
        return newgroup;
    }

    @Override
    public void move(double xPos, double yPos) {
        //Todo gruppe spingt beim zweiten verschieben
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
