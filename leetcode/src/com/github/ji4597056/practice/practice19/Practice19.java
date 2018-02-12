package com.github.ji4597056.practice.practice19;

import com.github.ji4597056.practice.common.ListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 19. Remove Nth Node From End of List
 *
 * @author Jeffrey
 * @since 2018/01/31 11:33
 */
public class Practice19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> store = new HashMap<>();
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            store.put(++len, tmp);
            tmp = tmp.next;
        }
        if (n < 0 || n > len) {
            throw new IllegalArgumentException();
        }
        if (n == len) {
            return head.next;
        }
        if (n == 1) {
            store.get(len - 1).next = null;
        }
        store.get(len - n).next = store.get(len - n + 2);
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 双层遍历
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode slow = newHead;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
