import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element{
    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#339933"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "m");
    }

    @Override
    public Position move(Arena arena) {
        return null;
    }
}
