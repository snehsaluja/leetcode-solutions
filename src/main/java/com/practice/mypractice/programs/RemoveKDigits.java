package com.practice.mypractice.programs;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {

    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
