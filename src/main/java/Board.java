public class Board {
    private Cell[][] board;

    public Board(Cell[][] board) {
        this.board = board;
    }

    public Board(int m, int n) {
        board = new Cell[m + 2][n + 2];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
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
    }

    public void copyCell(Cell cell){
        board[cell.x][cell.y] = new Cell(cell.x, cell.y, cell.getState());
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public int size(){
        return board.length;
    }

    public void changeStates(Board oldBoard){
        for (int i=1; i<board.length-1; i++){
            for (int j=1; j<board.length-1; j++){
                int neighbourCount = getLiveNeighbourCount(i, j, oldBoard);
                board[i][j].changeState(neighbourCount);
            }
        }
    }

    public int getLiveNeighbourCount(int i, int j, Board oldBoard){
        int count=0;
        count += oldBoard.board[i-1][j-1].isState();
        count += oldBoard.board[i-1][j].isState();
        count += oldBoard.board[i-1][j+1].isState();
        count += oldBoard.board[i][j-1].isState();
        count += oldBoard.board[i][j+1].isState();
        count += oldBoard.board[i+1][j-1].isState();
        count += oldBoard.board[i+1][j].isState();
        count += oldBoard.board[i+1][j+1].isState();
        return count;
    }

    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for (int i=1; i<board.length-1; i++){
            for (int j=1; j<board.length-1; j++){
                boardString.append(board[i][j].getEmoji());
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
