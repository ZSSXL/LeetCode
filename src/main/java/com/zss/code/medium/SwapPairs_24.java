package com.zss.code.medium;

import com.zss.code.common.ListNode;
import com.zss.code.common.ListNodeUtils;

/**
 * @author ZSS
 * @date 2022/7/1 13:20
 * @desc 24 -- 两两交换链表中的节点
 */
public class SwapPairs_24 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {1, 2};
        ListNode header = ListNodeUtils.initList(nums2);
        ListNode result = swapPairs(header);
        ListNodeUtils.printList(result);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode grand;
        ListNode parent;
        ListNode current;

        grand = parent = head;
        current = head.next;

        int loop = 2;

        while (current != null){
            if (loop == 2){
                parent.next = current.next;
                current.next = parent;
                if (grand == parent){
                    head = current;
                } else {
                    grand.next = current;
                }
                loop = 0;
            } else {
                loop++;
            }
            grand = parent;
            parent = current;
            current = current.next;
        }

        return head;
    }
}
