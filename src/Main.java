package src;
import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        Main m = new Main("Testabooey");
    }

    /** 
     * @param name Display name
     */
    public Main(String name) {
        super(name);
        setup(this);
    }

    /**
     * Default constructor
     */
    public Main() {
        super();
        setup(this);
    }

    private void setup(JFrame target) {
        target.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        target.add(new VisualPanel());

        target.pack();
        target.setVisible(true);
    }
    
}
