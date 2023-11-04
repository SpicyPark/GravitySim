import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class DisplayPanel extends JPanel implements ActionListener {
    Random rand = new Random();
    int xPos = 250;
    int yPos = 10;
    double velocity = 0;
    final double GRAVITY = 9.8;
    final int MIN_Y_POS = 430;
    double time = 0.01;
    double velControlFactor = 1;
    String sTime;
    String sVelocity;
    boolean upTrajectory = false;

    public DisplayPanel() {
        super();
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paintComponent(Graphics b) {
        super.paintComponent(b);
        b.fillOval(xPos, yPos, 30, 30);
        sTime = String.format("%f", time);
        sVelocity = String.format("%f", velocity);

        b.drawString(sTime, 50, 85);
        b.drawString(sVelocity, 50, 110);
        b.drawString("WELCOME TO GRAVITYSIM", 50, 60);
        b.drawLine(0, 30, 500, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (yPos + velocity > MIN_Y_POS) {
            yPos = MIN_Y_POS - 5;
            System.out.println("OLD " + velocity);
            // velocity = 0 - velocity;
            System.out.println("NEW " + velocity);
            time = 0;
            upTrajectory = true;
        }
        else {
            yPos += velocity;
            if (time == 0) {
                velocity = 0;
            }
            else time += 0.03;
        }

        // if (velocity > 0) upTrajectory = false;
        // if (!upTrajectory) velocity = GRAVITY * (time);
        // else if (upTrajectory) velocity += velControlFactor * GRAVITY * time;
        velocity = GRAVITY * (time);

        repaint();
    }
}