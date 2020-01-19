
public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) { //whichever is bigger make it nums1;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        if (nums1 == null || nums2 == null || (nums1.length == 0 || nums2.length == 0)) { //if there is an empty array dont waste my time.
            if (nums1 == null) {
                return findMedian(nums2);
            } else return findMedian(nums1);
        }


        int totalNumber = nums1.length + nums2.length; //our combined array's length.
        int[] biliBende = new int[totalNumber]; //BiliBende is our combined array, also a kurdish song name.

        int countNum1 = 0;
        int countNums2 = 0;

        for (int i = 0; i <= totalNumber; i++) {  //hangi arraydeki daha küçükse sortedArray'e onu yaz. Bu bir bakıma SelectionSort algoritması
            if (nums1[countNum1] <= nums2[countNums2]) {
                biliBende[i] = nums1[countNum1];
                if (nums1.length - 1 > countNum1) {
                    countNum1++;
                } else {
                    i++;
                    while (i != totalNumber) {  //eğer bir arraydeki sayılar bittiyse diğer arrayda kalanları komple sortedArray'e ekle.

                        biliBende[i] = nums2[countNums2];
                        i++;
                        countNums2++;
                    }
                    break;
                }
            } else {
                biliBende[i] = nums2[countNums2];
                if (nums2.length - 1 > countNums2) {
                    countNums2++;
                } else {
                    i++;
                    while (i != totalNumber) { //code tekrarı var, not cool =(

                        biliBende[i] = nums1[countNum1];
                        i++;
                        countNum1++;
                    }
                    break;
                }
            }
        }

        return findMedian(biliBende);
    }

    private static double findMedian(int[] biliBende) {  //array çift sayıysa sıkıntı değilse zaten kolay.
        int totalNumber = biliBende.length;
        if (totalNumber % 2 == 0) {
            return (biliBende[(totalNumber) / 2] + biliBende[(totalNumber / 2) - 1]) / 2f;
        } else return biliBende[(totalNumber - 1) / 2];
    }
}
