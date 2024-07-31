package com.zss.code;

import com.zss.code.common.ListNode;

import java.math.BigDecimal;

/**
 * @author ZSS
 * @date 2021/11/25 10:10
 * @desc 2 -- 两数相加
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        String v1 = "9";
        String v2 = "199999999";
        // 89990001
        ListNode node = valueToNode(v1);
        ListNode node2 = valueToNode(v2);
        // ListNode node4 = addTwoNumbers(node, node2);
        ListNode node5 = addTwoNumberV2(node, node2);
        printList(node5);
        System.out.println("=================");
    }

    // 方法1
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                cur.val += l1.val;
            }

            if (l2 != null) {
                cur.val += l2.val;
            }
            int arr = 0;
            if (cur.val > 9) {
                arr = cur.val / 10;
                cur.val = cur.val % 10;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (l1 == null && l2 == null && arr == 0){
                cur.next = null;
            } else {
                cur.next = new ListNode(arr);
            }

            cur = cur.next;
        }
        return pre;
    }

    // 方法2
    public static ListNode addTwoNumberV2(ListNode l1, ListNode l2) {
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);
        BigDecimal value1 = getValue(reverse1);
        BigDecimal value2 = getValue(reverse2);
        ListNode node = valueToNode(value1.add(value2).toString());
        return reverse(node);
    }


    public static void printList(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode valueToNode(String value) {
        int[] intArray = new int[value.length()];
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            intArray[i] = Integer.parseInt(Character.toString(ch));
        }
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        for (int j = 0; j < intArray.length; j++) {
            cur.val = intArray[j];
            if (j != intArray.length - 1) {
                cur.next = new ListNode(0);
            } else {
                cur.next = null;
            }
            cur = cur.next;
        }

        return pre;
    }

    public static BigDecimal getValue(ListNode listNode) {
        if (listNode == null) {
            return new BigDecimal("0");
        }
        String value = String.valueOf(listNode.val);
        while (listNode.next != null) {
            value += listNode.next.val;
            listNode = listNode.next;
        }
        return new BigDecimal(value);
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