import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class DisplayPanel extends JPanel implements ActionListener {
    Random rand = new Random();
    Timer clock = new Timer(10, this);

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
    
    String sTime;
    String sVelocity;
    String sYPos;

    public DisplayPanel() {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        clock.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(xPos, yPos, 30, 30);
        sTime = String.format("%f", time);
        sVelocity = String.format("%f", yVel);
        sYPos = "" + yPos;

        g.drawString("Time: " + sTime, 50, 85);
        g.drawString("Velocity: " + sVelocity, 50, 110);
        g.drawString("YPos: " + sYPos, 50, 135);
        g.drawString("GravitySim v0.2.0-beta", 50, 60);
        g.drawLine(0, 30, 500, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        yVel += GRAVITY * time;
        yPos += yVel;
        if (time > 0) this.control();
        
        time += timeControl;
        this.repaint();
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