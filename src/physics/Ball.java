package src.physics;

import java.awt.Graphics;

import src.Scene;

public class Ball extends PhysicsBody {
    private double radius;
    private final static double defaultRadius = 10;

    public Ball(Vector position, double mass, double radius, Scene owner) {
        super(position, mass, owner);
        this.radius = radius;
    }

    public Ball(Vector position, double radius, Scene owner) {
        super(position, owner);
        this.radius = radius;
    }

    public Ball(double radius, Scene owner) {
        super(owner);
        this.radius = radius;
    }

    public Ball(Vector position, Scene owner) {
        super(position, owner);
        this.radius = defaultRadius;
    }

    public Ball(Scene owner) {
        super(owner);
        this.radius = 10;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void drawBody(Graphics g) {
        int x = (int)Math.round(this.getPosition().getX());
        int y = (int)Math.round(this.getPosition().getY());
        g.fillOval(x, y, (int)this.getRadius(), (int)this.getRadius());        
    }
}
