package pacman.game;

import java.io.IOException;
import java.io.Reader;

public class GameReader {

    public GameReader() {}

    public static PacmanGame read(Reader reader) throws UnpackableException, IOException {
        return new PacmanGame();
    }
}
