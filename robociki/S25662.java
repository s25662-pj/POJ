package gamers;
import java.util.Random;

import main.Pair;
import main.Unit;

@SuppressWarnings("serial")
public class S25662 extends Unit {

    public S25662(final String id, final Pair<Double, Double> position, final double r,
                        final CollisionModel model) {
        super(id, position, r, model);

    }

    @Override
    public void run() {

        while (true) {
            final Random rand = new Random();
            this.enableStopOnWall();
            this.enableMovement();
            if(rand.nextInt(2) + 1 == 1){
                this.rotateRight();
            }
            else {
                this.rotateLeft();
            }
            this.forward();
            if(nearestCollision()>0){
                this.rotateBy(150);
            }
            if(whatIsInRange() == 3){
                this.stopRotate();
                this.attackInNextMove();
            }

        }
    }

}
