import java.util.*;
interface PalindromeStrategy {
    boolean checkPalindrome(String s);
}

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String s) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String s = sc.nextLine();
        s = s.replaceAll("\\s+", "").toLowerCase();
        System.out.print("Choose Strategy (1-Stack, 2-Deque): ");
        int choice = sc.nextInt();
        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }
        boolean result = strategy.checkPalindrome(s);
        System.out.println("Is Palindrome? : " + result);
        sc.close();
    }
}