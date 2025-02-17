package com.zss.code.common;

/**
 * @author ZSS
 * @date 2021/12/9 11:22
 * @desc 链表节点
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
