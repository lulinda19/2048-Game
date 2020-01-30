import java.awt.*;
import javax.swing.*;
import java.io.*;

// class containing all the main logic for the win screen, including writing new high scores
@SuppressWarnings("serial")
public class WinScreen extends JPanel {

    // the state of the game logic
    private JLabel status; // Current status text, i.e. "Running..."
    private FileWriter writer;

    // Game constants
    public static final int COURT_WIDTH = 250;
    public static final int COURT_HEIGHT = 100;

    public WinScreen(JLabel status) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        this.status = status;
        repaint();
    }

    // writes all the scores to the scores file
    public void write() {
    	String text = Game.textField.getText();
    	
    	if (text == null) {
    		text = "Name was not entered";
    	}
    	
    	Score newScore = new Score(GameArray.finalScore, text);
    	HighScores.scores.add(newScore);
    	
    	try {
    		writer = new FileWriter("files/scores.txt");
    		
    		while (!HighScores.scores.isEmpty()) {
    			Score s = HighScores.scores.remove(0);
    			
    			if (HighScores.scores.isEmpty()) {
    				writer.write(s.getName() + "\n" + s.getScore());
    			} else {
    				writer.write(s.getName() + "\n" + s.getScore() + "\n");
    			}
    		}
    		
    		writer.close();
    	} catch (IOException e){
    		System.out.println("Error writing to file");
    	}
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("YOU WIN!!", 100, 20);
        g.drawString("Please enter your name below", 40, 55);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}