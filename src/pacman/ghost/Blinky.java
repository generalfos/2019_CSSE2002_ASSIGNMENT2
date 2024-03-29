package pacman.ghost;

import pacman.game.PacmanGame;
import pacman.util.Position;

/**
 * Blinky is a ghost that behaves in a very aggressive manner
 * towards a hunter. When not chasing the hunter down, Blinky
 * likes to hang out in the top right corner of the board in a
 * red glow.
 *
 * @ass1
 */
public class Blinky extends Ghost {

    public Position chaseTarget(PacmanGame game) {
        return game.getHunter().getPosition();
    }

    public Position home(PacmanGame game) {
        int x = game.getBoard().getWidth();
        return new Position(x+1, -1);
    }

    /**
     * Get Blinkys colour.
     * @return "#d54e53"
     * @ass1
     */
    @Override
    public String getColour() {
        return "#d54e53";
    }

    /**
     * Get Blinkys type/name.
     * @return BLINKY;
     * @ass1
     */
    @Override
    public GhostType getType() {
        return GhostType.BLINKY;
    }
}
