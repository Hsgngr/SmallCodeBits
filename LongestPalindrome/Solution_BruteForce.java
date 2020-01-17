public class Solution_BruteForce {
    public String longestPalindrome(String s) {
        int max = 0;
        String result = "";

        if(s.length()<2) return s;

        for(int i =0; i< s.length(); i++){
            for(int j =i; j<=s.length(); j++){
                String sub = s.substring(i,j);
                if(isPalindrom(sub)){
                    if(sub.length() >= max) {
                        max = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrom(String s){
        for(int i =0; i< s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
