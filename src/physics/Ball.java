package src.physics;

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

    public Ball() {
        super();
        this.radius = 10;
    }

    public double getRadius() {
        return radius;
    }


}
