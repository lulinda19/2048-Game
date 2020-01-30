/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	public static JButton undo;
	public static JFrame frame;
	public static JFrame frame3;
	public static JFrame frame4;
	public static JTextField textField;
    public void run() {
    	final JLabel status = new JLabel("Running...");
    	final GameCourt court = new GameCourt(status);
    	
        // Top-level frame in which game components live
        frame = new JFrame("2048");
        frame.setLocation(300, 300);
        
        // High score frame
        final JFrame frame2 = new JFrame("HighScores");
        frame2.setLocation(300, 300);
        final HighScores scores = new HighScores(status);
        
        // Continue button
        JButton continueToGame = new JButton("Continue to Game");
        continueToGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                frame2.setVisible(false);
            }
        });
        
        // Lose screen frame
        frame3 = new JFrame("You Lose!");
        frame3.setLocation(300, 300);
        final LoseScreen lose = new LoseScreen(status);
        frame3.add(lose, BorderLayout.CENTER);
        
        // Play again button
        JButton playAgain = new JButton("Play Again");
        playAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.reset();
                frame3.setVisible(false);
                frame.setVisible(true);
            }
        });
        frame3.add(playAgain, BorderLayout.SOUTH);
        
        frame2.add(scores, BorderLayout.CENTER);
        frame2.add(continueToGame, BorderLayout.SOUTH);

        // Main playing area
        frame.add(court, BorderLayout.CENTER);

        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);

        // Undo button
        undo = new JButton("Undo");
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.undo();
                court.requestFocusInWindow();
                undo.setEnabled(!court.cannotUndo);
            }
        });
        undo.setEnabled(false);
        court.setFocusable(true);
        control_panel.add(undo);

        // Win screen frame
        frame4 = new JFrame("You Win!");
        frame4.setLocation(300, 300);
        
        WinScreen win = new WinScreen(status);
        textField = new JTextField();
        JButton done = new JButton("Done");
        done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	win.write();
                court.reset();
                scores.reread();
                frame4.setVisible(false);
                frame2.setVisible(true);
            }
        });
        
        frame4.add(win, BorderLayout.NORTH);
        frame4.add(textField, BorderLayout.CENTER);
        frame4.add(done, BorderLayout.SOUTH);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame2.pack();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        frame3.pack();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(false);
        frame4.pack();
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(false);

        // Start game
        court.reset();
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}