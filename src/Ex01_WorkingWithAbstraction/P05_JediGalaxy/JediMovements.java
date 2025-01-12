package Ex01_WorkingWithAbstraction.P05_JediGalaxy;

public class JediMovements {

    private Galaxy galaxy;

    public JediMovements(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public void destroyStars(int[] enemyPositions) {

        int enemyRow = enemyPositions[0];
        int enemyCol = enemyPositions[1];

        while (enemyRow >= 0 && enemyCol >= 0) {

            if (isInRange(enemyRow, enemyCol)) {
                this.galaxy.setStar(enemyRow, enemyCol, new Star(0));
            }

            enemyRow--;
            enemyCol--;
        }
    }

    private boolean isInRange(int enemyRow, int enemyCol) {
        return enemyRow >= 0 && enemyRow < this.galaxy.getRows()
                && enemyCol >= 0 && enemyCol < this.galaxy.getCols(enemyRow);
    }

    public long sumOfStars(int[] playerPositions) {
        int row = playerPositions[0];
        int col = playerPositions[1];
        long sum = 0;
        while (row >= 0 && col < this.galaxy.getCols(0)) {

            if (isInRange(row, col)) {
                sum += this.galaxy.getStarValue(row, col);
            }
            row--;
            col++;
        }
        return sum;
    }
}
