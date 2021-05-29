package src.physics;

public class Vector {
    private double x;
    private double y;

    /**
     * Copy constructor
     * @param target Vector to duplicate
     */
    public Vector(Vector target) {
        set(target.getX(), target.getY());
    } 

    /**
     * @param x Starting x position
     * @param y Starting y position
     */
    public Vector(double x, double y) {
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
     * Adds coordinates using a set of values.
     * Non-binary operation
     * @param deltaX Change in x
     * @param deltaY Change in y
     * @return Reference to this object
     */
    public Vector add(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
        return this;
    }

    /**
     * Adds coordinates using another set of coordinates.
     * Non-binary operation
     * @param deltaV Change in x and y
     * @return Reference to this object
     */
    public Vector add(Vector deltaV) {
        x += deltaV.x;
        y += deltaV.y;
        return this;
    }

    /**
     * Sums two vectors and returns the result.
     * True binary operation.
     * @param v1 First vector
     * @param v2 Second vector
     * @return Resulting sum
     */
    public static Vector add(Vector v1, Vector v2) {
        // Binary operator - Treats both arguments equally
        return new Vector().add(v1).add(v2);
    }

    /**
     * Multiplies this vector by a factor
     * @param factor
     * @return Reference to this object
     */
    public Vector mult(double factor) {
        x *= factor;
        y *= factor;
        return this;
    }

    /**
     * Multiplies a vector by a factor and returns the result.
     * True binary operation.
     * @param v Vector to multiply
     * @param factor Factor to multiply by
     * @return Resulting vector
     */
    public static Vector mult(Vector v, double factor) {
        return new Vector(v).mult(factor);
    }

    /**
     * Changes the coordinates of this vector
     * @param x 
     * @param y
     * @return Reference to this object
     */
    public Vector set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Checks if this vector is equal to another vector
     * @param v Vector to compare to
     * @return true if equal, false otherwise
     */
    public boolean equals(Vector v) {
        if(this.x == v.x && this.y == v.y) {
            return true;
        } else {
            return false;
        }
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return new String("x(" + x + ") y(" + y + ")");
    }
}
