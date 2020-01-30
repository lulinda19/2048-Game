import java.awt.*;
import javax.swing.*;

// class containing all main logic and features of the lose screen
@SuppressWarnings("serial")
public class LoseScreen extends JPanel {

    // the state of the game logic
    private JLabel status; // Current status text, i.e. "Running..."`

    // Game constants
    public static final int COURT_WIDTH = 250;
    public static final int COURT_HEIGHT = 250;

    public LoseScreen(JLabel status) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        this.status = status;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("YOU LOSE!!", 100, 120);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}