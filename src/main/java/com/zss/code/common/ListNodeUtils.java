package com.zss.code.common;

/**
 * @author ZSS
 * @date 2022/7/1 14:17
 * @desc 节点工具
 */
public class ListNodeUtils {

    public static ListNode initList(int[] vars) {
        ListNode current;
        ListNode root = current = new ListNode(vars[0]);
        if (vars.length != 1) {
            for (int i = 1; i < vars.length; i++) {
                current = insert(vars[i], current);
            }
        }
        return root;
    }

    public static void printList(ListNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printList(node.next);
        }
    }

    public static ListNode insert(int item, ListNode t) {
        t.next = new ListNode(item, null);
        return t.next;
    }
}
