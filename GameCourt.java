/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact with one another. Take
 * time to understand how the timer interacts with the different methods and how it repaints the GUI
 * on every tick().
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

    // the state of the game logic
    private GameArray array;
    public boolean cannotUndo;
    public boolean winner;
    public boolean gameOver;
    private JLabel status; // Current status text, i.e. "Running..."

    // Game constants
    public static final int COURT_WIDTH = 250;
    public static final int COURT_HEIGHT = 275;

    public GameCourt(JLabel status) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        // This key listener modifies the game array after each move and then repaints the screen
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    array.leftCombine();
                    array.updateGameOver();
                    array.updateWinner();
                    winner = array.isWinner();
                    gameOver = array.isGameOver();
                    cannotUndo = array.cannotUndo();
                    
                    if (!cannotUndo) {
                    	Game.undo.setEnabled(true);
                    } else {
                    	Game.undo.setEnabled(false);
                    }
                    
                    if (gameOver) {
                    	Game.frame3.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    if (winner) {
                    	Game.frame4.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    setFocusable(true);
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    array.rightCombine();
                    array.updateGameOver();
                    array.updateWinner();
                    winner = array.isWinner();
                    gameOver = array.isGameOver();
                    cannotUndo = array.cannotUndo();
                    
                    if (!cannotUndo) {
                    	Game.undo.setEnabled(true);
                    } else {
                    	Game.undo.setEnabled(false);
                    }

                    if (gameOver) {
                    	Game.frame3.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    if (winner) {
                    	Game.frame4.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    setFocusable(true);
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    array.downCombine();
                    array.updateGameOver();
                    array.updateWinner();
                    winner = array.isWinner();
                    gameOver = array.isGameOver();
                    cannotUndo = array.cannotUndo();
                    
                    if (!cannotUndo) {
                    	Game.undo.setEnabled(true);
                    } else {
                    	Game.undo.setEnabled(false);
                    }

                    if (gameOver) {
                    	Game.frame3.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    if (winner) {
                    	Game.frame4.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    setFocusable(true);
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    array.upCombine();
                    array.updateGameOver();
                    array.updateWinner();
                    winner = array.isWinner();
                    gameOver = array.isGameOver();
                    cannotUndo = array.cannotUndo();
                    
                    if (!cannotUndo) {
                    	Game.undo.setEnabled(true);
                    } else {
                    	Game.undo.setEnabled(false);
                    }

                    if (gameOver) {
                    	Game.frame3.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    if (winner) {
                    	Game.frame4.setVisible(true);
                    	Game.frame.setVisible(false);
                    }
                    
                    setFocusable(true);
                    repaint();
                }
            }
        });

        this.status = status;
    }

    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
        array = new GameArray();
        array.start();

        winner = false;
        gameOver = false;
        status.setText("Running...");

        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }
    
    // undo method called when the undo button is pressed
    public void undo() {
    	if (!cannotUndo) {
    		array.undo();
    		cannotUndo = array.cannotUndo();
    		repaint();
    		setFocusable(true);
    	}
    	requestFocusInWindow();
    }
    
    public boolean cannotUndo() {
    	cannotUndo = array.cannotUndo();
    	return cannotUndo;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        array.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}