package com.company;

import java.util.Stack;

public class Main {
    public static Stack<Integer> deque(int[] list) {
        Queue queue = new Queue();
        for (int i = 0 ; i < list.length; i++) {
            queue.enqueue(list[i]);
        }
        Stack<Integer> stack = new Stack<Integer>();
        int size = list.length;
        while (size > 0) {
            System.out.println();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                int temp = queue.dequeue();
                if (temp < min) {
                    min = temp;
                }
                queue.enqueue(temp);
            }
            for (int i = 0; i < size; i++) {
                int temp = queue.dequeue();
                if (temp == min) {
                    break;}
                queue.enqueue(temp);
            }
            stack.push(min);
            size--;
        }
        return stack;
    }


    static class Queue {
        static Stack<Integer> stackOne = new Stack<Integer>();
        static Stack<Integer> stackTwo = new Stack<Integer>();

        static void enqueue(int x) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            stackOne.push(x);

            while (!stackTwo.isEmpty()) {
                stackOne.push(stackTwo.pop());
            }
        }
        static int dequeue() {
            if (stackOne.isEmpty()) {
                System.exit(0);
            }
            int x = stackOne.peek();
            stackOne.pop();
            return x;
        }
    }

    public static void main(String[] args) {
        int[] list = {7,8,2,2,1};
        Stack<Integer> result = deque(list);
        System.out.println("RESULT::: " + result);
    }
}
