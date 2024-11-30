package edu.mednikov.stack;

/**
 * https://leetcode.com/problems/min-stack/description/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 */
public class MinStack155 {

    static
    class MinStack {

        private Node head;

        public MinStack() {

        }

        public void push(int val) {
            head = new Node(val, head == null ? val : Math.min(val, head.min), head);
        }

        public void pop() {
            if (head != null) {
                head = head.next;
            }
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;
        }

        private static class Node {
            int value;
            int min;
            Node next;

            public Node(int value, int min, Node next) {
                this.value = value;
                this.min = min;
                this.next = next;
            }
        }
    }
}
