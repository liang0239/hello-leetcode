package leetcode.p_recursion;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//
// 示例 2：
//
//
//输入：head = [], val = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [7,7,7,7], val = 7
//输出：[]
//
//
//
//
// 提示：
//
//
// 列表中的节点数目在范围 [0, 104] 内
// 1 <= Node.val <= 50
// 0 <= val <= 50
//
// Related Topics 递归 链表
// 👍 652 👎 0


import leetcode.ListNode;

/**
 * @author LH
 * @create 2021-07-02 15:19
 * @description
 **/
public class P203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null){
            return head;
        }
        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        P203 p = new P203();

    }
}
