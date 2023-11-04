import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        this.setTitle("GravitySim");
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        DisplayPanel panel = new DisplayPanel();
        this.add(panel);
        Timer clock = new Timer(30, panel);
        clock.start();

        this.setVisible(true);
    }
}