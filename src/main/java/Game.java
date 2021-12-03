import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    public Screen screen;

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
        screen.setCharacter(x, y,
                TextCharacter.fromCharacter('X')[0]);
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
            case ArrowUp -> y += 1;
            case ArrowDown -> y -= 1;
            case ArrowLeft -> x -= 1;
            case ArrowRight -> x += 1;
        }
    }

}