import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Ball implements ActionListener {
    Timer clock = new Timer(10, this);
    Graphics brush;

    final double GRAVITY = 9.8;
    final int MIN_X_POS = 0;
    final int MAX_X_POS = 454;
    final int MIN_Y_POS = 0;
    final int MAX_Y_POS = 431;

    int xPos = 30;
    int yPos = 10;
    double xVel = 0;
    double yVel = 0;
    double time = 0;
    double timeControl = 0.0002;
    double velControlFactor = 0.8;

    public Ball(Graphics g) {
        brush = g;
        clock.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        brush.fillOval(xPos, yPos, 30, 30);

        yVel += GRAVITY * time;
        yPos += yVel;
        if (time > 0) this.control();
        
        time += timeControl;
    }

    public void control() {
        if (yPos + yVel > MAX_Y_POS) {
            yVel *= -1 * velControlFactor;
        }
        if (yPos > MAX_Y_POS - 3 && (yVel > -0.3 && yVel < 0.3)) {
            clock.stop();
            yVel = 0;
            yPos = MAX_Y_POS;
            time = 0;
        } 
    }
}
