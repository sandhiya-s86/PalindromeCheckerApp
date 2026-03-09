import java.util.Scanner;
class PalindromeChecker {
    public boolean checkPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        String s = sc.nextLine();

        // normalize string (ignore spaces and case)
        s = s.replaceAll("\\s+", "").toLowerCase();

        // create object of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(s);

        System.out.println("Is Palindrome? : " + result);

        sc.close();
    }
}