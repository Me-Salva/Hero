import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    public int height;
    public int width;
    public Screen screen;
    public Hero hero;
    private final List<Wall> walls;
    public List<Coin> coins;
    public List<Monster> monsters;
    public TextGraphics graphics;

    public Arena(int width, int height) {
        this.height = height;
        this.width = width;
        hero = new Hero(10, 10);
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

    public void draw(TextGraphics textGraphics) {
        graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new
                TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);

        for(Coin coin : coins)
            coin.draw(graphics);

        for(Monster monster : monsters)
            monster.draw(graphics);
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

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) +
                    1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private void retrieveCoins(){
        for(Coin coin : coins){
            Hero hero = null;
            assert false;
            if(hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for(int i=0; i<5; i++){
            Monster newmonster = new Monster(random.nextInt(width-2) + 1,
                    random.nextInt(height-2)+1);
            if(!monsters.contains(newmonster) && !newmonster.getPosition().equals(hero.getPosition()))
                monsters.add(newmonster);
        }
        return monsters;
    }
    
    public void moveMonsters(){
        Monster[] monsters = new Monster[0];
    }

    public boolean verifyMonsterCollisions(){
        for(Monster monster : monsters){
            if(monster.getPosition().equals(hero.getPosition())){
                System.out.println("Game Over");
                return true;
            }
        }
        return false;
    }
}
