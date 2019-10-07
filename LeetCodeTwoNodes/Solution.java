package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int counter = 0;
         ListNode tempList = l1;
        while (tempList.next != null) {
            counter++;
            tempList=tempList.next;

        }
        int[] values1 = new int[counter+1];
        int[] values2 = new int[counter+1];
        for (int i = values1.length-1; i >= 0; i--) {
            values1[i] =l1.val;
            values2[i] =l2.val;
            l1=l1.next;
            l2=l2.next;System.out.println(values1[i]);
        }

        return intArrayToListNode(values1,values2);
    }
    public ListNode intArrayToListNode(int[] intArray1, int[] intArray2){
        ListNode tempNode = new ListNode(0);
        ListNode temp2= tempNode;

        for(int i=0; i<intArray1.length;i++){
            int a=(intArray1[i] + intArray2[i]);
            ListNode node = new ListNode(0);
            if(a>9){
                if(intArray1.length-1 !=i){
                    intArray1[i+1]++;

                } else{ //arrayin sonuna geldik
                    node.next= new ListNode(1);
                }

            }
            a=a%10;
            node.val=a;
            tempNode.next= node;
            tempNode=node;
        }
        return temp2.next;
    }
}
