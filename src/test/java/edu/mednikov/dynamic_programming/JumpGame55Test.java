package edu.mednikov.dynamic_programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGame55Test {

    @Test
    public void test() {
        JumpGame55 jg = new JumpGame55();
        assertTrue(jg.canJump(new int[]{2, 3, 1, 1, 4}));
        assertFalse(jg.canJump(new int[]{3, 2, 1, 0, 4}));
        assertTrue(jg.canJump(new int[]{100}));
        assertTrue(jg.canJump(new int[]{1, 100}));
        assertFalse(jg.canJump(new int[]{0, 100}));
        assertTrue(jg.canJump(new int[]{2, 0, 1, 1, 4}));
        assertFalse(jg.canJump(new int[]{1, 0, 1, 1, 4}));
        assertTrue(jg.canJump(new int[]{4, 0, 3, 0, 0, 4}));
        assertFalse(jg.canJump(new int[]{4, 0, 3, 0, 0, 0, 4}));
    }
}