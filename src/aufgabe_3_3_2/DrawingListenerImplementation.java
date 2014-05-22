package aufgabe_3_3_2;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by jonas on 04.05.14.
 */
public class DrawingListenerImplementation implements DrawingListener {
    private double xStart, yStart;
    private myShape figure;
    private ArrayList<myNode> selected = new ArrayList<>();
    private ArrayList<myNode> clipboard = new ArrayList<>();
    private DrawPane canvas;
    private double moveStartOffsetX, moveStartOffsetY;

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
                figure = new myLine();
                break;
        }
        //Random Color
        Random rand = new Random();
        double r = rand.nextDouble();
        double g = rand.nextDouble();
        double b = rand.nextDouble();
        figure.setFillColor(new Color(r, g, b, 1));

        figure.move(xPos, yPos);
        canvas.getChildren().add((Shape) figure);
    }

    @Override
    public void startMoveFigure(Node node, double xPos, double yPos) {
        moveStartOffsetX = xPos - node.getBoundsInParent().getMinX();
        moveStartOffsetY = yPos - node.getBoundsInParent().getMinY();
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
    }

    @Override
    public void endMoveFigure(Node node, double xPos, double yPos) {
    }

    @Override
    public void selectFigure(Node node, double xPos, double yPos, boolean shiftPressed) {
        if (node instanceof DrawPane) return; //Klicke auf Zeichenfläche nicht beachten

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
        clearSelected();
    }

    @Override
    public void moveSelectedFiguresToBottom() {
        for (myNode aSelected : selected) {
            aSelected.bringToBack();
        }
        clearSelected();
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
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Fehler");
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
            try {
                Collections.swap(tmp, tmp.indexOf(s), tmp.indexOf(s) + 1);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Fehler");
            }
        }
        canvas.getChildren().clear();
        canvas.getChildren().addAll(tmp);
    }

    @Override
    public void groupFigures() {
        myGroup group = new myGroup();
        for (myNode aSelected : selected) {
            if(aSelected != null) {
                group.getChildren().add((Node) aSelected);
            }
        }
        canvas.getChildren().add(group);

        clearSelected();
    }

    @Override
    public void ungroupFigures() {
        ArrayList<Node> tmp = new ArrayList<>();
        Group grp = (Group) selected.get(0);
        //Elemente aus Gruppe in tmp kopieren
        for (Node child : grp.getChildren()) {
            if(child != null) {
                tmp.add(child);
            }
        }
        //Gruppe löschen
        grp.getChildren().clear();
        //Elemente aus tmp wieder in canvas einfügen
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
