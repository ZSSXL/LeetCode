package com.zss.code.medium;

import com.zss.code.common.ListNode;
import com.zss.code.common.ListNodeUtils;

/**
 * @author ZSS
 * @date 2022/6/8 14:50
 * @desc 给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class Partition {

    private static ListNode root;

    public static void main(String[] args) {
        // int[] values = {};
        int[] values = {1,4,3,2,5,2};
        ListNodeUtils.initList(values);
        ListNode listNode = partitionV2(root, 2);
        ListNodeUtils.printList(listNode);
    }

    public static ListNode partitionV2(ListNode head, int x){
        ListNode pre = new ListNode();
        ListNode tail = new ListNode();

        ListNode preTemp = pre;
        ListNode tailTemp = tail;

        while (head != null){
            ListNode temp = new ListNode(head.val);
            if (head.val < x){
                preTemp.next = temp;
                preTemp = preTemp.next;
            } else {
                tailTemp.next = temp;
                tailTemp = tailTemp.next;
            }
            head = head.next;
        }
        preTemp.next = tail.next;
        return pre.next;
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode flag, current;
        flag = current = head;
        while (current != null && current.next != null) {
            if (current.next.val < x) {
                // 比x小
                if (flag.next.val < x && flag.val < x){
                    //current = current.next;
                    flag = flag.next;
                } else {
                    ListNode temp = current.next;
                    current.next = current.next.next;
                    ListNode tempB = flag.next;
                    flag.next = temp;
                    flag.next.next = tempB;
                    flag = flag.next;
                }
            }
            // 大于或等于x
            current = current.next;
        }

        return head;
    }

}
