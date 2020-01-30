// a simple Score object which contains the score of the player and the player's name
public class Score implements Comparable<Score>{
	private int score;
	private String name;
	
	public Score(int i, String s) {
		score = i;
		name = s;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Score o) {
		if (o.getScore() > this.score) {
			return 1;
		} else if (o.getScore() < this.score) {
			return -1;
		} else {
			return 0;
		}
			
	}
}
