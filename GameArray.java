import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class GameArray {
	private Tile[][] array;
	private boolean gameOver;
	private boolean winner;
	private LinkedList<int[][]> undoList;
	private LinkedList<Integer> pastScores;
	private int score;
	public static int finalScore;
	
	public GameArray() {
		array = new Tile[4][4];
		undoList = new LinkedList<int[][]>();
		pastScores = new LinkedList<Integer>();
		score = 0;
		gameOver = false;
		winner = false;
		finalScore = 0;
	}
	
	// Sets all the values in game array
	public void setValues(int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9, int c10, int c11,
			int c12, int c13, int c14, int c15, int c16) {
		array[0][0] = new Tile();
		array[0][0].set(c1);
		
		array[0][1] = new Tile();
		array[0][1].set(c2);
		
		array[0][2] = new Tile();
		array[0][2].set(c3);
		
		array[0][3] = new Tile();
		array[0][3].set(c4);
		
		array[1][0] = new Tile();
		array[1][0].set(c5);
		
		array[1][1] = new Tile();
		array[1][1].set(c6);
		
		array[1][2] = new Tile();
		array[1][2].set(c7);
		
		array[1][3] = new Tile();
		array[1][3].set(c8);
		
		array[2][0] = new Tile();
		array[2][0].set(c9);
		
		array[2][1] = new Tile();
		array[2][1].set(c10);
		
		array[2][2] = new Tile();
		array[2][2].set(c11);
		
		array[2][3] = new Tile();
		array[2][3].set(c12);
		
		array[3][0] = new Tile();
		array[3][0].set(c13);
		
		array[3][1] = new Tile();
		array[3][1].set(c14);
		
		array[3][2] = new Tile();
		array[3][2].set(c15);
		
		array[3][3] = new Tile();
		array[3][3].set(c16);
	}
	
	//only used for testing
	//inputs must be within bounds
	public int getValueAt(int i, int j) {
		return array[i][j].getValue();
	}
	
	// the starting array for the game
	public void start() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = new Tile();
				array[i][j].set(0);
			}
		}
		int random1 = (int) Math.floor(4 * Math.random());
		int random2 = (int) Math.floor(4 * Math.random());
		array[random1][random2].set(2);
		
		//only used to quickly get to win screen
		//array[0][0].set(1024);
		//array[0][1].set(1024);
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public boolean isWinner() {
		return winner;
	}
	
	public boolean cannotUndo() {
		return undoList.isEmpty();
	}
	
	public void updateGameOver() {
		boolean fullCourt = true;
		for (int i = 0; i < 4 && fullCourt; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j].getValue() == 0) {
					fullCourt = false;
				}
			}
		}
		
		boolean cannotCombine = true;
		for (int i = 0; i < 4 && cannotCombine; i++) {
			for (int j = 0; j < 4; j++) {
				if (i-1 >= 0) {
					if (array[i-1][j].getValue() == array[i][j].getValue()) {
						cannotCombine = false;
					}
				}
				
				if (i+1 < 4) {
					if (array[i+1][j].getValue() == array[i][j].getValue()) {
						cannotCombine = false;
					}
				}
				
				if (j-1 >= 0) {
					if (array[i][j-1].getValue() == array[i][j].getValue()) {
						cannotCombine = false;
					}
				}
				
				if (j+1 < 4) {
					if (array[i][j+1].getValue() == array[i][j].getValue()) {
						cannotCombine = false;
					}
				}
			}
		}
		
		this.gameOver = fullCourt && cannotCombine;
	}
	
	public void updateWinner() {
		boolean contains2048 = false;
		
		for (int i = 0; i < 4 && !contains2048; i++) {
			for (int j = 0; j < 4 && !contains2048; j++) {
				if (array[i][j].is2048()) {
					contains2048 = true;
				}
			}
		}
		
		if (contains2048) {
			finalScore = score;
		}
		
		winner = contains2048;
	}
	
	public void down() {
		for (int k = 0; k < 4; k++) {
			for (int j = 0; j < 4; j++) {
				for (int i = 3; i > 0; i--) {
					if (array[j][i].getValue() == 0) {
						if (array[j][i-1].getValue() != 0) {
							array[j][i].set(array[j][i-1].getValue());
							array[j][i-1].reset();
						}
					}
				}
			}
		}
	}
	
	public void up() {
		for (int k = 0; k < 4; k++) {
			for (int j = 0; j < 4; j++) {
				for (int i = 3; i > 0; i--) {
					if (array[j][i].getValue() != 0) {
						if (array[j][i-1].getValue() == 0) {
							array[j][i-1].set(array[j][i].getValue());
							array[j][i].reset();
						}
					}
				}
			}
		}
	}
	
	public void right() {
		for (int k = 0; k < 4; k++) {
			for (int j = 0; j < 4; j++) {
				for (int i = 3; i > 0; i--) {
					if (array[i][j].getValue() == 0) {
						if (array[i-1][j].getValue() != 0) {
							array[i][j].set(array[i-1][j].getValue());
							array[i-1][j].reset();
						}
					}
				}
			}
		}
	}
	
	public void left() {
		for (int k = 0; k < 4; k++) {
			for (int j = 0; j < 4; j++) {
				for (int i = 0; i < 3; i++) {
					if (array[i][j].getValue() == 0) {
						if (array[i+1][j].getValue() != 0) {
							array[i][j].set(array[i+1][j].getValue());
							array[i+1][j].reset();
						}
					}
				}
			}
		}
	}
	
	private void addNewTile() {
		LinkedList<Integer> xcoordinates = new LinkedList<Integer>();
		LinkedList<Integer> ycoordinates = new LinkedList<Integer>();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (array[i][j].getValue() == 0) {
					xcoordinates.add(i);
					ycoordinates.add(j);
				}
			}
		}
		
		int random = (int) Math.floor(xcoordinates.size() * Math.random());
		array[xcoordinates.get(random)][ycoordinates.get(random)].createNew();
	}
	
	public void downCombine() {
		int c1 = array[0][0].getValue();
		int c2 = array[0][1].getValue();
		int c3 = array[0][2].getValue();
		int c4 = array[0][3].getValue();
		int c5 = array[1][0].getValue();
		int c6 = array[1][1].getValue();
		int c7 = array[1][2].getValue();
		int c8 = array[1][3].getValue();
		int c9 = array[2][0].getValue();
		int c10 = array[2][1].getValue();
		int c11 = array[2][2].getValue();
		int c12 = array[2][3].getValue();
		int c13 = array[3][0].getValue();
		int c14 = array[3][1].getValue();
		int c15 = array[3][2].getValue();
		int c16 = array[3][3].getValue();
		int pscore = this.score;
		
		this.down();
		
		for (int i = 0; i < array.length; i++) {
			if (array[i][0].getValue() == array[i][1].getValue() && array[i][2].getValue() == array[i][3].getValue()
					&& array[i][0].getValue() != 0 && array[i][2].getValue() != 0) {
				array[i][1].doubleValue();
				score = score + array[i][1].getValue();
				array[i][0].reset();
				array[i][3].doubleValue();
				score = score + array[i][3].getValue();
				array[i][2].reset();
			} else if (array[i][2].getValue() == array[i][3].getValue() && array[i][2].getValue() != 0) {	
				array[i][3].doubleValue();
				score = score + array[i][3].getValue();
				array[i][2].reset();
			} else if (array[i][1].getValue() == array[i][2].getValue() && array[i][2].getValue() != 0) {
				array[i][2].doubleValue();
				score = score + array[i][2].getValue();
				array[i][1].reset();
			} else if (array[i][0].getValue() == array[i][1].getValue() && array[i][1].getValue() != 0) {
				array[i][1].doubleValue();
				score = score + array[i][1].getValue();
				array[i][0].reset();
			}
		}
		this.down();
		
		updateGameOver();
		updateWinner();
		
		boolean b = c1 == array[0][0].getValue() && c2 == array[0][1].getValue() && c3 == array[0][2].getValue() &&
				c4 == array[0][3].getValue() && c5 == array[1][0].getValue() && c6 == array[1][1].getValue() && 
				c7 == array[1][2].getValue() && c8 == array[1][3].getValue() && c9 == array[2][0].getValue() && 
				c10 == array[2][1].getValue() && c11 == array[2][2].getValue() && c12 == array[2][3].getValue() && 
				c13 == array[3][0].getValue() && c14 == array[3][1].getValue() && c15 == array[3][2].getValue() && 
				c16 == array[3][3].getValue();
		
		if (!this.gameOver && !winner && !b) {
			this.addNewTile();
			addToUndoList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, pscore);
		}
	}
	
	public void upCombine() {
		int c1 = array[0][0].getValue();
		int c2 = array[0][1].getValue();
		int c3 = array[0][2].getValue();
		int c4 = array[0][3].getValue();
		int c5 = array[1][0].getValue();
		int c6 = array[1][1].getValue();
		int c7 = array[1][2].getValue();
		int c8 = array[1][3].getValue();
		int c9 = array[2][0].getValue();
		int c10 = array[2][1].getValue();
		int c11 = array[2][2].getValue();
		int c12 = array[2][3].getValue();
		int c13 = array[3][0].getValue();
		int c14 = array[3][1].getValue();
		int c15 = array[3][2].getValue();
		int c16 = array[3][3].getValue();
		int pscore = this.score;
		
		this.up();
		
		for (int i = 0; i < array.length; i++) {
			if (array[i][0].getValue() == array[i][1].getValue() && array[i][2].getValue() == array[i][3].getValue()
					&& array[i][0].getValue() != 0 && array[i][2].getValue() != 0) {
				array[i][0].doubleValue();
				score = score + array[i][0].getValue();
				array[i][1].reset();
				array[i][2].doubleValue();
				score = score + array[i][2].getValue();
				array[i][3].reset();
			} else if (array[i][0].getValue() == array[i][1].getValue() && array[i][0].getValue() != 0) {
				array[i][0].doubleValue();
				score = score + array[i][0].getValue();
				array[i][1].reset();
			} else if (array[i][1].getValue() == array[i][2].getValue() && array[i][1].getValue() != 0) {
				array[i][1].doubleValue();
				score = score + array[i][1].getValue();
				array[i][2].reset();
			} else if (array[i][2].getValue() == array[i][3].getValue() && array[i][2].getValue() != 0) {	
				array[i][2].doubleValue();
				score = score + array[i][2].getValue();
				array[i][3].reset();
			} 
		}
		this.up();
		
		updateGameOver();
		updateWinner();
		
		boolean b = c1 == array[0][0].getValue() && c2 == array[0][1].getValue() && c3 == array[0][2].getValue() &&
				c4 == array[0][3].getValue() && c5 == array[1][0].getValue() && c6 == array[1][1].getValue() && 
				c7 == array[1][2].getValue() && c8 == array[1][3].getValue() && c9 == array[2][0].getValue() && 
				c10 == array[2][1].getValue() && c11 == array[2][2].getValue() && c12 == array[2][3].getValue() && 
				c13 == array[3][0].getValue() && c14 == array[3][1].getValue() && c15 == array[3][2].getValue() && 
				c16 == array[3][3].getValue();
		
		if (!this.gameOver && !winner && !b) {
			this.addNewTile();
			addToUndoList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, pscore);
		}
	}
	
	public void rightCombine() {
		int c1 = array[0][0].getValue();
		int c2 = array[0][1].getValue();
		int c3 = array[0][2].getValue();
		int c4 = array[0][3].getValue();
		int c5 = array[1][0].getValue();
		int c6 = array[1][1].getValue();
		int c7 = array[1][2].getValue();
		int c8 = array[1][3].getValue();
		int c9 = array[2][0].getValue();
		int c10 = array[2][1].getValue();
		int c11 = array[2][2].getValue();
		int c12 = array[2][3].getValue();
		int c13 = array[3][0].getValue();
		int c14 = array[3][1].getValue();
		int c15 = array[3][2].getValue();
		int c16 = array[3][3].getValue();
		int pscore = this.score;
		
		this.right();

		for (int i = 0; i < array.length; i++) {
			if (array[0][i].getValue() == array[1][i].getValue() && array[2][i].getValue() == array[3][i].getValue()) {
				array[1][i].doubleValue();
				score = score + array[1][i].getValue();
				array[0][i].reset();
				array[3][i].doubleValue();
				score = score + array[3][i].getValue();
				array[2][i].reset();
			} else if (array[2][i].getValue() == array[3][i].getValue()) {	
				array[3][i].doubleValue();
				score = score + array[3][i].getValue();
				array[2][i].reset();
			} else if (array[1][i].getValue() == array[2][i].getValue()) {
				array[2][i].doubleValue();
				score = score + array[2][i].getValue();
				array[1][i].reset();
			} else if (array[0][i].getValue() == array[1][i].getValue()) {
				array[1][i].doubleValue();
				score = score + array[1][i].getValue();
				array[0][i].reset();
			}
		}
		this.right();
		
		updateGameOver();
		updateWinner();
		
		boolean b = c1 == array[0][0].getValue() && c2 == array[0][1].getValue() && c3 == array[0][2].getValue() &&
				c4 == array[0][3].getValue() && c5 == array[1][0].getValue() && c6 == array[1][1].getValue() && 
				c7 == array[1][2].getValue() && c8 == array[1][3].getValue() && c9 == array[2][0].getValue() && 
				c10 == array[2][1].getValue() && c11 == array[2][2].getValue() && c12 == array[2][3].getValue() && 
				c13 == array[3][0].getValue() && c14 == array[3][1].getValue() && c15 == array[3][2].getValue() && 
				c16 == array[3][3].getValue();
		
		if (!this.gameOver && !winner && !b) {
			this.addNewTile();
			addToUndoList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, pscore);
		}
	}
	
	public void leftCombine() {
		int c1 = array[0][0].getValue();
		int c2 = array[0][1].getValue();
		int c3 = array[0][2].getValue();
		int c4 = array[0][3].getValue();
		int c5 = array[1][0].getValue();
		int c6 = array[1][1].getValue();
		int c7 = array[1][2].getValue();
		int c8 = array[1][3].getValue();
		int c9 = array[2][0].getValue();
		int c10 = array[2][1].getValue();
		int c11 = array[2][2].getValue();
		int c12 = array[2][3].getValue();
		int c13 = array[3][0].getValue();
		int c14 = array[3][1].getValue();
		int c15 = array[3][2].getValue();
		int c16 = array[3][3].getValue();
		int pscore = this.score;
		
		this.left();
		
		for (int i = 0; i < array.length; i++) {
			if (array[0][i].getValue() == array[1][i].getValue() && array[2][i].getValue() == array[3][i].getValue()) {
				array[0][i].doubleValue();
				score = score + array[0][i].getValue();
				array[1][i].reset();
				array[2][i].doubleValue();
				score = score + array[2][i].getValue();
				array[3][i].reset();	
			} else if (array[0][i].getValue() == array[1][i].getValue()) {
				array[0][i].doubleValue();
				score = score + array[0][i].getValue();
				array[1][i].reset();
			} else if (array[1][i].getValue() == array[2][i].getValue()) {
				array[1][i].doubleValue();
				score = score + array[1][i].getValue();
				array[2][i].reset();	
			} else if (array[2][i].getValue() == array[3][i].getValue()) {	
				array[2][i].doubleValue();
				score = score + array[2][i].getValue();
				array[3][i].reset();
			} 
		}
		this.left();
		
		updateGameOver();
		updateWinner();
		
		boolean b = c1 == array[0][0].getValue() && c2 == array[0][1].getValue() && c3 == array[0][2].getValue() &&
				c4 == array[0][3].getValue() && c5 == array[1][0].getValue() && c6 == array[1][1].getValue() && 
				c7 == array[1][2].getValue() && c8 == array[1][3].getValue() && c9 == array[2][0].getValue() && 
				c10 == array[2][1].getValue() && c11 == array[2][2].getValue() && c12 == array[2][3].getValue() && 
				c13 == array[3][0].getValue() && c14 == array[3][1].getValue() && c15 == array[3][2].getValue() && 
				c16 == array[3][3].getValue();
		
		if (!this.gameOver && !winner && !b) {
			this.addNewTile();
			addToUndoList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, pscore);
		}
	}
	
	public void addToUndoList(int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9, int c10, int c11,
			int c12, int c13, int c14, int c15, int c16, int previousScore) {

		if (undoList.size() == 3) {
			undoList.remove(2);
			pastScores.remove(2);
		}
		
		int[][] arrayToStore = new int[4][4];
		arrayToStore[0][0] = c1;
		arrayToStore[0][1] = c2;
		arrayToStore[0][2] = c3;
		arrayToStore[0][3] = c4;
		arrayToStore[1][0] = c5;
		arrayToStore[1][1] = c6;
		arrayToStore[1][2] = c7;
		arrayToStore[1][3] = c8;
		arrayToStore[2][0] = c9;
		arrayToStore[2][1] = c10;
		arrayToStore[2][2] = c11;
		arrayToStore[2][3] = c12;
		arrayToStore[3][0] = c13;
		arrayToStore[3][1] = c14;
		arrayToStore[3][2] = c15;
		arrayToStore[3][3] = c16;
		
		undoList.add(0, arrayToStore);
		pastScores.add(0, previousScore);
	}
	
	public void undo() {
		if (undoList.size() > 0) {
			int[][] previous = undoList.remove();
			setValues(previous[0][0], previous[0][1], previous[0][2], previous[0][3], previous[1][0], previous[1][1], 
					previous[1][2], previous[1][3], previous[2][0], previous[2][1], previous[2][2], previous[2][3], 
					previous[3][0], previous[3][1], previous[3][2], previous[3][3]);
			score = pastScores.remove();
		}
	}
	
	public void draw(Graphics g) {
		try {
			BufferedImage img1 = ImageIO.read(new File("files/" + array[0][0].getValue() + ".png"));
			g.drawImage(img1, 10, 10, 50, 50, null);
			
			BufferedImage img2 = ImageIO.read(new File("files/" + array[0][1].getValue() + ".png"));
			g.drawImage(img2, 10, 70, 50, 50, null);
			
			BufferedImage img3 = ImageIO.read(new File("files/" + array[0][2].getValue() + ".png"));
			g.drawImage(img3, 10, 130, 50, 50, null);
			
			BufferedImage img4 = ImageIO.read(new File("files/" + array[0][3].getValue() + ".png"));
			g.drawImage(img4, 10, 190, 50, 50, null);
			
			BufferedImage img5 = ImageIO.read(new File("files/" + array[1][0].getValue() + ".png"));
			g.drawImage(img5, 70, 10, 50, 50, null);
			
			BufferedImage img6 = ImageIO.read(new File("files/" + array[1][1].getValue() + ".png"));
			g.drawImage(img6, 70, 70, 50, 50, null);
			
			BufferedImage img7 = ImageIO.read(new File("files/" + array[1][2].getValue() + ".png"));
			g.drawImage(img7, 70, 130, 50, 50, null);
			
			BufferedImage img8 = ImageIO.read(new File("files/" + array[1][3].getValue() + ".png"));
			g.drawImage(img8, 70, 190, 50, 50, null);
			
			BufferedImage img9 = ImageIO.read(new File("files/" + array[2][0].getValue() + ".png"));
			g.drawImage(img9, 130, 10, 50, 50, null);
			
			BufferedImage img10 = ImageIO.read(new File("files/" + array[2][1].getValue() + ".png"));
			g.drawImage(img10, 130, 70, 50, 50, null);
			
			BufferedImage img11 = ImageIO.read(new File("files/" + array[2][2].getValue() + ".png"));
			g.drawImage(img11, 130, 130, 50, 50, null);
			
			BufferedImage img12 = ImageIO.read(new File("files/" + array[2][3].getValue() + ".png"));
			g.drawImage(img12, 130, 190, 50, 50, null);
			
			BufferedImage img13 = ImageIO.read(new File("files/" + array[3][0].getValue() + ".png"));
			g.drawImage(img13, 190, 10, 50, 50, null);
			
			BufferedImage img14 = ImageIO.read(new File("files/" + array[3][1].getValue() + ".png"));
			g.drawImage(img14, 190, 70, 50, 50, null);
			
			BufferedImage img15 = ImageIO.read(new File("files/" + array[3][2].getValue() + ".png"));
			g.drawImage(img15, 190, 130, 50, 50, null);
			
			BufferedImage img16 = ImageIO.read(new File("files/" + array[3][3].getValue() + ".png"));
			g.drawImage(img16, 190, 190, 50, 50, null);
			
			g.drawString("Score: " + score, 85, 255);
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
