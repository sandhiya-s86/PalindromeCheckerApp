import java.util.*;
public class PalindromeCheckerApp {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");
        String s = sc.nextLine();
        boolean result = check(s, 0, s.length() - 1);
        System.out.println("Is Palindrome? : " + result);
        sc.close();
    }

    private static boolean check(String s, int start, int end) {

        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return check(s, start + 1, end - 1);
    }
}
