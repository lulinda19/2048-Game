import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

//class containing all the main logic for the win screen, including reading in high scores
@SuppressWarnings("serial")
public class HighScores extends JPanel {

    // the state of the game logic
	public static int value;
    private Scanner read;
    private JLabel status; // Current status text, i.e. "Running..."
    private String first;
    private String second;
    private String third;
    private String fourth;
    private String fifth;
    public static ArrayList<Score> scores;

    // Game constants
    public static final int COURT_WIDTH = 275;
    public static final int COURT_HEIGHT = 420;

    public HighScores(JLabel status) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        this.status = status;

        first = "";
        second = "";
        third = "";
        fourth = "";
        fifth = "";
        
        scores = new ArrayList<Score>();
        try {
        	FileReader fileReader = new FileReader("files/scores.txt");
        	read = new Scanner(fileReader);
            
            while (read.hasNext()) {
            	String name = read.next();
            	int score = Integer.parseInt(read.next());
            	Score s = new Score(score, name);
            	scores.add(s);
            }
            Collections.sort(scores);

            if (scores.size() >= 1) {
            	first = "1. " + scores.get(0).getName() + " Score: " + scores.get(0).getScore();
            }
            
            if (scores.size() >= 2) {
            	second = "2. " + scores.get(1).getName() + " Score: " + scores.get(1).getScore();
            }
            
            if (scores.size() >= 3) {
            	third = "3. " + scores.get(2).getName() + " Score: " + scores.get(2).getScore();
            }
            
            if (scores.size() >= 4) {
            	fourth = "4. " + scores.get(3).getName() + " Score: " + scores.get(3).getScore();
            }
            
            if (scores.size() >= 5) {
            	fifth = "5. " + scores.get(4).getName() + " Score: " + scores.get(4).getScore();
            }
            
            fileReader.close();
        } catch (IOException e){
        	System.out.println("Error reading file!");
        }
        
        
        repaint();
    }
    
    // reads file again after new scores have been added
    public void reread() {
    	first = "";
        second = "";
        third = "";
        fourth = "";
        fifth = "";
        
        scores = new ArrayList<Score>();
        try {
        	FileReader fileReader = new FileReader("files/scores.txt");
        	read = new Scanner(fileReader);
            
            while (read.hasNext()) {
            	String name = read.next();
            	int score = Integer.parseInt(read.next());
            	Score s = new Score(score, name);
            	scores.add(s);
            }
            Collections.sort(scores);

            if (scores.size() >= 1) {
            	first = "1. " + scores.get(0).getName() + " Score: " + scores.get(0).getScore();
            }
            
            if (scores.size() >= 2) {
            	second = "2. " + scores.get(1).getName() + " Score: " + scores.get(1).getScore();
            }
            
            if (scores.size() >= 3) {
            	third = "3. " + scores.get(2).getName() + " Score: " + scores.get(2).getScore();
            }
            
            if (scores.size() >= 4) {
            	fourth = "4. " + scores.get(3).getName() + " Score: " + scores.get(3).getScore();
            }
            
            if (scores.size() >= 5) {
            	fifth = "5. " + scores.get(4).getName() + " Score: " + scores.get(4).getScore();
            }
        } catch (IOException e){
        	System.out.println("Error reading file!");
        }
        
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(first, 10, 20);
        g.drawString(second, 10, 45);
        g.drawString(third, 10, 70);
        g.drawString(fourth, 10, 95);
        g.drawString(fifth, 10, 120);
        g.drawString("Instructions:", 10, 145);
        g.drawString("The goal is to create 2048 by", 10, 170);
        g.drawString("combining tiles. Two tiles can", 10, 195);
        g.drawString("be combined if they are the same", 10, 220);
        g.drawString("value and they are adjacent to", 10, 245);
        g.drawString("one another.", 10, 270);
        g.drawString("Moves:", 10, 295);
        g.drawString("Up Arrow: combine/move upward", 10, 320);
        g.drawString("Down Arrow: combine/move downward", 10, 345);
        g.drawString("Left Arrow: combine/move leftward", 10, 370);
        g.drawString("Right Arrow: combine/move rightward", 10, 395);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}