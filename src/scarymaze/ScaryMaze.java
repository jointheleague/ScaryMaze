/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scarymaze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author avh4
 */
public class ScaryMaze extends JComponent {
    
    private Color BRIGHT_PINK = new Color(255, 60, 140);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Maze Game");
        window.add(new ScaryMaze());
        window.pack();
        window.setLocationRelativeTo(null); // Center on the screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        g.setColor(BRIGHT_PINK);
        g.fillRect(0, 0, 1000, 800);
        
        
        
    }
    
    
    
    
}
