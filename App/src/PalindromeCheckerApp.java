import java.util.*;
public class PalindromeCheckerApp {
    public static void main (String[] args){
        String input = "civic";

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);   // enqueue
            stack.push(c);  // push
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}
