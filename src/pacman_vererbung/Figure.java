package pacman_vererbung;

/**
 * Created by jonas on 08.04.14.
 */
public abstract class Figure {
    //abstract, damit keine Objecte von dieser Klasse erstellt werden können

    private int x;
    private int y;

    public abstract void paint(); //Jede KLasse, die erbt ist gezwungen paint() zu implementieren
}
