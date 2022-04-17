package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static final String[] DATA = {"test_1", "test_2", "test_3", "test_4", "test_5"};
    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(DATA);
    }

    //1 ako e null
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParam() throws OperationNotSupportedException {
         new ListIterator(null);
    }
    @Test
    public void testHasNextAndMove(){
        //{"test_1", "test_2", "test_3", "test_4", "test_5"};
        assertTrue(listIterator.hasNext());
        assertTrue(listIterator.move());

        assertTrue(listIterator.hasNext());
        assertTrue(listIterator.move());

        assertTrue(listIterator.hasNext());
        assertTrue(listIterator.move());

        assertTrue(listIterator.hasNext());
        assertTrue(listIterator.move());

        assertFalse(listIterator.hasNext());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }
    @Test
    public void testPrintIsCorrect(){
        int index = 0;
        while(listIterator.hasNext()) {
            assertEquals(listIterator.print(), DATA[index]);
            index++;
            listIterator.move();
        }
    }
}