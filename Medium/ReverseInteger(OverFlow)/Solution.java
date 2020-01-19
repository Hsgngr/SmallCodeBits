import java.util.LinkedList;

public class Solution {
    public static int reverse(int x) {
        boolean negativeFlag = false;
        if (x < 0) {
            negativeFlag = true;
            x = -x;
        }
        int reversed = 0;
        int pre_reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;

            if ((reversed - digit) / 10 != pre_reversed) {
                System.out.println("WARNING OVERFLOWED!!!");
                return 0;
            }

            x = x / 10;
            pre_reversed = reversed;
        }
        return (negativeFlag == true) ? -reversed : reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}

