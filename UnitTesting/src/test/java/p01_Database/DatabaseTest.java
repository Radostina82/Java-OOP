package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {10, 1, 8, 5, 20};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorShouldCreateValidObject() {
        Integer[] databaseElement = database.getElements();
        assertEquals(NUMBERS.length, databaseElement.length);
        for (int i = 0; i < databaseElement.length; i++) {
            assertEquals(NUMBERS[i], databaseElement[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldBeMoreThanSixteenElementThrow() throws OperationNotSupportedException {
        Integer[] number = new Integer[17];
        new Database(number);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldBeLessThanSixteenElementThrow() throws OperationNotSupportedException {
        Integer[] number = new Integer[0];
        new Database(number);
    }

    @Test
    public void testAddSuccessElementInArray() throws OperationNotSupportedException {
        database.add(9);
        assertEquals(NUMBERS.length + 1, database.getElements().length);
        assertEquals(Integer.valueOf(9), database.getElements()[5]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenParamNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowWithEmptyData() throws OperationNotSupportedException {
        for (Integer element : database.getElements()) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();
        Integer element =elements [elements.length-2];
        database.remove();
        assertEquals(NUMBERS.length-1, database.getElements().length);
        assertEquals(element, database.getElements()[database.getElements().length-1]);
    }

}