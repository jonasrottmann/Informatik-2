package aufgabe_3_3_2;

import javafx.scene.Group;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jonas on 04.05.14.
 */
public class DrawingListenerImplementation implements DrawingListener {
    public static final double DEFAULT_RADIUS = 50.0;
    private double xStart, yStart;
    private myShape myShape;
    private ArrayList<Node> selected = new ArrayList<>();
    private ArrayList<Node> clipboard = new ArrayList<>();
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
                myShape = new myEllipse();
                break;
            case "rectangle":
                myShape = new myRectangle();
                break;
        }
        myShape.get().relocate(xPos, yPos);
        canvas.getChildren().add(myShape.get());
    }

    @Override
    public void startMoveFigure(Node node, double xPos, double yPos) {
        moveStartOffsetX = xPos - node.getBoundsInParent().getMinX();
        moveStartOffsetY = yPos - node.getBoundsInParent().getMinY();
    }

    @Override
    public void workCreateFigure(double xPos, double yPos) {
        myShape.workCreate(xStart, yStart, xPos, yPos);
    }

    @Override
    public void workMoveFigure(Node node, double xPos, double yPos) {
        while (node.getParent().getClass() == Group.class) {
            node = node.getParent();
        }
        node.relocate(xPos - moveStartOffsetX, yPos - moveStartOffsetY);
    }

    @Override
    public void endCreateFigure(double xPos, double yPos) {
    }

    @Override
    public void endMoveFigure(Node node, double xPos, double yPos) {
    }

    @Override
    public void selectFigure(Node node, double xPos, double yPos, boolean shiftPressed) {
        if (node instanceof DrawPane) {
            clearSelected();
            return;
        }

        while (node.getParent().getClass() == Group.class) {
            node = node.getParent();
        }

        if (shiftPressed) {
            node.setOpacity(0.5);
            selected.add(node);
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
        for (Node aSelected : selected) {
            canvas.getChildren().remove(aSelected);
        }
        clearSelected();
    }

    @Override
    public void copyFigures() {
        //TODO selected in clipboard klonen
    }

    @Override
    public void pasteFigures() {
        canvas.getChildren().addAll(clipboard);
    }

    @Override
    public void moveSelectedFiguresToTop() {
        for (Node aSelected : selected) {
            aSelected.toFront();
        }
        clearSelected();
    }

    @Override
    public void moveSelectedFiguresToBottom() {
        for (Node aSelected : selected) {
            aSelected.toBack();
        }
        clearSelected();
    }

    @Override
    public void moveSelectedFiguresDown() {
        ArrayList<Node> tmp = new ArrayList<>();

        for(Node child : canvas.getChildren()) {
            tmp.add(child);
        }
        for(Node s : selected) {
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
        for(Node s : selected) {
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
        Group group = new Group();
        for (Node aSelected : selected) {
            group.getChildren().add(aSelected);
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
            tmp.add(child);
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
        return (selected.size() == 1 && selected.get(0).getClass() == Group.class);
    }

    public void clearSelected() {
        for (Node aSelected : selected) {
            aSelected.setOpacity(1);
        }
        selected.clear();
    }
}
