/**
 * 
 * https://neetcode.io/problems/minimum-stack/question?list=neetcode150
 * 
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Each function should run in O(1) O(1) time.
 * 
 * Constraints:
 * -2^31 <= val <= 2^31 - 1.
 * pop, top and getMin will always be called on non-empty stacks.
 */
public class MinStack { {
    Deque<Integer> dq;
    Deque<Integer> mdq;

    public MinStack() {
        dq = new ArrayDeque<>();
        mdq = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int c = !mdq.isEmpty() ? mdq.getLast() : val;
        dq.addLast(val);
        mdq.addLast(Math.min(c, val));
    }
    
    public void pop() {
        dq.removeLast();
        mdq.removeLast();
    }
    
    public int top() {
        return dq.getLast();
    }
    
    public int getMin() {
        return mdq.getLast();
    }
}
