package day04;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Parameter;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    PairFinder pairFinder = new PairFinder();
    @Test
    void findPairs() {
        assertEquals(4, pairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 5, 7, 6, 7}));
        assertEquals(6, pairFinder.findPairs(new int[]{7, 1, 5, 7, 3, 3, 1, 5, 7, 7, 6, 7, 2, 1, 5, 3, 5}));
        assertEquals(0, pairFinder.findPairs(new int[]{}));

    }

}