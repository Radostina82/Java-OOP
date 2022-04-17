package WorkingWithAbstraction.JediGalaxy;

public class Galaxy {
    private final Stars[][] stars;

    public Galaxy(int row, int col){
        this.stars = new Stars[row][col];
        this.fillStars();
    }
    public int getRows(){
        return this.stars.length;
    }

    public int getColumns(int row){
        return this.stars[row].length;
    }

    private void fillStars() {
        int starValue = 0;
        for (int r = 0; r < this.stars.length; r++) {
            for (int c = 0; c < this.stars[r].length; c++) {
                this.stars[r][c] = new Stars(starValue++);
            }
        }
    }
    public void setStar(int row, int col, Stars star) {
        if(isInRange(row, col)){
            this.stars[row][col] = star;
        }
    }

    private boolean isInRange(int row, int col) {
        return row >= 0 && row < this.stars.length
                && col >= 0 && col < this.stars[row].length;
    }

    public int getStarValue(int row, int col) {
        int result = 0;
        if(isInRange(row, col)){
            result = this.stars[row][col].getValue();
        }
        return result;
    }
}
