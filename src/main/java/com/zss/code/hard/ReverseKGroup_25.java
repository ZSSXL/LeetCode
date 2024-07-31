package com.zss.code.hard;

import com.zss.code.common.ListNode;
import com.zss.code.common.ListNodeUtils;

/**
 * @author ZSS
 * @date 2022/7/1 14:04
 * @desc 25 -- K个一组翻转链表
 */
public class ReverseKGroup_25 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 2;
        ListNode head = ListNodeUtils.initList(nums);

        ListNode listNode = reverseKGroup(head, k);

        ListNodeUtils.printList(listNode);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode grand;
        ListNode start;
        ListNode current;

        grand = start = head;
        current = head.next;

        int loop = 2;
        ListNode cNext;
        while (current != null) {
            if (loop == k) {
                // 此时，翻转之前的k个节点
                cNext = current.next;
                ListNode listNode = reverseWithLimit(start, current);
                temp.next = listNode;
                temp.next.next = cNext;
                if (grand == start) {
                    head = current;
                } else {
                    grand.next = current;
                }
                grand = start;
                current = start = start.next;
                loop = 1;
            } else {
                current = current.next;
                loop++;
            }
        }
        return head;
    }

    static ListNode  temp;

    public static ListNode reverseWithLimit(ListNode c, ListNode end) {
        if (c == end) {
            temp = end;
        } else {
            ListNode listNode = reverseWithLimit(c.next, end);
            if (temp != listNode){
                temp.next = listNode;
                temp = temp.next;
            }
        }
        return c;
    }

}
