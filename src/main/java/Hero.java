import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.AbstractTextGraphics;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element{
    private Position position;
    private Screen screen;
    TextGraphics graphics;

    {
        assert false;
        graphics = screen.newTextGraphics();
    }

    public Hero(int x, int y) {
        super(x,y);
        position = new Position(x, y);
    }

    public Position moveUP(){
        return new Position(position.getX(),position.getY() - 1);
    }
    public Position moveDown(){
        return new Position(position.getX(),position.getY() + 1);
    }
    public Position moveLeft(){
        return new Position(position.getX() - 1,position.getY());
    }
    public Position moveRight(){
        return new Position(position.getX() + 1,position.getY());
    }

    public void draw(TextGraphics screen) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new
                        TerminalPosition(position.getX(), position.getY()),
                "X");
    }

    public void setPosition(Position position) {
    }
}


