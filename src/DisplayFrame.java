import javax.swing.JFrame;

public class DisplayFrame extends JFrame {
    private DisplayPanel panel = new DisplayPanel();
    public DisplayFrame() {
        this.setTitle("GravitySim");
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.add(panel);

        this.setVisible(true);
    }

    public int getWidth() {
        return panel.getWidth();
    }

    public int getHeight() {
        return panel.getHeight();
    }
}