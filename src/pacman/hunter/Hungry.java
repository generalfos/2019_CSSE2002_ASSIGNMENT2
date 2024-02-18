package pacman.hunter;

import pacman.ghost.Ghost;
import pacman.util.Direction;

/**
 * A Hungry hunter that has a special ability that allows the hunter
 * to eat ghosts temporarily without them being in a Frightened state.
 * @ass1
 */
public class Hungry extends Hunter {

    /**
     * Creates a Hungry Hunter with its special ability.
     *
     * see {@link Hunter#Hunter()}
     * @ass1
     */
    public Hungry() {
        super();
    }

    /**
     * Creates a Hungry Hunter by copying the internal state of
     * another hunter.
     *
     * see {@link pacman.hunter.Hunter#Hunter(Hunter)}
     *
     * @param original hunter to copy from
     * @ass1
     */
    public Hungry(Hunter original) {
        super(original);
    }

    /**
     * If Hungry's special is active then if we are in the same tile of
     * a ghost, that ghost will be killed. Otherwise we behave as a
     * normal Hunter.
     *
     * see {@link pacman.hunter.Hunter#hit(Ghost)}
     *
     * @param ghost to check if were colliding with.
     * @ass1
     */
    @Override
    public void hit(Ghost ghost) {
        if (getPosition().equals(ghost.getPosition())) {
            if (isSpecialActive()) {
                ghost.kill();
            } else {
                super.hit(ghost);
            }
        }
    }

    public String toString() {
        int x = super.getPosition().getX();
        int y = super.getPosition().getY();
        Direction direction = super.getDirection();
        return String.format("%d,%d,%s,%d,HUNGRY",x, y, direction, getSpecialDurationRemaining());
    }

}
