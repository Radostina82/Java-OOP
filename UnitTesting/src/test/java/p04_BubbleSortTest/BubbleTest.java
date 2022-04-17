package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {
    @Test
    public void testSort(){
        int [] numbers = {35, 8, 10, 1, 69, 50, 2, 4};
        Bubble.sort(numbers);
        int[] expectedSortedArray = {1, 2, 4 , 8, 10, 35, 50, 69};
        assertEquals(numbers.length,expectedSortedArray.length);
        assertArrayEquals(expectedSortedArray, numbers);
    }

}