package edu.mednikov.linked_list;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTestUtils {
    public static ListNode list(List<Integer> data) {
        ListNode root = new ListNode(), ptr = root;
        ptr.val = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            ptr.next = new ListNode();
            ptr = ptr.next;
            ptr.val = data.get(i);
        }
        return root;
    }

    public static void assertList(ListNode actual, List<Integer> expected) {
        assertThat(actual).isNotNull();
        ListNode ptr = actual;
        int i = 0;
        while (ptr != null) {
            assertThat(i).isLessThan(expected.size());
            assertThat(ptr.val).isEqualTo(expected.get(i));
            i++;
            ptr = ptr.next;
        }
        assertThat(i).isEqualTo(expected.size());
    }
}
