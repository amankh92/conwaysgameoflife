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
            case "pulsar":
                game = new Pulsar();
                break;
            default:
                game = new Game();
                break;
        }
        game.start();
    }
}
