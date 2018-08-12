public class Game {

    private Board currentState;
    private Board previousState;
    private int totalDeaths;
    private int totalBirths;
    private int currentAlive;
    private int currentDead;
    private static final int frequency=500;
    private int rows;
    private int columns;

    public Game() {

    }

    public Game(int m, int n) {
        rows = m;
        columns = n;
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
        System.out.print(clearConsole() + toString());
    }

    private String clearConsole(){
        StringBuilder backSpace = new StringBuilder();
        for (int i=0; i<rows+4; i++){
            backSpace.append("\033[1A\033[K");
        }
        return backSpace.toString();
    }

    public void setCellInitialState(int i, int j){
        currentState.setCell(i, j);
        currentAlive++;
        currentDead--;
    }

    public void start(){
        System.out.print(toString());
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
                "Deaths: " + totalDeaths + "\n";
    }
}
