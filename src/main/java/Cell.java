import com.vdurmont.emoji.EmojiParser;

public class Cell {
    private boolean state;
    private Coordinates coordinates;
    private static final String deadCellEmoji = ":white_large_square:";
    private static final String aliveCellEmoji = ":black_large_square:";

    public int getStateInt() {
        return state ? 1: 0;
    }

    public String getStateEmoji(){
        String emojiStr = state ? aliveCellEmoji : deadCellEmoji;
        return EmojiParser.parseToUnicode(emojiStr);

    }

    public boolean getStateBool(){
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Cell(int i, int j){
        state = false;
        coordinates = new Coordinates(i, j);
    }

    public Cell(int i, int j, boolean state) {
        this.state = state;
        this.coordinates = new Coordinates(i, j);
    }

    public void changeState(int liveNeighbourCount){
        if (state){
            if (liveNeighbourCount < 2){
                setState(false);
            } else if (liveNeighbourCount == 2 || liveNeighbourCount == 3) {
                setState(true);
            } else if (liveNeighbourCount > 3){
                setState(false);
            }
        } else {
            if (liveNeighbourCount == 3){
                setState(true);
            }
        }
    }
}
