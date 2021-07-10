package src.physics;

import java.awt.Graphics;

import src.Scene;

public abstract class PhysicsBody {
    protected Vector position;
    protected Vector velocity;
    protected Vector acceleration;
    protected double mass;
    protected Scene owner;

    /**
     * Physics body constructor.
     * Defaults velocity and acceleration vectors to 0.
     * @param position Initial postition
     * @param mass Mass of this body (base unit is 1).
     * @param owner Scene that this object belongs to
     */
    protected PhysicsBody(Vector position, double mass, Scene owner) {
        setup(position, new Vector(), new Vector(), mass, owner);
    }

    /**
     * Physics body constructor.
     * Defaults position, velocity, and acceleration vectors to 0.
     * @param mass Mass of this body (base unit is 1).
     * @param owner Scene that this object belongs to
     */
    protected PhysicsBody(double mass, Scene owner) {
        setup(new Vector(), new Vector(), new Vector(), mass, owner);
    }

    /**
     * Physics body constructor.
     * Defaults velocity and acceleration vectors to 0.
     * Defaults mass to 1.
     * @param position Initial position
     * @param owner Scene that this object belongs to
     */
    protected PhysicsBody(Vector position, Scene owner) {
        setup(position, new Vector(), new Vector(), 1, owner);
    }

    /**
     * Physics body constructor.
     * Defaults position, velocity, and acceleration vectors to 0.
     * Defaults mass to 1.
     * @param owner Scene that this object belongs to
     */
    protected PhysicsBody(Scene owner) {
        setup(new Vector(), new Vector(), new Vector(), 1, owner);
    }

    /**
     * Method to be used by all constructors
     * @see #PhysicsBody()
     * @param position Initial position
     * @param velocity Initial velocity
     * @param acceleration Initial acceleration
     * @param mass Mass of this body (base unit is 1).
     * @param owner Scene that this object belongs to
     */
    private void setup(Vector position, Vector velocity, Vector acceleration, double mass, Scene owner) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = 1;
        this.owner = owner;
    }

    /**
     * Integrates acceleration into velocity and velocity into position.
     * (Uses Euler integration)
     * @param deltaT Time since last time step
     */
    public void timeStep(double deltaT) {
        Vector deltaV = Vector.mult(acceleration, deltaT); // TODO limit velocity (relitavistic speeds)
        velocity.add(deltaV);
        
        Vector deltaP = Vector.mult(velocity, deltaT); // TODO limit position (edge detection)
        position.add(deltaP);
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

    /**
     * Draws this body to graphics object.
     * Should NOT call {@link #timeStep(double)}, instead caller should call both methods seperately
     * @param g Graphics object
     */
    public abstract void drawBody(Graphics g);

    /**
     * Uses a time step, then draws this body.
     * @param g Graphics object
     * @param deltaT Time since last time step
     */
    public void drawBodyUsingTime(Graphics g, double deltaT) {
        timeStep(deltaT);
        drawBody(g);
    }
}
