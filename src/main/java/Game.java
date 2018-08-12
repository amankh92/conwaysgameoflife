public class Game {

    private Board currentState;
    private Board previousState;
    private int totalDeaths;
    private int totalBirths;
    private int currentAlive;
    private int currentDead;
    private static final int frequency=100;

    public Game(int m, int n) {
        currentState = new Board(m, n);
        previousState = new Board(m, n);
        totalDeaths = 0;
        totalBirths = 0;
        currentAlive = 0;
        currentDead = m * n;
    }

    public void tick(){
        previousState.cloneBoardFrom(currentState);
        currentState.changeStates(previousState);
        totalBirths += currentState.getCurrentBirths();
        totalDeaths += currentState.getCurrentDeaths();
        currentAlive = currentState.getNumAliveCells();
        currentDead = currentState.getNumDeadCells();
        System.out.println(toString());
    }

    public void setCellInitialState(int i, int j){
        currentState.setCell(i, j);
        currentAlive++;
        currentDead--;
    }

    public void start(){
        System.out.println(toString());
        while (true){
            try {
                Thread.sleep(frequency);
                tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return currentState.toString() +
                "Alive: " + currentAlive + "\n" +
                "Dead: " + currentDead + "\n" +
                "Births: " + totalBirths + "\n" +
                "Deaths: " + totalDeaths + "\n\n";
    }

    public static void main(String args[]){
        Game game1 = new Game(4, 4);
        game1.setCellInitialState(0, 0);
        game1.setCellInitialState(0, 1);
        game1.setCellInitialState(1, 0);
        game1.setCellInitialState(1, 1);
        game1.setCellInitialState(2, 2);
        game1.setCellInitialState(2, 3);
        game1.setCellInitialState(3, 2);
        game1.setCellInitialState(3, 3);
        game1.start();
    }
}
