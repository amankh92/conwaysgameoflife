public class Driver {
    public static void main(String[] args){
        Game game;
        switch (args[0]){
            case "blinker":
                game = new Blinker();
                break;
            case "toad":
                game = new Toad();
                break;
            case "beacon":
                game = new Beacon();
                break;
            default:
                game = new Game();
        }
        game.start();
    }
}
