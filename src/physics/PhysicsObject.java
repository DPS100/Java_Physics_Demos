package src.physics;

public abstract class PhysicsObject {
    protected Vector location;
    protected Vector velocity;
    protected Vector acceleration;

    private Vector queueLoca;
    private Vector queueVelo;
    private Vector queueAccel;

    protected PhysicsObject(Vector location) {
        this.location = location;
        velocity = new Vector();
        acceleration = new Vector();
    }

    public void manipAccel(Vector deltaA) {

    }

    public void manipVelo(Vector deltaV) {

    }

    public void manipLoca(Vector deltaL) {

    }

}
