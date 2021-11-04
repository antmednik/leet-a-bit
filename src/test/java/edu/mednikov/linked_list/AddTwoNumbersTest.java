package edu.mednikov.linked_list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTwoNumbersTest {

    @Test
    public void test1() {
        var result =
                new AddTwoNumbers().addTwoNumbers(
                        LinkedListTestUtils.list(List.of(0)),
                        LinkedListTestUtils.list(List.of(1)));
        LinkedListTestUtils.assertList(result, List.of(1));
    }

    @Test
    public void test2() {
        var result =
                new AddTwoNumbers().addTwoNumbers(
                        LinkedListTestUtils.list(List.of(1, 2, 3)),
                        LinkedListTestUtils.list(List.of(0)));
        LinkedListTestUtils.assertList(result, List.of(1, 2, 3));
    }

    @Test
    public void test3() {
        var result =
                new AddTwoNumbers().addTwoNumbers(
                        LinkedListTestUtils.list(List.of(2, 4, 3)),
                        LinkedListTestUtils.list(List.of(5, 6, 4)));
        LinkedListTestUtils.assertList(result, List.of(7, 0, 8));
    }

    @Test
    public void test4() {
        var result =
                new AddTwoNumbers().addTwoNumbers(
                        LinkedListTestUtils.list(List.of(0)),
                        LinkedListTestUtils.list(List.of(0)));
        LinkedListTestUtils.assertList(result, List.of(0));
    }

    @Test
    public void test5() {
        var result =
                new AddTwoNumbers().addTwoNumbers(
                        LinkedListTestUtils.list(List.of(9, 9, 9, 9, 9, 9, 9)),
                        LinkedListTestUtils.list(List.of(9, 9, 9, 9)));
        LinkedListTestUtils.assertList(result, List.of(8, 9, 9, 9, 0, 0, 0, 1));
    }

    @Test
    public void test6() {
        var result = new AddTwoNumbers().addTwoNumbers(
                LinkedListTestUtils.list(List.of(0,8,6,5,6,8,3,5,7)),
                LinkedListTestUtils.list(List.of(6,7,8,0,8,5,8,9,7)));
        LinkedListTestUtils.assertList(result, List.of(6,5,5,6,4,4,2,5,5,1));
    }
}
