import com.vdurmont.emoji.EmojiParser;

public class Cell {
    private boolean state;
    public int x;
    public int y;

    public int isState() {
        return state ? 1: 0;
    }

    public String getEmoji(){
        String emojiStr = state ? ":red_circle:" : ":white_circle:";
        return EmojiParser.parseToUnicode(emojiStr);

    }

    public boolean getState(){
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Cell(int i, int j){
        state = false;
        x = i;
        y = j;
    }

    public Cell(int i, int j, boolean state) {

        this.state = state;
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

    @Override
    public String toString() {
        return "Cell{" +
                "state=" + state +
                '}';
    }
}
