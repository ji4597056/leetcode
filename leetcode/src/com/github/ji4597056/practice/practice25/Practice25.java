package com.github.ji4597056.practice.practice25;

import com.github.ji4597056.practice.common.ListNode;
import java.util.Stack;

/**
 * 25. Reverse Nodes in k-Group
 *
 * @author Jeffrey
 * @since 2018/02/05 13:59
 */
public class Practice25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        int n = k;
        while (tmp != null && n-- > 0) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        if (stack.size() < k) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        tmp = newHead;
        ListNode next = stack.peek().next;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        tmp.next = reverseKGroup(next, k);
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        System.out.println(reverseKGroup(head, 2).val);
    }
}
