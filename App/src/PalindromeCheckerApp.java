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

        PalindromeStrategy stackStrategy = new StackStrategy();
        long start1 = System.nanoTime();
        boolean result1 = stackStrategy.checkPalindrome(s);
        long end1 = System.nanoTime();

        PalindromeStrategy dequeStrategy = new DequeStrategy();
        long start2 = System.nanoTime();
        boolean result2 = dequeStrategy.checkPalindrome(s);
        long end2 = System.nanoTime();

        System.out.println("Stack Strategy Result : " + result1);
        System.out.println("Execution Time : " + (end1 - start1) + " ns");

        System.out.println("Deque Strategy Result : " + result2);
        System.out.println("Execution Time : " + (end2 - start2) + " ns");

        sc.close();
    }
}