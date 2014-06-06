package aufgabe_3_6_gameoflife_interface;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht
 * als zyklisch geschlossen betrachtet.
 *
 * @author Holger Vogelsang
 * @author Jonas Rottmann
 */
public class GameOfLifeLogic implements Logic {

    private boolean[][] population;

    @Override
    public void setStartGeneration(boolean[][] generation) {
        population = generation;
    }

    @Override
    public void nextGeneration() {
        boolean[][] tmpPopulation = new boolean[population.length][population[0].length];
        for (int i = 0; i < population.length; i++) {
            for (int j = 0; j < population[i].length; j++) {
                tmpPopulation[i][j] = (calcActiveNeighbours(i, j) == 3 || (isCellAlive(i, j) && calcActiveNeighbours(i, j) == 2));
            }
        }
        population = tmpPopulation;
    }

    @Override
    public boolean isCellAlive(int x, int y) {
        if (x >= 0 && y >= 0 && x < population.length && y < population[x].length) {
            return population[x][y];
        }
        return false;
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
}