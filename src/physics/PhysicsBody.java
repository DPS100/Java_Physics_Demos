package src.physics;

public abstract class PhysicsBody {
    protected Vector position;
    protected Vector velocity;
    protected Vector acceleration;
    protected double mass;

    /**
     * Physics body constructor.
     * Defaults velocity and acceleration vectors to 0.
     * @param position Initial postition
     * @param mass Mass of this body (base unit is 1).
     */
    protected PhysicsBody(Vector position, double mass) {
        setup(position, new Vector(), new Vector(), mass);
    }

    /**
     * Physics body constructor.
     * Defaults position, velocity, and acceleration vectors to 0.
     * @param mass Mass of this body (base unit is 1).
     */
    protected PhysicsBody(double mass) {
        setup(new Vector(), new Vector(), new Vector(), mass);
    }

    /**
     * Physics body constructor.
     * Defaults velocity and acceleration vectors to 0.
     * Defaults mass to 1.
     * @param position Initial position
     */
    protected PhysicsBody(Vector position) {
        setup(position, new Vector(), new Vector(), 1);
    }

    /**
     * Physics body constructor.
     * Defaults position, velocity, and acceleration vectors to 0.
     * Defaults mass to 1.
     */
    protected PhysicsBody() {
        setup(new Vector(), new Vector(), new Vector(), 1);
    }

    /**
     * Method to be used by all constructors
     * @see #PhysicsBody()
     * @param position Initial position
     * @param velocity Initial velocity
     * @param acceleration Initial acceleration
     * @param mass Mass of this body (base unit is 1).
     */
    private void setup(Vector position, Vector velocity, Vector acceleration, double mass) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = 1;
    }

    /**
     * Integrates acceleration into velocity and velocity into position.
     * (Uses Euler integration)
     * @param deltaT Time since last time step
     */
    public void timeStep(double deltaT) {
        velocity.add(Vector.mult(acceleration, deltaT));
        position.add(Vector.mult(velocity, deltaT));
    }

    /**
     * Applies a velocity to this body.
     * Does not accurately reflect the physical world, use {@link #applyForce(Vector)} instead
     * @param deltaV
     */
    public void applyVelocity(Vector deltaV) {
        velocity.add(deltaV);
    }

    /**
     * Applies a force to this body.
     * The mass of this body will be used to calculate resulting acceleration.
     * @param force Force applied on this body
     */
    public void applyForce(Vector force) {
        // F = M * A || A = F / M || A = F * (1 / M)
        acceleration.add(Vector.mult(force, 1 / mass));
    }

    public Vector getPosition() {
        return position;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
