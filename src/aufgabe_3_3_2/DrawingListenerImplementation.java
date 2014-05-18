package aufgabe_3_3_2;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.ArrayList;

/**
 * Created by jonas on 04.05.14.
 */
public class DrawingListenerImplementation implements DrawingListener {
    public static final double DEFAULT_RADIUS = 50.0;
    private double x, y;
    private Shape figure;
    private ArrayList<Shape> selected = new ArrayList<>();
    private DrawPane canvas;

    public DrawingListenerImplementation(DrawPane canvas) {
        this.canvas = canvas;
    }

    @Override
    public void startCreateFigure(String figureType, double xPos, double yPos) {

        switch (figureType) {
            case "ellipse":
                figure = new Ellipse(0, 0);
                figure.relocate(xPos, yPos);
                break;
            case "rectangle":
                figure = new Rectangle(0, 0, Color.BLUEVIOLET);
                figure.relocate(xPos, yPos);
                break;
            case "line":
                figure = new Line(xPos, yPos, xPos, yPos);
                break;
        }
        figure.setId(String.valueOf(System.currentTimeMillis()));
        canvas.getChildren().add(figure);

        x = figure.getLayoutX();
        y = figure.getLayoutY();
    }

    @Override
    public void startMoveFigure(Node node, double xPos, double yPos) {
        if (node instanceof Shape) {
            figure = (Shape) canvas.lookup("#" + String.valueOf(node.getId()));
        }
    }

    @Override
    public void workCreateFigure(double xPos, double yPos) {
        if (figure instanceof Ellipse) {
            Ellipse ellipse = (Ellipse) figure;
            //circle.setRadius(Math.abs(x - xPos));

            if(y - yPos > 0 && x - xPos > 0) {
                //nach links oben ziehen
                ellipse.setRadiusY((y - yPos)/2);
                ellipse.setRadiusX((x - xPos)/2);
                ellipse.relocate(x - 2*(ellipse.getRadiusX()), y - 2*(ellipse.getRadiusY()));
            }
            else if (y - yPos > 0 && x - xPos < 0) {
                //nach rechts oben ziehen
                ellipse.setRadiusY((y - yPos)/2);
                ellipse.setRadiusX((xPos - x)/2);
                ellipse.relocate(x, y - 2*(ellipse.getRadiusY()));
            }
            else if (y - yPos < 0 && x - xPos < 0) {
                //nach rechts unten ziehen
                ellipse.setRadiusY((yPos-y)/2);
                ellipse.setRadiusX((xPos-x)/2);
                ellipse.relocate(x, y);
            }
            else if (y - yPos < 0 && x - xPos > 0) {
                //nach links unten ziehen
                ellipse.setRadiusY((yPos - y)/2);
                ellipse.setRadiusX((x - xPos)/2);
                ellipse.relocate(x - 2*(ellipse.getRadiusX()), y);
            }


        }
        if (figure instanceof Rectangle) {
            Rectangle rect = (Rectangle) figure;

            System.out.println("Höhe:" + rect.getHeight() + " " + (yPos - rect.getY()));


            if(y - yPos > 0 && x - xPos > 0) {
                //nach links oben ziehen
                rect.setHeight(y - yPos);
                rect.setWidth(x - xPos);
                rect.relocate(x - rect.getWidth(), y - rect.getHeight());
            }
            else if (y - yPos > 0 && x - xPos < 0) {
                //nach rechts oben ziehen
                rect.setHeight(y - yPos);
                rect.setWidth(xPos - x);
                rect.relocate(x, y - rect.getHeight());
            }
            else if (y - yPos < 0 && x - xPos < 0) {
                //nach rechts unten ziehen
                rect.setHeight(yPos - y);
                rect.setWidth(xPos - x);
            }
            else if (y - yPos < 0 && x - xPos > 0) {
                //nach links unten ziehen
                rect.setHeight(yPos - y);
                rect.setWidth(x - xPos);
                rect.relocate(x - rect.getWidth(), y);
            }
        }
        if (figure instanceof Line) {
            Line line = (Line) figure;
            line.setEndX(xPos);
            line.setEndY(yPos);
        }
    }

    @Override
    public void workMoveFigure(Node node, double xPos, double yPos) {
        if (figure instanceof Ellipse) {
            Ellipse circle = (Ellipse) figure;
            circle.relocate(xPos - circle.getRadiusX(), yPos - circle.getRadiusY());
        }
        if (figure instanceof Rectangle) {
            Rectangle rect = (Rectangle) figure;

            double dragStartOffsetX = xPos - rect.getBoundsInParent().getMinX();

            rect.relocate(xPos - dragStartOffsetX, yPos - rect.getHeight()/2);
        }
        if (figure instanceof Line) {
            Line line = (Line) figure;
            line.relocate(xPos, yPos);
        }
    }

    @Override
    public void endCreateFigure(double xPos, double yPos) {
    }

    @Override
    public void endMoveFigure(Node node, double xPos, double yPos) {

    }

    @Override
    public void selectFigure(Node node, double xPos, double yPos, boolean shiftPressed) {
        figure = (Shape) canvas.lookup("#" + String.valueOf(node.getId()));

        if (shiftPressed) {
            figure.setStroke(Color.BLACK);
            figure.setStrokeWidth(1);
            figure.setOpacity(0.5);
            selected.add(figure);
        } else {
            for (Shape aSelected : selected) {
                aSelected.setOpacity(1);
                aSelected.setStrokeWidth(0);
            }
            selected.clear();
        }
    }

    @Override
    public void rotate(Node node, double angle) {
        figure = (Shape) canvas.lookup("#" + String.valueOf(node.getId()));
        figure.setRotate(angle);
    }

    @Override
    public void translate(Node node, double deltaX, double deltaY) {

    }

    @Override
    public void zoom(Node node, double zoomFactor) {

    }

    @Override
    public void deleteFigures() {

    }

    @Override
    public void copyFigures() {

    }

    @Override
    public void pasteFigures() {

    }

    @Override
    public void moveSelectedFiguresToTop() {

    }

    @Override
    public void moveSelectedFiguresToBottom() {

    }

    @Override
    public void moveSelectedFiguresDown() {

    }

    @Override
    public void moveSelectedFiguresUp() {

    }

    @Override
    public void groupFigures() {
        Group group = new Group();
        for (Shape aSelected : selected) {
            group.getChildren().add(aSelected);
        }

    }

    @Override
    public void ungroupFigures() {
        //TODO
    }

    @Override
    public int getSelectedFiguresCount() {
        return 0;
    }

    @Override
    public int getFiguresInClipboardCount() {
        return 0;
    }

    @Override
    public boolean isGroupSelected() {
        return false;
    }
}
