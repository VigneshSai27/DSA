package KMP;

public class KmpMain {
    public static void main(String[] args) {
        String text = "ABCABABABC";
        String pattern = "ABABC";
        // String pattern = "AAACAAAA";

        int[] lps = findLPS(pattern);

        for (int i : lps) System.out.print(i + ", ");
        int n = text.length();
        int m = pattern.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
        }

        if (j == m) System.out.println("pattern found ");
        else System.out.println("pattern not found ");
    }

    private static int[] findLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; i++) {
            while (len > 0 && pattern.charAt(len) != pattern.charAt(i)) {
                len--;
            }
            if (pattern.charAt(len) == pattern.charAt(i)) {
                len += 1;
                lps[i] = len;
            }
        }
        return lps;
    }
}
