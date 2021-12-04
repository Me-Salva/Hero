import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final List<Wall> walls;
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
        this.walls = createWalls();
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
                (position.getY() >= 0 && position.getY() < height) &&
                 !walls.contains(new Wall(position.getX(), position.getY()));
    }

    public void setPosition(Position position) {
    }

    public void draw(TextGraphics screen) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new
                TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

}
