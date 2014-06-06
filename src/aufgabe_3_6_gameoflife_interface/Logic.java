package aufgabe_3_6_gameoflife_interface;

/**
 * Created by jonas on 06.06.14.
 */
public interface Logic {


    /**
     * Übergibt die im Menü ausgewählte Startsituation als zweidimensionales Array.
     * @param generation Im Menu ausgewählte Startsituation.
     */
    public void setStartGeneration(boolean[][] generation);

    /**
     * Entwickelt die nächste Generation von Zellen anhand der Regeln des Game of Life.
     * <p>Regeln:
     * <ul>
     *     <li>Eine Lebende Zelle bleibt am leben, wenn sie 2 oder 3 lebende Nachbarn hat.</li>
     *     <li>Eine lebende Zelle stirbt, wenn sie weniger als 2 oder mehr als 3 Nachbarn hat.</li>
     *     <li>Eine tote Zelle wird wiederbelebt, wenn sie genau 3 Nachbarn hat.</li>
     * </ul>
     * </p>
     */
    public void nextGeneration();

    /**
     * Gibt den Lebenszustand der Zelle an der Position xy zurück.
     *
     * @param x x-Wert der zu prüfenden Zelle.
     * @param y y-Wert der zu prüfenden Zelle.
     * @return Zustand der Zelle.
     */
    public boolean isCellAlive(int x, int y);
}
