import java.io.IOException;

public class Game {

    private Board currentState;
    private Board previousState;

    public Game(int m, int n) {
        currentState = new Board(m, n);
        previousState = new Board(m, n);
    }

    public void cloneBoard(){
        for (int i=0; i<currentState.size(); i++){
            for (int j=0; j<currentState.size(); j++){
                previousState.getBoard()[i][j].setState(currentState.getBoard()[i][j].getState());
            }
        }
    }

    public void tick(){
        cloneBoard();
        currentState.changeStates(previousState);
        try {
            System.out.write(currentState.toString().getBytes());
            System.out.print("\r");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        Game game1 = new Game(3, 3);
        game1.currentState.setCell(0, 1);
        game1.currentState.setCell(1,1);
        game1.currentState.setCell(2,1);
        try {
            System.out.write(game1.currentState.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                Thread.sleep(1000);
                game1.tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
