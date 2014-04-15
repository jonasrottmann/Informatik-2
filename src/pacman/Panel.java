package pacman;

/**
 * Created by jonas on 08.04.14.
 */
public class Panel {
    private Pacman pacman;
    private Ghost[] ghosts;
    private Cherry[] cherries;

    /**
     * Spielfeld neu zeichnen.
     */
    public void repaint() {
        pacman.paint();
        for (Ghost g : ghosts) {
            g.paint();
        }
        for (Cherry c : cherries) {
            c.paint();
        }
    }
}
