public class Board {
    private Cell[][] board;
    private int numAliveCells;
    private int currentBirths;
    private int currentDeaths;

    public Board(Cell[][] board) {
        this.board = board;
    }

    public Board(int m, int n) {
        board = new Cell[m + 2][n + 2];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int i, int j){
        return board[i + 1][j + 1];
    }

    public void setCell(int i, int j){
        Cell cell = new Cell(i + 1, j + 1, true);
        board[i + 1][j + 1] = cell;
        numAliveCells++;
    }

    public void changeStates(Board oldBoard){
        currentBirths=0;
        currentDeaths=0;
        for (int i=1; i<board.length-1; i++){
            for (int j=1; j<board[i].length-1; j++){
                int neighbourCount = getLiveNeighbourCount(i, j, oldBoard);
                boolean previousState = board[i][j].getStateBool();
                board[i][j].changeState(neighbourCount);
                boolean newState = board[i][j].getStateBool();
                if (previousState!=newState){
                    if (newState){
                        numAliveCells++;
                        currentBirths++;
                    } else {
                        numAliveCells--;
                        currentDeaths++;
                    }
                }
            }
        }
    }

    public int getLiveNeighbourCount(int i, int j, Board oldBoard){
        int count=0;
        count += oldBoard.board[i-1][j-1].getStateInt();
        count += oldBoard.board[i-1][j].getStateInt();
        count += oldBoard.board[i-1][j+1].getStateInt();
        count += oldBoard.board[i][j-1].getStateInt();
        count += oldBoard.board[i][j+1].getStateInt();
        count += oldBoard.board[i+1][j-1].getStateInt();
        count += oldBoard.board[i+1][j].getStateInt();
        count += oldBoard.board[i+1][j+1].getStateInt();
        return count;
    }

    public void cloneBoardFrom(Board board1){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                board[i][j].setState(board1.board[i][j].getStateBool());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int i=1; i<board.length-1; i++){
            for (int j=1; j<board[i].length-1; j++){
                boardString.append(board[i][j].getStateEmoji());
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public int getNumAliveCells() {
        return numAliveCells;
    }

    public void setNumAliveCells(int numAliveCells) {
        this.numAliveCells = numAliveCells;
    }

    public int getNumDeadCells(){
        return (board.length - 2) * (board[0].length - 2) - numAliveCells;
    }

    public int getCurrentBirths() {
        return currentBirths;
    }

    public void setCurrentBirths(int currentBirths) {
        this.currentBirths = currentBirths;
    }

    public int getCurrentDeaths() {
        return currentDeaths;
    }

    public void setCurrentDeaths(int currentDeaths) {
        this.currentDeaths = currentDeaths;
    }
}
