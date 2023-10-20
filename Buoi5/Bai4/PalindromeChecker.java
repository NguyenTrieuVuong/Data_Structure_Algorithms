// package Bai4;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        ArrayQueue<Character> queue = new ArrayQueue<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
            queue.enqueue(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.dequeue())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "racecar";
        if (isPalindrome(s)) {
            System.out.println(s + " is a palindrome");
        } else {
            System.out.println(s + " is not a palindrome");
        }
    }
}