package com.zss.code.hard;

import com.zss.code.common.ListNode;
import com.zss.code.common.ListNodeUtils;

/**
 * @author ZSS
 * @date 2022/6/13 13:43
 * @desc 23 -- 合并k个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKList_23 {

    public static void main(String[] args) {
        /*
        lists = [[1,4,5],[1,3,4],[2,6]] 输出：[1,1,2,3,4,4,5,6]
         */
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};
        ListNode list1 = ListNodeUtils.initList(nums1);
        ListNode list2 = ListNodeUtils.initList(nums2);
        ListNode list3 = ListNodeUtils.initList(nums3);
        ListNode[] lists = {list1, list2, list3};
        ListNode listNode = mergeKLists(lists);
        ListNodeUtils.printList(listNode);
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 1) {
            return lists[0];
        }

        ListNode mergeResult = getCurrentMin(lists);
        ListNode current = mergeResult;

        for (; ; ) {
            ListNode minNode = getCurrentMin(lists);
            if (minNode == null) {
                break;
            }
            current.next = minNode;
            current = current.next;
        }
        return mergeResult;
    }

    /**
     * 找到当前最小值，然后将该节点后移
     *
     * @return node
     */
    private static ListNode getCurrentMin(ListNode[] lists) {
        int index = -1;
        ListNode min = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (min == null) {
                min = lists[i];
                index = i;
                continue;
            }

            if (min.val > lists[i].val) {
                min = lists[i];
                index = i;
            }
        }
        if (index != -1) {
            lists[index] = lists[index].next;
        }
        return min;
    }
}
