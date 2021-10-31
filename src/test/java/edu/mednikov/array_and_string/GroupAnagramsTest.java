package edu.mednikov.array_and_string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GroupAnagramsTest {

    @Test
    public void test1() {
        var result = new GroupAnagrams().groupAnagrams(new String[]{
                "eat","tea","tan","ate","nat","bat"});

        Assertions.assertEquals(3, result.size());
        assertThat(result.get(0)).hasSize(2).contains("nat", "tan");
        assertThat(result.get(1)).hasSize(3).contains("ate", "eat", "tea");
        assertThat(result.get(2)).hasSize(1).contains("bat");
    }

    @Test
    public void test2() {
        var result = new GroupAnagrams().groupAnagrams(new String[]{});

        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void test3() {
        var result = new GroupAnagrams().groupAnagrams(new String[]{
                "a"});

        Assertions.assertEquals(1, result.size());
        assertThat(result.get(0)).hasSize(1).contains("a");
    }
}
