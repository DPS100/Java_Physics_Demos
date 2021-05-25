package src;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class VisualPanel extends JPanel {

    protected int width;
    protected int height;

    public VisualPanel(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    public VisualPanel() {
        super();
        this.width = 100;
        this.height = 100;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Hello, World!", 20, 20);
    }
}
