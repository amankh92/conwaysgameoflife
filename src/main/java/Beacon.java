public class Beacon extends Game{
    public Beacon() {
        super(4, 4);
        setCellInitialState(0, 0);
        setCellInitialState(0, 1);
        setCellInitialState(1, 0);
        setCellInitialState(1, 1);
        setCellInitialState(2, 2);
        setCellInitialState(2, 3);
        setCellInitialState(3, 2);
        setCellInitialState(3, 3);
    }
}
