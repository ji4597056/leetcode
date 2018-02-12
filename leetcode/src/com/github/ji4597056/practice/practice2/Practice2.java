package com.github.ji4597056.practice.practice2;

import com.github.ji4597056.practice.common.ListNode;

/**
 * 2.Add Two Numbers
 *
 * @author Jeffrey
 * @since 2017/11/19 20:40
 */
public class Practice2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode tmp = root, p = l1, q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int val = (p != null ? l1.val : 0) + (q != null ? q.val : 0) + carry;
            ListNode l = new ListNode(val % 10);
            carry = val / 10 > 0 ? 1 : 0;
            tmp.next = l;
            tmp = tmp.next;
            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }
        if (carry == 1) {
            tmp.next = new ListNode(1);
        }
        return root.next;
    }
}
