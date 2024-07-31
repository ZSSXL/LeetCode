package com.zss.code.easy;

import com.zss.code.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZSS
 * @date 2021/12/9 11:25
 * @desc 21 -- 合并两个有序链表
 */
public class MergeTwoLists {

    /**
     * l1 = [1,2,4], l2 = [1,3,4] 输出：[1,1,2,3,4,4]
     * 执行耗时:6 ms,击败了5.67% 的Java用户
     * 内存消耗:37.9 MB,击败了20.94% 的Java用户
     */
    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode listNode = mergeTwoLists(l1, l2);
        printList(listNode);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> value = getValue(list1);
        value.addAll(getValue(list2));
        List<Integer> collect = value.stream().sorted().collect(Collectors.toList());
        return valueToNode(collect);
    }

    public static ListNode valueToNode(List<Integer> target) {
        int size = target.size();
        if (size == 0) {
            return null;
        }

        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        for (int i = 0; i < size; i++) {
            assert cur != null;
            cur.val = target.get(i);
            if (i != size - 1) {
                cur.next = new ListNode(0);
            } else {
                cur.next = null;
            }
            cur = cur.next;
        }
        return pre;
    }

    public static List<Integer> getValue(ListNode listNode) {
        List<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return new ArrayList<>();
        }
        while (listNode.next != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        result.add(listNode.val);
        return result;
    }


    public static void printList(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.print(temp.val + ",\t");
            temp = temp.next;
        }
        System.out.println("\n-----------------------");
    }

}
