//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//        You may assume nums1 and nums2 cannot be both empty.
//
//        Example 1:
//
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5


public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums2 = {1,5,9,10,12,15,16};
        int[] nums3 = {3,4};
        int[] nums1 = {};

        System.out.println(Solution.findMedianSortedArrays(nums1,nums3));

    }
}
