package src;

import javax.swing.JPanel;

import src.physics.*;

import java.awt.Dimension;
import java.awt.Graphics;

import java.time.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Scene extends JPanel implements Runnable {

    protected int width;
    protected int height;
    private static final int initialWidth = 500;
    private static final int initialHeight = 500;
    Ball body;
    AtomicInteger tickTimeNano = new AtomicInteger(-1);

    /**
     * Visual panel constructor.
     * @param width Initial width of panel (Screen size: pixels)
     * @param height Initial height of panel (Screen size: pixels)
     */
    public Scene(int width, int height) {
        super();
        setup(width, height);
    }

    /**
     * Visual panel constructor.
     * Initializes width and height to 500 x 500
     */
    public Scene() {
        super();
        setup(initialWidth, initialHeight);
    }

    /**
     * Method to be used by all constructors
     * @see #VisualPanel()
     * @param width Initial width of panel (Screen size: pixels)
     * @param height Initial height of panel (Screen size: pixels)
     */
    private void setup(int width, int height) {
        this.width = width;
        this.height = height;
        body = new Ball(50);
        body.applyVelocity(new Vector(16, 16));
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        physicsStep(g);
    }

    @Override
    public void run() {
        runLoop();
    }

    /**
     * UNFINISHED!
     * Advances all physics objects belonging to this panel.
     * Should only be called in {@link #paintComponent(Graphics)}
     * @param g
     */
    private void physicsStep(Graphics g) {
        // TODO advance all physics bodies in this panel (Currently only ball advances)
        int tickTimeInt = tickTimeNano.get(); // Tick time in nanoseconds

        if(body != null && tickTimeInt != -1) {
            double tickTime = tickTimeInt / Constants.nanosPerSecond;
            body.timeStep(tickTime);
            System.out.println(body.getPosition().toString());
            g.drawChars(new String("TPS " + (tickTime * Constants.ticksPerSecond * Constants.ticksPerSecond)).toCharArray(), 0, 8, 400, 10);
            int x = (int)Math.round(body.getPosition().getX());
            int y = (int)Math.round(body.getPosition().getY());
            g.fillOval(x, y, (int)body.getRadius(), (int)body.getRadius());
        } else {
            System.out.println("Null body or tickTime");
        }
    }

    /**
     * Determines the time elapsed between {@link #repaint()} methods.
     * Should only be used called in {@link #run()}.
     * Thread-safety untested.
     */
    private void runLoop() {
        LocalTime t0 = LocalTime.now();
        LocalTime t1;
        while(true) {
            t1 = LocalTime.now();
            Duration d = Duration.between(t0, t1);
            double tickTime = d.getNano() / Constants.nanosPerSecond + d.getSeconds();
            if(tickTime < Constants.secondsPerTick) {
                try {
                    long sleepTime = (long)((Constants.secondsPerTick - tickTime) * Constants.millisPerSecond);
                    Thread.sleep(sleepTime);
                    t1 = LocalTime.now();
                    d = Duration.between(t0, t1);
                    tickTime = d.getNano() / Constants.nanosPerSecond + d.getSeconds();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            tickTimeNano.set((int)(tickTime * Constants.nanosPerSecond));
            repaint();
            t0 = LocalTime.now();
        }
    }
}
