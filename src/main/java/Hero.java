import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position;

    public Hero(int x, int y) {
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

    public void draw(Screen screen) {
    }

    public void setPosition(Position position) {
    }
}


