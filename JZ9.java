package LeetCode.SwordToOffer;

import java.util.Stack;

public class JZ9 {


    JZ9() {
    }

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackHelp = new Stack<>();

    void appendTail(int value) {
        while (!stack.empty()) {
            stackHelp.push(stack.pop());
        }
        stackHelp.push(value);
        while (!stackHelp.empty()) {
            stack.push(stackHelp.pop());
        }
    }
    int deleteHead() {
        return stack.empty() ? -1 : stack.pop();
    }

    public static void main(String[] args) {

    }
}
