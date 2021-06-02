package src.physics;

import java.awt.Graphics;

public class Ball extends PhysicsBody {
    private double radius;
    private final static double defaultRadius = 10;

    public Ball(Vector position, double mass, double radius) {
        super(position, mass);
        this.radius = radius;
    }

    public Ball(Vector position, double radius) {
        super(position);
        this.radius = radius;
    }

    public Ball(double radius) {
        super();
        this.radius = radius;
    }

    public Ball(Vector position) {
        super(position);
        this.radius = defaultRadius;
    }

    public Ball() {
        super();
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
