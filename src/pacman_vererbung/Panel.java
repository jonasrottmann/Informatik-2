package pacman_vererbung;

/**
 * Created by jonas on 08.04.14.
 */
public class Panel {
    private Figure[] figures;

    /**
     * Spielfeld neu zeichnen.
     */
    public void repaint() {
        for (Figure f : figures) {
            f.paint();
        }
    }
}
