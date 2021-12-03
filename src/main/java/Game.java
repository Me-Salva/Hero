import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;

public class Game {

    public Screen screen;
    public Hero hero;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Hero(10, 10);
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }


    public void run() throws IOException {
        draw();
        while(true){
            KeyStroke key = screen.readInput();
            processKey(key);

            if (key.getKeyType() == KeyType.Character &&
                    key.getCharacter() == 'q')
                screen.close();

            if (key.getKeyType() == KeyType.EOF)
                break;
        }
    }

    private int x = 10;
    private int y = 10;

    private void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> moveHero(hero.moveUP());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());
        }
    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }

}