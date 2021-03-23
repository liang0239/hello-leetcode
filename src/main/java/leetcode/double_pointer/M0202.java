package leetcode.double_pointer;
//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//
// 注意：本题相对原题稍作改动
//
// 示例：
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4
//
// 说明：
//
// 给定的 k 保证是有效的。
// Related Topics 链表 双指针
// 👍 63 👎 0



import leetcode.ListNode;

public class M0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        while (p1 != null){
            if (k > 0){
                p1 = p1.next;
                k--;
            }else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        if (k > 0){
            return -1;
        }

        return p2.val;
    }

    public static void main(String[] args) {
        M0202 sou = new M0202();



    }
}
