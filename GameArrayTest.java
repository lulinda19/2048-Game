import static org.junit.Assert.*;
import org.junit.Test;

/** 
 *  All tests for GameArray class
 */

public class GameArrayTest {

    @Test
    public void testDown1() {
        GameArray array = new GameArray();
        array.setValues(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2);
        array.down();
        assertEquals(array.getValueAt(0, 0), 0);
        assertEquals(array.getValueAt(0, 1), 0);
        assertEquals(array.getValueAt(0, 2), 0);
        assertEquals(array.getValueAt(0, 3), 2);
        assertEquals(array.getValueAt(1, 0), 0);
        assertEquals(array.getValueAt(1, 1), 0);
        assertEquals(array.getValueAt(1, 2), 0);
        assertEquals(array.getValueAt(1, 3), 2);
        assertEquals(array.getValueAt(2, 0), 0);
        assertEquals(array.getValueAt(2, 1), 0);
        assertEquals(array.getValueAt(2, 2), 0);
        assertEquals(array.getValueAt(2, 3), 2);
        assertEquals(array.getValueAt(3, 0), 0);
        assertEquals(array.getValueAt(3, 1), 0);
        assertEquals(array.getValueAt(3, 2), 0);
        assertEquals(array.getValueAt(3, 3), 2);
    }
    
    @Test
    public void testDown2() {
        GameArray array = new GameArray();
        array.setValues(0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        array.down();
        assertEquals(array.getValueAt(0, 0), 0);
        assertEquals(array.getValueAt(0, 1), 0);
        assertEquals(array.getValueAt(0, 2), 0);
        assertEquals(array.getValueAt(0, 3), 0);
        assertEquals(array.getValueAt(1, 0), 0);
        assertEquals(array.getValueAt(1, 1), 0);
        assertEquals(array.getValueAt(1, 2), 0);
        assertEquals(array.getValueAt(1, 3), 2);
        assertEquals(array.getValueAt(2, 0), 0);
        assertEquals(array.getValueAt(2, 1), 0);
        assertEquals(array.getValueAt(2, 2), 0);
        assertEquals(array.getValueAt(2, 3), 0);
        assertEquals(array.getValueAt(3, 0), 0);
        assertEquals(array.getValueAt(3, 1), 0);
        assertEquals(array.getValueAt(3, 2), 0);
        assertEquals(array.getValueAt(3, 3), 0);
    }
    
    @Test
    public void testDownCombine1() {
        GameArray array = new GameArray();
        array.setValues(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        array.downCombine();
        assertEquals(array.getValueAt(0, 2), 4);
        assertEquals(array.getValueAt(0, 3), 4);
        assertEquals(array.getValueAt(1, 2), 4);
        assertEquals(array.getValueAt(1, 3), 4);
        assertEquals(array.getValueAt(2, 2), 4);
        assertEquals(array.getValueAt(2, 3), 4);
        assertEquals(array.getValueAt(3, 2), 4);
        assertEquals(array.getValueAt(3, 3), 4);
    }
    
    @Test
    public void testUp1() {
        GameArray array = new GameArray();
        array.setValues(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2);
        array.up();
        assertEquals(array.getValueAt(0, 0), 2);
        assertEquals(array.getValueAt(0, 1), 0);
        assertEquals(array.getValueAt(0, 2), 0);
        assertEquals(array.getValueAt(0, 3), 0);
        assertEquals(array.getValueAt(1, 0), 2);
        assertEquals(array.getValueAt(1, 1), 0);
        assertEquals(array.getValueAt(1, 2), 0);
        assertEquals(array.getValueAt(1, 3), 0);
        assertEquals(array.getValueAt(2, 0), 2);
        assertEquals(array.getValueAt(2, 1), 0);
        assertEquals(array.getValueAt(2, 2), 0);
        assertEquals(array.getValueAt(2, 3), 0);
        assertEquals(array.getValueAt(3, 0), 2);
        assertEquals(array.getValueAt(3, 1), 0);
        assertEquals(array.getValueAt(3, 2), 0);
        assertEquals(array.getValueAt(3, 3), 0);
    }
    
    @Test
    public void testUpCombine1() {
        GameArray array = new GameArray();
        array.setValues(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        array.upCombine();
        assertEquals(array.getValueAt(0, 0), 4);
        assertEquals(array.getValueAt(0, 1), 4);
        assertEquals(array.getValueAt(1, 0), 4);
        assertEquals(array.getValueAt(1, 1), 4);
        assertEquals(array.getValueAt(2, 0), 4);
        assertEquals(array.getValueAt(2, 1), 4);
        assertEquals(array.getValueAt(3, 0), 4);
        assertEquals(array.getValueAt(3, 1), 4);
    }
    
    @Test
    public void testRight1() {
        GameArray array = new GameArray();
        array.setValues(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2);
        array.right();
        assertEquals(array.getValueAt(0, 0), 0);
        assertEquals(array.getValueAt(0, 1), 0);
        assertEquals(array.getValueAt(0, 2), 0);
        assertEquals(array.getValueAt(0, 3), 0);
        assertEquals(array.getValueAt(1, 0), 0);
        assertEquals(array.getValueAt(1, 1), 0);
        assertEquals(array.getValueAt(1, 2), 0);
        assertEquals(array.getValueAt(1, 3), 0);
        assertEquals(array.getValueAt(2, 0), 0);
        assertEquals(array.getValueAt(2, 1), 0);
        assertEquals(array.getValueAt(2, 2), 0);
        assertEquals(array.getValueAt(2, 3), 0);
        assertEquals(array.getValueAt(3, 0), 2);
        assertEquals(array.getValueAt(3, 1), 2);
        assertEquals(array.getValueAt(3, 2), 2);
        assertEquals(array.getValueAt(3, 3), 2);
    }
    
    @Test
    public void testRightCombine1() {
        GameArray array = new GameArray();
        array.setValues(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        array.rightCombine();
        assertEquals(array.getValueAt(2, 0), 4);
        assertEquals(array.getValueAt(2, 1), 4);
        assertEquals(array.getValueAt(2, 2), 4);
        assertEquals(array.getValueAt(2, 3), 4);
        assertEquals(array.getValueAt(3, 0), 4);
        assertEquals(array.getValueAt(3, 1), 4);
        assertEquals(array.getValueAt(3, 2), 4);
        assertEquals(array.getValueAt(3, 3), 4);
    }
    
    @Test
    public void testLeft1() {
        GameArray array = new GameArray();
        array.setValues(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2);
        array.left();
        assertEquals(array.getValueAt(0, 0), 2);
        assertEquals(array.getValueAt(0, 1), 2);
        assertEquals(array.getValueAt(0, 2), 2);
        assertEquals(array.getValueAt(0, 3), 2);
        assertEquals(array.getValueAt(1, 0), 0);
        assertEquals(array.getValueAt(1, 1), 0);
        assertEquals(array.getValueAt(1, 2), 0);
        assertEquals(array.getValueAt(1, 3), 0);
        assertEquals(array.getValueAt(2, 0), 0);
        assertEquals(array.getValueAt(2, 1), 0);
        assertEquals(array.getValueAt(2, 2), 0);
        assertEquals(array.getValueAt(2, 3), 0);
        assertEquals(array.getValueAt(3, 0), 0);
        assertEquals(array.getValueAt(3, 1), 0);
        assertEquals(array.getValueAt(3, 2), 0);
        assertEquals(array.getValueAt(3, 3), 0);
    }
    
    @Test
    public void testLeftCombine1() {
        GameArray array = new GameArray();
        array.setValues(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
        array.leftCombine();
        assertEquals(array.getValueAt(0, 0), 4);
        assertEquals(array.getValueAt(0, 1), 4);
        assertEquals(array.getValueAt(0, 2), 4);
        assertEquals(array.getValueAt(0, 3), 4);
        assertEquals(array.getValueAt(1, 0), 4);
        assertEquals(array.getValueAt(1, 1), 4);
        assertEquals(array.getValueAt(1, 2), 4);
        assertEquals(array.getValueAt(1, 3), 4);
    }
    
    @Test
    public void testisWinner1() {
        GameArray array = new GameArray();
        array.setValues(0, 4, 4, 0, 2, 64, 0, 0, 0, 32, 0, 0, 2048, 0, 8, 0);
        array.updateWinner();
        assertTrue(array.isWinner());
    }
    
    @Test
    public void testisWinner2() {
        GameArray array = new GameArray();
        array.setValues(0, 4, 4, 0, 2, 64, 128, 0, 32, 32, 0, 0, 1024, 0, 8, 8);
        array.updateWinner();
        assertFalse(array.isWinner());
    }
    
    @Test
    public void testisGameOver() {
        GameArray array = new GameArray();
        array.setValues(2, 4, 2, 4, 4, 2, 4, 2, 2, 4, 2, 4, 4, 2, 4, 2);
        array.updateGameOver();
        assertTrue(array.isGameOver());
    }
    
    @Test
    public void testisGameOver2() {
        GameArray array = new GameArray();
        array.setValues(0, 4, 4, 0, 2, 64, 128, 0, 32, 32, 0, 0, 1024, 0, 8, 8);
        array.updateGameOver();
        assertFalse(array.isWinner());
    }
    
    @Test
    public void testUndo1() {
        GameArray array = new GameArray();
        array.setValues(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2);
        array.addToUndoList(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0);
        array.down();
        array.undo();
        assertEquals(array.getValueAt(0, 0), 2);
        assertEquals(array.getValueAt(0, 1), 0);
        assertEquals(array.getValueAt(0, 2), 0);
        assertEquals(array.getValueAt(0, 3), 0);
        assertEquals(array.getValueAt(1, 0), 0);
        assertEquals(array.getValueAt(1, 1), 2);
        assertEquals(array.getValueAt(1, 2), 0);
        assertEquals(array.getValueAt(1, 3), 0);
        assertEquals(array.getValueAt(2, 0), 0);
        assertEquals(array.getValueAt(2, 1), 0);
        assertEquals(array.getValueAt(2, 2), 2);
        assertEquals(array.getValueAt(2, 3), 0);
        assertEquals(array.getValueAt(3, 0), 0);
        assertEquals(array.getValueAt(3, 1), 0);
        assertEquals(array.getValueAt(3, 2), 0);
        assertEquals(array.getValueAt(3, 3), 2);
    }
}
