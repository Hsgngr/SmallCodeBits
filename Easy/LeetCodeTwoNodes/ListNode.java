package com.company;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    public void addNode(int x){
        ListNode newNode = new ListNode(x);
        this.next = newNode;
    }
}
