package edu.mednikov.linked_list;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void test1() {
        var heads =
                list(
                        List.of(4, 1, 8, 4, 5),
                        List.of(5, 6, 1, 8, 4, 5),
                        8, 2, 3);
        var actual = new IntersectionOfTwoLinkedLists()
                .getIntersectionNode(heads.getKey(), heads.getValue());
        assertThat(actual.val).isEqualTo(8);
    }

    @Test
    public void test2() {
        var heads =
                list(
                        List.of(1, 9, 1, 2, 4),
                        List.of(3, 2, 4),
                        2, 3, 1);
        var actual = new IntersectionOfTwoLinkedLists()
                .getIntersectionNode(heads.getKey(), heads.getValue());
        assertThat(actual.val).isEqualTo(2);
    }

    @Test
    public void test3() {
        var heads =
                list(
                        List.of(2, 6, 4),
                        List.of(1, 5),
                        0, 3, 2);
        var actual = new IntersectionOfTwoLinkedLists()
                .getIntersectionNode(heads.getKey(), heads.getValue());
        assertThat(actual).isNull();
    }

    private Map.Entry<IntersectionOfTwoLinkedLists.ListNode, IntersectionOfTwoLinkedLists.ListNode>
    list(List<Integer> data1, List<Integer> data2,
         int intersectVal, int skipA, int skipB) {


        IntersectionOfTwoLinkedLists.ListNode headA = null, headB = null;
        if (intersectVal == 0) {
            IntersectionOfTwoLinkedLists.ListNode ptr;
            if (!data1.isEmpty()) {
                ptr = headA = new IntersectionOfTwoLinkedLists.ListNode(data1.get(0));
                for (int i = 1; i < data1.size(); i++) {
                    ptr.next = new IntersectionOfTwoLinkedLists.ListNode(data1.get(i));
                    ptr = ptr.next;
                }
            }
            if (!data2.isEmpty()) {
                ptr = headB = new IntersectionOfTwoLinkedLists.ListNode(data2.get(0));
                for (int i = 1; i < data2.size(); i++) {
                    ptr.next = new IntersectionOfTwoLinkedLists.ListNode(data2.get(i));
                    ptr = ptr.next;
                }
            }
        } else {
            IntersectionOfTwoLinkedLists.ListNode ptr1, ptr2;
            ptr1 = headA = new IntersectionOfTwoLinkedLists.ListNode(data1.get(0));
            for (int i = 1; i < skipA; i++) {
                ptr1.next = new IntersectionOfTwoLinkedLists.ListNode(data1.get(i));
                ptr1 = ptr1.next;
            }
            ptr2 = headB = new IntersectionOfTwoLinkedLists.ListNode(data2.get(0));
            for (int i = 1; i < skipB; i++) {
                ptr2.next = new IntersectionOfTwoLinkedLists.ListNode(data2.get(i));
                ptr2 = ptr2.next;
            }
            ptr1.next = ptr2.next = new IntersectionOfTwoLinkedLists.ListNode(data1.get(skipA));
            ptr1 = ptr1.next;
            for (int i = skipA + 1; i < data1.size(); i++) {
                ptr1.next = new IntersectionOfTwoLinkedLists.ListNode(data1.get(i));
                ptr1 = ptr1.next;
            }
        }
        return new AbstractMap.SimpleEntry<>(headA, headB);
    }
}
