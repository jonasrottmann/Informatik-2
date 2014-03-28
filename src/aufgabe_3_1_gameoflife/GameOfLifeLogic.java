package aufgabe_3_1_gameoflife;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht
 * als zyklisch geschlossen betrachtet.
 *
 * @author Holger Vogelsang
 */
public class GameOfLifeLogic {

    private boolean[][] population;

    /**
     * Übergibt die im Menü ausgewählte Startsituation als zweidimensionales Array.
     *
     * @param generation
     */
    public void setStartGeneration(boolean[][] generation) {
        population = generation;
    }

    /**
     * Entwickelt die nächste Generation von Zellen.
     */
    public void nextGeneration() {
        boolean[][] tmpPopulation = population.clone();
        for (int i = 0; i < tmpPopulation.length; i++) {
            for (int j = 0; j < tmpPopulation[i].length; j++) {
                applyRules(tmpPopulation, i, j);
            }
        }
        population = tmpPopulation;
    }

    /**
     * Bestimmt den Zustand einer Zelle in der nächsten Generation, anhand der Regeln des Game Of Life.
     * Eine Zelle bleibt am Leben, wenn sie 2 oder 3 lebende Nachbarn hat.
     * Eine Zelle stirbt wenn sie mehr als 3 oder weniger als 2 lebende Nachbarn hat.
     * Eine tote Zelle wird belebt wenn sie genau 3 lebende Nachbarn hat.
     *
     * @param population Aktuelle Population
     * @param x          x-Wert der zu prüfenden Zelle.
     * @param y          y-Wert der zu prüfenden Zelle.
     */
    private void applyRules(boolean[][] population, int x, int y) {
        if (calcActiveNeighbours(x, y) < 2 | calcActiveNeighbours(x, y) > 3) {
            population[x][y] = false;
        } else if (calcActiveNeighbours(x, y) == 3) {
            population[x][y] = true;
        }
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

        //   |   |
        // x | O |
        //   |   |
        if (isCellAlive(x - 1, y)) activeNeighbours++;

        //   |   |
        //   | O | x
        //   |   |
        if (isCellAlive(x + 1, y)) activeNeighbours++;

        //   |   |
        //   | O |
        //   | x |
        if (isCellAlive(x, y - 1)) activeNeighbours++;

        //   | x |
        //   | O |
        //   |   |
        if (isCellAlive(x, y + 1)) activeNeighbours++;

        // x |   |
        //   | O |
        //   |   |
        if (isCellAlive(x - 1, y + 1)) activeNeighbours++;

        //   |   | x
        //   | O |
        //   |   |
        if (isCellAlive(x + 1, y + 1)) activeNeighbours++;

        //   |   |
        //   | O |
        // x |   |
        if (isCellAlive(x - 1, y - 1)) activeNeighbours++;

        //   |   |
        //   | O |
        //   |   | x
        if (isCellAlive(x + 1, y - 1)) activeNeighbours++;

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
