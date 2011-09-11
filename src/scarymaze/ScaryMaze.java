/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scarymaze;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author avh4
 */
public class ScaryMaze extends JComponent implements MouseMotionListener {

    private Robot r;
    private BufferedImage image;
    private Color BRIGHT_PINK = new Color(255, 60, 140);
    private Color GREEN = new Color(0, 255, 0);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        JFrame window = new JFrame("Maze Game");
        ScaryMaze game = new ScaryMaze();
        game.addMouseMotionListener(game);
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null); // Center on the screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public ScaryMaze() throws AWTException {
        r = new Robot();
        r.mouseMove(800, 600);

        image = new BufferedImage(getPreferredSize().width, getPreferredSize().height, BufferedImage.TYPE_INT_ARGB_PRE);
        Graphics g = image.getGraphics();
        
        g.setColor(BRIGHT_PINK);
        g.fillRect(0, 0, 1000, 800);

        g.setColor(Color.BLUE);
        g.fillRect(200, 300, 200, 300);
        
        g.setColor(GREEN);
        g.fillOval(300, 400, 100, 100);
        
        g.dispose();

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        mouseMoved(me);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        int rgb = image.getRGB(me.getX(), me.getY());

        if (rgb == BRIGHT_PINK.getRGB()) {
            System.out.println("Wall");
        } else if (rgb == GREEN.getRGB()) {
            System.out.println("Exit");
        }
    }
}
