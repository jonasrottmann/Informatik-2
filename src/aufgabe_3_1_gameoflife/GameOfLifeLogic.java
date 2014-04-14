package aufgabe_3_1_gameoflife;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht
 * als zyklisch geschlossen betrachtet.
 *
 * @author Holger Vogelsang
 * @author Jonas Rottmann
 */
public class GameOfLifeLogic {

    private boolean[][] population;

    /**
     * Übergibt die im Menü ausgewählte Startsituation als zweidimensionales Array.
     * @param generation Im Menu ausgewählte Startsituation.
     */
    public void setStartGeneration(boolean[][] generation) {
        population = generation;
    }

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
    public void nextGeneration() {
        boolean[][] tmpPopulation = new boolean[population.length][population[0].length];
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population[i].length; j++) {
                tmpPopulation[i][j] = (calcActiveNeighbours(i, j) == 3 || (isCellAlive(i, j) && calcActiveNeighbours(i, j) == 2));
            }
        }
        population = tmpPopulation;
    }

    /**
     * Berechnet die Anzahl der lebenden Nachbarzellen der Zelle an der Position xy.
     *
     * @param x x-Wert der zu prüfenden Zelle.
     * @param y y-Wert der zu prüfenden Zelle.
     * @return Anzahl der lebenden Nachbarzellen.
     */
    private int calcActiveNeighbours(int x, int y) {
        int activeNeighbours = 0;

        //TODO Schleife

        //   |   |
        // x | O |
        //   |   |
        if (isCellAlive(x - 1, y)) { activeNeighbours++; }

        //   |   |
        //   | O | x
        //   |   |
        if (isCellAlive(x + 1, y)) { activeNeighbours++; }

        //   |   |
        //   | O |
        //   | x |
        if (isCellAlive(x, y - 1)) { activeNeighbours++; }

        //   | x |
        //   | O |
        //   |   |
        if (isCellAlive(x, y + 1)) { activeNeighbours++; }

        // x |   |
        //   | O |
        //   |   |
        if (isCellAlive(x - 1, y + 1)) { activeNeighbours++; }

        //   |   | x
        //   | O |
        //   |   |
        if (isCellAlive(x + 1, y + 1)) { activeNeighbours++; }

        //   |   |
        //   | O |
        // x |   |
        if (isCellAlive(x - 1, y - 1)) { activeNeighbours++; }

        //   |   |
        //   | O |
        //   |   | x
        if (isCellAlive(x + 1, y - 1)) { activeNeighbours++; }

        return activeNeighbours;
    }

    /**
     * Gibt den Lebenszustand der Zelle an der Position xy zurück.
     *
     * @param x x-Wert der zu prüfenden Zelle.
     * @param y y-Wert der zu prüfenden Zelle.
     * @return Zustand der Zelle.
     */
    public boolean isCellAlive(int x, int y) {
        if (x >= 0 && y >= 0 && x < population.length && y < population[x].length) {
            return population[x][y];
        }
        return false;
    }
}