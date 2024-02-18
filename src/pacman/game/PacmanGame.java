package pacman.game;

import pacman.board.PacmanBoard;
import pacman.ghost.Ghost;
import pacman.hunter.Hunter;
import pacman.score.ScoreBoard;
import pacman.util.Position;
import pacman.ghost.*;

import java.util.List;

public class PacmanGame {

    private String title;
    private String author;
    private Hunter hunter;
    private PacmanBoard board;
    private Ghost[] ghosts;
    private int level;
    private int lives;
    private int tick;
    private ScoreBoard scoreboard;

    public PacmanGame(String title, String author, Hunter hunter, PacmanBoard board) {
        this.title = title;
        this.author = author;
        this.hunter = hunter;
        this.board = board;

        Position ghost_spawn = board.getGhostSpawn();
        // int ghost_spawn_x = ghost_spawn.getX();
        // int ghost_spawn_y = ghost_spawn.getY();
        Blinky blinky = new Blinky();
        blinky.setPosition(ghost_spawn);
        // ghosts.add(new Blinky(ghost_spawn_x, ghost_spawn_y))



        Clyde clyde = new Clyde();
        clyde.setPosition(ghost_spawn);

        Inky inky = new Inky();
        inky.setPosition(ghost_spawn);

        Pinky pinky = new Pinky();

        Ghost[] ghosts = {blinky, clyde, inky, pinky};

        for (int i = 0, i < ghosts.length, i++) {
            Ghost ghost = ghosts[i];
            ghost.setPosition(ghost_spawn);
        }
    }

    /**
     * Returns the title of the map.
     *
     * @ensures result != null
     * @return title of the map
     */
    public String getTitle() {
        return title;
    }

    /**
     * Return the author of the map.
     *
     * @ensures result != null
     * @return the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the current pacman board.
     *
     * @return a mutable reference to the board.
     */
    public PacmanBoard getBoard() {
        return board;
    }

    public ScoreBoard getScores() {
        return board;
    }

    public int getLevel() {
        return getLevel();
    }

    /**
     * Sets the level of the game.
     *
     * @param level to be set
     * @ensures newLevel = max(0, givenLevel)
     */
    public void setLevel(int level) {
        if (level < 0) {
            this.level = 0;
        } else {
            this.level = level;
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Hunter getHunter() {
        return hunter;
    }

    public List<Ghost> getGhosts() {
        return ghosts.clone();
    }

    public void tick() {
        if (getLives() != 0) {
            hunter.move(this);
            for (int i = 0; i < ghosts.length; i++) {
                Ghost ghost = ghosts[i];
                hunter.hit(ghost);
                if (!ghost.isDead()) {
                    ghost.move(this);
                }
                hunter.hit(ghost);
                if (ghost.isDead()) {
                    ghost.reset();
                    ghost.setPosition(board.getGhostSpawn());
                    // score + 200
                }
            }
            if (hunter.isDead()) {
                lives--;
                // Reset board and entities
            }
            if (board.isEmpty()) {
                level++;
                // Reset board and entities
            }
            tick++;
        }
    }

    public void reset() {
        lives = 4;
        level = 0;
        scoreboard.reset();
        board.reset();
        // Entities reset
        // Entitiy positions reset
        tick = 0;
    }

    public void setGhostsFrightened() {
        for (int i = 0; i < ghosts.length; i++) {
            Ghost ghost = ghosts[i];
            ghost.setPhase(Phase.FRIGHTENED, Phase.FRIGHTENED.getDuration());
        }
    }
}
