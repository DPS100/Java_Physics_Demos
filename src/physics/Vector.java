package src.physics;

public class Vector {
    private float x;
    private float y; 

    /**
     * 
     * @param x Starting x position
     * @param y Starting y position
     */
    public Vector(float x, float y) {
        set(x, y);
    }

    /**
     * Default Coordinates constructor.
     * Initializes x & y to 0.
     */
    public Vector() {
        set(0, 0);
    }

    /**
     * Manipulates coordinates using a set of values
     * @param deltaX Instantaneous change in x
     * @param deltaY Instantaneous change in y
     * @return Reference to this Coordinates object
     */
    public Vector manip(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
        return this;
    }

    /**
     * Manipulates coordinates using another set of coordinates
     * @param deltaC Instantaneous change in x and y
     * @return Reference to this Coordinates object
     */
    public Vector manip(Vector deltaV) {
        x += deltaV.x;
        y += deltaV.y;
        return this;
    }

    /**
     * Sums two vectors and returns the result
     * @param v1 First vector
     * @param v2 Second vector
     * @return Resulting sum
     */
    public static Vector add(Vector v1, Vector v2) {
        return new Vector().manip(v1).manip(v2);
    }

    /**
     * @param x 
     * @param y
     * @return
     */
    public Vector set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
