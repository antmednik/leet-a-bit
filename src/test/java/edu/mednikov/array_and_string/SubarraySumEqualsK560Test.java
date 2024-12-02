package edu.mednikov.array_and_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsK560Test {

    @Test
    public void test() {
        var sut = new SubarraySumEqualsK560();
        assertEquals(2, sut.subarraySum(new int[] { 1, 1, 1 }, 2));
        assertEquals(2, sut.subarraySum(new int[] { 1, 2, 3 }, 3));
        assertEquals(1, sut.subarraySum(new int[] { 1 }, 1));
        assertEquals(0, sut.subarraySum(new int[] { 1 }, 2));
        assertEquals(2, sut.subarraySum(new int[] { -1, 0, 1, -1, 4 }, 3));
        assertEquals(3, sut.subarraySum(new int[] { -1, 0, 1, -1, 4 , -5, -2}, -2));
    }

}