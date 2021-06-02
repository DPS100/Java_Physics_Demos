package src;
import javax.swing.*;

public class Main extends JFrame {

    static Scene panel;

    public static void main(String[] args) {
        Main m = new Main("Physics Demos");
        new Thread(panel).start();
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
        panel = new Scene();
        target.add(panel);

        target.pack();
        target.setVisible(true);
    }
    
}
