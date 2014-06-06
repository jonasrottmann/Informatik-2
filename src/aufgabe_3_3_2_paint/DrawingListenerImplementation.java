package aufgabe_3_3_2_paint;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.*;

/**
 * Created by jonas on 04.05.14.
 */
public class DrawingListenerImplementation implements DrawingListener {
    private double xStart, yStart;
    private myShape figure;
    private boolean disableClick;
    private ArrayList<myNode> selected = new ArrayList<>();
    private ArrayList<myNode> clipboard = new ArrayList<>();
    private DrawPane canvas;
    private double moveStartOffsetX, moveStartOffsetY;
    private double merkeX, merkeY;

    public DrawingListenerImplementation(DrawPane canvas) {
        this.canvas = canvas;
    }

    @Override
    public void startCreateFigure(String figureType, double xPos, double yPos) {
        xStart = xPos;
        yStart = yPos;

        switch (figureType) {
            case "ellipse":
                figure = new myEllipse();
                break;
            case "rectangle":
                figure = new myRectangle();
                break;
            case "line":
                figure = new myLine(xStart, yStart, xStart, yStart);
                break;
        }
        //Random Color
        Random rand = new Random();
        double r = rand.nextDouble();
        double g = rand.nextDouble();
        double b = rand.nextDouble();
        // TODO nullpointerex bei leeren figuren
        figure.setFillColor(new Color(r, g, b, 1));

        canvas.getChildren().add((Shape) figure);
    }

    @Override
    public void startMoveFigure(Node node, double xPos, double yPos) {
        while (node.getParent().getClass() == myGroup.class) {
            node = node.getParent();
        }
        moveStartOffsetX = xPos - node.getBoundsInParent().getMinX();
        moveStartOffsetY = yPos - node.getBoundsInParent().getMinY();

        merkeX = node.getBoundsInParent().getMinX();
        merkeY = node.getBoundsInParent().getMinY();
    }

    @Override
    public void workCreateFigure(double xPos, double yPos) {
        figure.draw(xStart, yStart, xPos, yPos);
    }

    @Override
    public void workMoveFigure(Node node, double xPos, double yPos) {
        if (node instanceof DrawPane) return; //Klicke auf Zeichenfläche nicht beachten

        while (node.getParent().getClass() == myGroup.class) {
            node = node.getParent();
        }
        ((myNode) node).move(xPos - moveStartOffsetX, yPos - moveStartOffsetY);
    }

    @Override
    public void endCreateFigure(double xPos, double yPos) {
        FadeTransition fade = new FadeTransition(Duration.millis(500), (Shape) figure);
        fade.setFromValue(1.0);
        fade.setToValue(0.1);
        fade.setCycleCount(2);
        fade.setAutoReverse(true);
        fade.play();
    }

    @Override
    public void endMoveFigure(Node node, double xPos, double yPos) {
        while (node.getParent().getClass() == myGroup.class) {
            node = node.getParent();
        }
        if (node instanceof DrawPane) return; //Drawpane nicht animieren

        if (!disableClick &&
                node.getBoundsInParent().getMinX() != merkeX &&
                node.getBoundsInParent().getMinY() != merkeY) {
            RotateTransition rotate = new RotateTransition(Duration.millis(500), node);
            rotate.setByAngle(360);
            rotate.setCycleCount(1);
            rotate.setAutoReverse(false);
            rotate.setOnFinished(event -> disableClick = false);

            rotate.play();

            disableClick = true;
        }
    }

    @Override
    public void selectFigure(Node node, double xPos, double yPos, boolean shiftPressed) {

        if (node instanceof DrawPane) {
            if (shiftPressed) return;
            clearSelected();
        }

        //Parent Gruppe holen
        while (node.getParent().getClass() == myGroup.class) {
            node = node.getParent();
        }
        //auswahl treffen
        if (shiftPressed) {
            node.setOpacity(0.5);
            selected.add((myNode) node);
        } else {
            clearSelected();
        }
    }

    @Override
    public void rotate(Node node, double angle) {
    }

    @Override
    public void translate(Node node, double deltaX, double deltaY) {

    }

    @Override
    public void zoom(Node node, double zoomFactor) {

    }

    @Override
    public void deleteFigures() {
        for (myNode aSelected : selected) {
            canvas.getChildren().remove(aSelected);
        }
        clearSelected();
    }

    @Override
    public void copyFigures() {
        clipboard.clear();


        for (myNode item : selected) {
            clipboard.add(item);
        }
        clearSelected();
    }

    @Override
    public void pasteFigures() {
        for (myNode item : clipboard) {
            try {
                myNode newitem = item.clone();
                canvas.getChildren().add((Node) newitem);
            }
            catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            finally {
                clearSelected();
            }
        }
    }

    @Override
    public void moveSelectedFiguresToTop() {
        for (myNode aSelected : selected) {
            aSelected.bringToFront();
        }
    }

    @Override
    public void moveSelectedFiguresToBottom() {
        for (myNode aSelected : selected) {
            aSelected.bringToBack();
        }
    }

    @Override
    public void moveSelectedFiguresDown() {
        ArrayList<Node> tmp = new ArrayList<>();

        for(Node child : canvas.getChildren()) {
            tmp.add(child);
        }
        for(myNode s : selected) {
            try {
                Collections.swap(tmp, tmp.indexOf(s), tmp.indexOf(s) - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Auswahl ist schon ganz unten.");
            }
        }
        canvas.getChildren().clear();
        canvas.getChildren().addAll(tmp);
    }

    @Override
    public void moveSelectedFiguresUp() {
        ArrayList<Node> tmp = new ArrayList<>();

        for(Node child : canvas.getChildren()) {
            tmp.add(child);
        }
        for(myNode s : selected) {
            // if indexof-1 == size return
            try {
                Collections.swap(tmp, tmp.indexOf(s), (tmp.indexOf(s) + 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Auswahl ist schon ganz oben.");
            }
        }
        canvas.getChildren().clear();
        canvas.getChildren().addAll(tmp);
    }

    @Override
    public void groupFigures() {
        myGroup group = new myGroup();
        for (myNode aSelected : selected) {
            if (aSelected != null) {
                group.getChildren().add((Node) aSelected);
            }
        }
        canvas.getChildren().add(group);

        group.setStart(group.getBoundsInParent().getMinX(), group.getBoundsInParent().getMinY());

        clearSelected();
    }

    @Override
    public void ungroupFigures() throws CloneNotSupportedException {
        myGroup grp = (myGroup) selected.get(0);
        double newX, newY;
        double grpMinX = grp.getBoundsInParent().getMinX();
        double grpMinY = grp.getBoundsInParent().getMinY();

        ArrayList<Node> tmp = new ArrayList<>();
        for (Node item : grp.getChildren()) {
            tmp.add(item);
        }
        clearSelected();
        grp.getChildren().clear();

        for (Node item : tmp) {
            newX = (grpMinX - grp.getxStart()) + item.getBoundsInParent().getMinX();
            newY = (grpMinY - grp.getyStart()) + item.getBoundsInParent().getMinY();
            item.relocate(newX, newY);
        }
        canvas.getChildren().addAll(tmp);
    }

    @Override
    public int getSelectedFiguresCount() {
        return selected.size();
    }

    @Override
    public int getFiguresInClipboardCount() {
        return clipboard.size();
    }

    @Override
    public boolean isGroupSelected() {
        //Wenn nur ein Element ausgewählt ist und dieses eine Gruppe ist
        return (selected.size() == 1 && selected.get(0).getClass() == myGroup.class);
    }

    public void clearSelected() {
        for (myNode aSelected : selected) {
            if(aSelected != null) {
                aSelected.setAlpha(1);
            }
        }
        selected.clear();
    }
}
