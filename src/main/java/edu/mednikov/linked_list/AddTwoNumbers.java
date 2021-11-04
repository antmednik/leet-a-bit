package edu.mednikov.linked_list;

/**
 * Add Two Numbers
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/107/linked-list/783/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, root = new ListNode();
        ListNode prev = null, curr = root;
        int addNext = 0;
        for (; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next) {
            if (prev != null) {
                curr.next = new ListNode();
                curr = curr.next;
            }
            int currSum = p1.val + p2.val + addNext;
            addNext = currSum / 10;
            currSum %= 10;

            curr.val = currSum;
            prev = curr;
        }
        while (p1 != null) {
            curr.next = new ListNode();
            curr = curr.next;

            int currSum = p1.val + addNext;
            addNext = currSum / 10;
            currSum %= 10;

            curr.val = currSum;
            p1 = p1.next;
        }
        while (p2 != null) {
            curr.next = new ListNode();
            curr = curr.next;

            int currSum = p2.val + addNext;
            addNext = currSum / 10;
            currSum %= 10;

            curr.val = currSum;
            p2 = p2.next;
        }
        if (addNext != 0) {
            curr.next = new ListNode();
            curr.next.val = addNext;
        }
        return root;
    }
}
