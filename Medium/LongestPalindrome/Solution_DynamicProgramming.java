public class Solution_DynamicProgramming {

    public static String longestPalindrome3(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]); // Boolean int Array Matrix mi ? I'm out.

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "asdfghjkllkjhgfdsasdfghjkkjhgfdsdfghj";
        String b = longestPalindrome3(str);
        System.out.println(b);
    }
}
