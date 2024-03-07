import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat.Field;

import org.junit.Before;

public class UnitTest {
	Wild wild = new Wild();
	@Test
	public void testAddAnimals() {
		Wild wilderness = new Wild();
		Animal Deer = new Deer();
		wilderness.addAnimal(Deer,1,1);
		assertEquals(Deer,wilderness.wilderness[1][1]);
		}
	    

	    @Test
	    public void testMove_DeerAndWolfInteraction() {
	        wild.wilderness[1][1] = new Deer();
	        wild.wilderness[0][1] = new Wolf();
	        wild.move();
	        assertNull(wild.wilderness[1][1]);
	       }

	    @Test
	    public void testMove_DeerMoves() {
	        wild.wilderness[1][1] = new Deer();
	        wild.move();
	        assertNull(wild.wilderness[1][1]);
	       }

	    @Test
	    public void testMove_WolfMoves() {
	        wild.wilderness[1][1] = new Wolf();
	        wild.move();
	        assertNull(wild.wilderness[1][1]);
	        }

	    @Test
	    public void testMove_EmptyCell() {
	        wild.wilderness[1][1] = null;
	        wild.move();
	        assertNull(wild.wilderness[0][1]);
	    }

	    @Test
	    public void testMove_WolfMovesOffGrid() {
	        wild.wilderness[1][Wild.MAXY - 1] = new Wolf(); // Wolf at the right edge
	        wild.move();
	        assertNull(wild.wilderness[1][Wild.MAXY - 1]); // Wolf should move off the grid
	    }

	    @Test
	    public void testMove_DeerMovesOffGrid() {
	        wild.wilderness[Wild.MAXX - 1][1] = new Deer(); // Deer at the bottom edge
	        wild.move();
	        assertNull(wild.wilderness[Wild.MAXX - 1][1]); // Deer should move off the grid
	    }
	    @Test
	    public void testToString() {
	        Animal deer = new Deer();
	        Animal wolf = new Wolf();
	        wild.wilderness[1][1] = deer;
	        wild.wilderness[2][2] = wolf;

	        // Redirect the standard output to capture the printed grid
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        PrintStream originalOut = System.out;
	        System.setOut(new PrintStream(outputStream));

	        // Call the toString method
	        wild.toString();

	        // Restore the standard output
	        System.setOut(originalOut);

	        // Expected grid representation
	        String expectedGrid = "-  -  -  -  -  -  -  -  -  -  \n" +
	                              "-  D  -  -  -  -  -  -  -  -  \n" +
	                              "-  -  W  -  -  -  -  -  -  -  \n" +
	                              "-  -  -  -  -  -  -  -  -  -  \n" +
	                              "-  -  -  -  -  -  -  -  -  -  \n" +
	                              "-  -  -  -  -  -  -  -  -  -  \n" +
	                              "-  -  -  -  -  -  -  -  -  -  \n" +
	                              "-  -  -  -  -  -  -  -  -  -  \n" +
	                              "-  -  -  -  -  -  -  -  -  -  \n" +
	                              "-  -  -  -  -  -  -  -  -  -  \n";

	        // Compare the actual grid representation with the expected one
	        assertTrue(expectedGrid== outputStream.toString());
	    }
	    @Test
	    public void testGridInitialization() throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	        int rows = 5;
	        int cols = 10;

	        // Call the Grid method using reflection (since it's private)
	        wild.getClass().getDeclaredMethod("Grid", int.class, int.class).invoke(wild, rows, cols);

	        // Access the private wilderness field using reflection
	        java.lang.reflect.Field field = Wild.class.getDeclaredField("wilderness");
	        field.setAccessible(true);
	        Animal[][] grid = (Animal[][]) field.get(wild);

	        // Ensure the grid is initialized with the correct dimensions
	        assertEquals(rows, grid.length);
	        assertEquals(cols, grid[0].length);
	    }

	    @Test
	    public void testPopulate() throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	        int rows = 5;
	        int cols = 10;

	        // Call the Grid method using reflection (since it's private)
	        wild.getClass().getDeclaredMethod("Grid", int.class, int.class).invoke(wild, rows, cols);

	        // Access the private wilderness field using reflection
	        java.lang.reflect.Field field = Wild.class.getDeclaredField("wilderness");
	        field.setAccessible(true);
	        Animal[][] grid = (Animal[][]) field.get(wild);

	        // Ensure the grid is populated with animals or null values
	        for (int i = 0; i < grid.length; i++) {
	            for (int j = 0; j < grid[i].length; j++) {
	                assertNotNull(grid[i][j]); // Check if each cell contains an animal or null
	            }
	        }
	    }
	}
	

