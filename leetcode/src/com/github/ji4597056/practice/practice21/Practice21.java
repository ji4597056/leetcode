package com.github.ji4597056.practice.practice21;

import com.github.ji4597056.practice.common.ListNode;

/**
 * 21. Merge Two Sorted Lists
 *
 * @author Jeffrey
 * @since 2018/02/01 10:24
 */
public class Practice21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode traverse = head;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                traverse.next = p;
                p = p.next;
            } else {
                traverse.next = q;
                q = q.next;
            }
            traverse = traverse.next;
        }
        if (p != null) {
            traverse.next = p;
        }
        if (q != null) {
            traverse.next = q;
        }
        return head.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

}
