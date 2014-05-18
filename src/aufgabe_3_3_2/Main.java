package aufgabe_3_3_2;

import javafx.application.Application;

/**
 * Created by jonas on 30.04.14.
 */
public class Main {
    public static void main (String args[]) {
        DrawPane canvas = new DrawPane(800, 500);
        canvas.setStyle("-fx-background-color: lightgrey;");

        DrawingListener listener = new DrawingListenerImplementation(canvas);

        MainWindow.setDrawingListener(listener);
        MainWindow.setMainPanel(canvas);
        MainWindow.setHorizontalToolBar(false);
        Application.launch(MainWindow.class, args);
    }
}
