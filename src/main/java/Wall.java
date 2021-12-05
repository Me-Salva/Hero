import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    public Wall(int x, int y) {
        super(x,y);
    }

    public void draw(TextGraphics graphics) {
    }

    @Override
    public Position move(Arena arena) {
        return null;
    }
}
