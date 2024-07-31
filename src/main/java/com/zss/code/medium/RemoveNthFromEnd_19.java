package com.zss.code.medium;

import com.zss.code.common.ListNode;

/**
 * @author ZSS
 * @date 2021/12/8 16:04
 * @desc 19 -- 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd_19 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        ListNode listNode = removeNthFromEnd(node5, 4);
        printList(listNode);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode reverse = reverse(head);
        if (n == 1){
            reverse = reverse.next;
        } else {
            remove(reverse, reverse.next, 2, n);
        }
        return reverse(reverse);
    }


    public static void printList(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
        System.out.println("\n-----------------------");
    }

    public static void remove(ListNode pre, ListNode cur, int level, int n) {
        if (level == n){
            pre.next = cur.next;
        } else {
            remove(cur, cur.next, level + 1, n);
        }
    }

    public static ListNode reverse(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }
        ListNode reHead = reverse(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return reHead;
    }
}
