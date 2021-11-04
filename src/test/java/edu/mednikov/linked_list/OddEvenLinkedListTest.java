package edu.mednikov.linked_list;

import org.junit.jupiter.api.Test;

import java.util.List;

public class OddEvenLinkedListTest {

    @Test
    public void test1() {
        LinkedListTestUtils.assertList(
            new OddEvenLinkedList().oddEvenList(LinkedListTestUtils.list(
                    List.of(1, 2, 3, 4, 5))),
                List.of(1, 3, 5, 2, 4));
    }

    @Test
    public void test2() {
        LinkedListTestUtils.assertList(
                new OddEvenLinkedList().oddEvenList(LinkedListTestUtils.list(
                        List.of(2, 1, 3, 5, 6, 4, 7))),
                List.of(2, 3, 6, 7, 1, 5, 4));
    }
}
