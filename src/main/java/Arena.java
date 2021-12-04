import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.AbstractTextGraphics;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    public int height;
    public int width;
    private Screen screen;
    TextGraphics graphics;

    {
        assert false;
        graphics = screen.newTextGraphics();
    }

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        Hero hero = new Hero(10, 10);
    }

    public void moveHero(Position position) {
        Hero hero = null;
        if (canHeroMove(position)) {
            assert false;
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        return (position.getX() >= 0 && position.getX() < width) &&
                (position.getY() >= 0 && position.getY() < height);
    }

    public void setPosition(Position position) {
    }

    public void draw(TextGraphics screen) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new
                TerminalSize(width, height), ' ');
    }
}
