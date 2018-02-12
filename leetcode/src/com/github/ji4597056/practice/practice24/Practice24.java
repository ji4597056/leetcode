package com.github.ji4597056.practice.practice24;

import com.github.ji4597056.practice.common.ListNode;

/**
 * 24. Swap Nodes in Pairs
 *
 * @author Jeffrey
 * @since 2018/02/03 17:08
 */
public class Practice24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;
        return second;
    }
}
