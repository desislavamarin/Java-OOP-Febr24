package Ex01_WorkingWithAbstraction.P05_JediGalaxy;

public class Galaxy {
    private Star[][] stars;

    public Galaxy(int rows, int cols) {
        this.stars = new Star[rows][cols];
        this.fillTheStars();
    }

    public int getRows() {
        return this.stars.length;
    }

    public int getCols(int row) {
        return this.stars[row].length;
    }

    public void setStar(int row, int col, Star star) {
        if (isInRange(row, col)) {
            this.stars[row][col] = star;
        }
    }

    public int getStarValue(int row, int col) {
        int result = 0;
        if (isInRange(row, col)) {
            result = this.stars[row][col].getValue();
        }
        return result;
    }

    private void fillTheStars() {
        int value = 0;
        for (int row = 0; row < this.stars.length; row++) {
            for (int col = 0; col < this.stars[row].length; col++) {
                this.stars[row][col] = new Star(value++);
            }
        }
    }

    private boolean isInRange(int row, int col) {
        return row >= 0 && row < this.stars.length
                && col >= 0 && col < this.stars[row].length;
    }
}
