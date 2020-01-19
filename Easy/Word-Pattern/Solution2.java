import java.util.Collections;
import java.util.HashMap;

class Solution2 {
    public static boolean wordPattern(String pattern, String str) {
        String[] result = str.split("\\s*[^a-zA-Z0-9]+\\s*");
        String[] patternArray = pattern.split("(?!^)");
        if (result.length != patternArray.length || str == "" || pattern == "") return false;
        if (str.isEmpty() || pattern.isEmpty()) return false;
        HashMap<String, String> hm = new HashMap<String, String>();
        for (int i = 0; i < result.length; i++) {
            if (hm.containsKey(patternArray[i])) {
                //check if key is equal to this one
                String a = result[i];
                String b = hm.get(patternArray[i]);
                if (!a.equals(b)) {
                    return false;
                }
            } else {
                if (hm.containsValue(result[i])) return false;
                hm.put(patternArray[i], result[i]);
            }
        }
        System.out.println(Collections.unmodifiableMap(hm));
        return true;
    }

    public static void main(String[] args) {
        String pattern = "";
        String str = "beef";
        System.out.println(wordPattern(pattern, str));
    }
}