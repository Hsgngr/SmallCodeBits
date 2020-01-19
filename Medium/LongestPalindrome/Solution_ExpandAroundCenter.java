class Solution_ExpandAroundCenter {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //iki farklı simetrik var. 1) "AA" ortadan ayrılan
            int len2 = expandAroundCenter(s, i, i + 1); //Ya da böyle "ABA" ortada başka bir harf olup simetrik olan. İkisini de bu şekilde check ediyor.
            int len = Math.max(len1, len2); //iki simetriden hangisi daha büyük bir simetriyi içeriyor ? Onu seç
            if (len > end - start) {  //  Bu kısımda maksimum simetrik harf sayısı (len)'dan end ve start noktasını bulacağız. // Ayrıca bu satır maxiumum length'i tutuyor. start=0, end=17
                start = i - (len - 1) / 2;
                end = i + len / 2; // Burada len/2 = 0.5 aslında ama end ve start integer olduğu için sayıyı groundluyor. i=0, len=1 => end= 0 + 1/2 = 0 diyor.
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) { // Bu kısımda en uzun simetrik harf sayısını buldu. len=4
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }




    public static void main(String[] args) {
        String str = "asdfghjkllkjhgfdsasdfghjkkjhgfdsdfghj";
        String b = longestPalindrome(str);
        System.out.println(b);
    }
}

