// a class for the Tile object which stores and modifies the value contained in that tile
public class Tile {
	private int value;
	private boolean is2048;
	
	public Tile() {
		value = 0;
		is2048 = false;
	}
	
	public int getValue() {
		return value;
	}
	
	// randomly generates the tile to be either 2 or 4
	public void createNew() {
		int random = (int) Math.floor(2 * Math.random());
		if (random == 0) {
			this.value = 2;
		} else {
			this.value = 4;
		}
	}
	
	public void set(int value) {
		this.value = value;
		
		if (this.value >= 2048) {
			is2048 = true;
		}
	}
	
	public void reset() {
		value = 0;
		is2048 = false;
	}
	
	public void doubleValue() {
		this.value = 2 * this.value;
		
		if (this.value >= 2048) {
			is2048 = true;
		}
	}
	
	public boolean is2048() {
		return is2048;
	}
}
