package DSA_06_LinkedList;

public class LinkedList_01 {
    
    public class Node{
        int data = 0;
        Node next = null;

        Node(int data){
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0; 

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirstNode(Node node){
        if(this.size == 0){
            this.head= this.tail = node;
        }
        else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        addFirstNode(node);
    }

    private void addLastNode(Node node) {
        if (this.size == 0)
            this.head = this.tail = node;
        else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        addLastNode(node);
    }

    private Node removeFirstNode() {
        Node node = this.head;
        if (this.size == 1)
            this.head = this.tail = null;
        else {
            this.head = this.head.next;
            node.next = null;
        }

        this.size--;
        return node;
    }

    public int removeFirst() {
        if (this.size == 0)
            return -1;

        Node node = removeFirstNode();
        return node.data;
    }


     // =======================================================

     private Node getFirstNode() {
        return this.head;
    }

    public int getFirst() {
        if (this.size == 0)
            return -1;

        return getFirstNode().data;
    }

    private Node getLastNode() {
        return this.tail;
    }

    public int getLast() {
        if (this.size == 0)
            return -1;

        return getLastNode().data;
    }

    private Node getNodeAt(int idx) {
        Node curr = this.head;
        while (idx-- > 0) {
            curr = curr.next;
        }

        return curr;
    }

    public int getAt(int idx) {
        if (idx < 0 || idx >= this.size)
            return -1;

        return getNodeAt(idx).data;
    }

    public Node removeLastNode(){
        Node node = this.tail;
        if(this.size == 0){
            this.head = this.tail = null;
        }else{
            Node secondLast = getNodeAt(this.size - 2);
            secondLast.next = null;
            this.tail = secondLast;
        }
        this.size--;
        return node;
    }

    public int removeLast(){
        if(this.size == 0){
            return -1;
        }
        return removeLastNode().data;
    }

    private void addNodeAt(Node node, int idx) {
        if (idx == 0)
            addFirstNode(node);
        else if (idx == this.size)
            addLastNode(node);
        else {
            Node prevNode = getNodeAt(idx - 1);
            Node forwNode = prevNode.next;

            prevNode.next = node;
            node.next = forwNode;
            this.size++;
        }
    }

    public void addAt(int idx, int data) {
        if (idx < 0 || idx > this.size)
            return;

        Node node = new Node(data);
        addNodeAt(node, idx);
    }

    private Node removeNodeAt(int idx) {
        if (idx == 0)
            return removeFirstNode();
        else if (idx == this.size - 1)
            return removeLastNode();
        else {
            Node prevNode = getNodeAt(idx - 1);
            Node node = prevNode.next;
            Node forwNode = node.next;

            node.next = null;
            prevNode.next = forwNode;
            this.size--;

            return node;
        }

    }

    public int removeAt(int idx) {
        if (idx < 0 || idx >= this.size)
            return -1;

        return removeNodeAt(idx).data;
    }

    // LC 876
    public Node middleNode(Node head) {
        if (head == null || head.next == null)
            return head;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // LC 19
    public Node removeNthFromEnd(Node head, int n) {
        if (head == null || head.next == null)
            return null;

        Node slow = head, fast = head;
        while (n-- > 0)
            fast = fast.next;

        if (fast == null)
            return head = head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public void oddEven() {
        if (this.size == 0 || this.size == 1)
            return;
        Node even = new Node(-1); // Dummy Node
        Node ep = even;

        Node odd = new Node(-1); // Dummy Node
        Node op = odd;

        Node curr = this.head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                ep.next = curr;
                ep = ep.next;
            } else {
                op.next = curr;
                op = op.next;
            }

            curr = curr.next;
        }

        op.next = even.next;
        ep.next = null;

        this.head = odd.next;
        if (even.next != null)
            this.tail = ep;
        else
            this.tail = op;
    }

    // 206
    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node forw = curr.next; // backup

            curr.next = prev; // link

            prev = curr; // move
            curr = forw;
        }

        return prev;
    }

    // public static Node addTwoNumbers(Node l1, Node l2) {

    //     l1 = reverseList(l1);
    //     l2 = reverseList(l2);

    //     Node dummy = new Node(-1);

    //     Node c1 = l1, c2 = l2, prev = dummy;
    //     int carry = 0;
    //     while (c1 != null || c2 != null || carry != 0) {
    //         int sum = carry + (c1 != null ? c1.data : 0) + (c2 != null ? c2.data : 0);

    //         carry = sum / 10;
    //         sum %= 10;

    //         prev.next = new Node(sum);

    //         prev = prev.next;
    //         if (c1 != null)
    //             c1 = c1.next;
    //         if (c2 != null)
    //             c2 = c2.next;
    //     }

    //     Node head = dummy.next;
    //     head = reverseList(head);

    //     l1 = reverseList(l1);
    //     l2 = reverseList(l2);

    //     return head;
    // }

    public Node midNode(Node node) {
        if (node == null || node.next == null)
            return node;
        Node slow = node, fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node reverse(Node node) {
        if (node == null || node.next == null)
            return node;

        Node curr = node, prev = null;
        while (curr != null) {
            Node forw = curr.next;

            curr.next = prev;

            prev = curr;
            curr = forw;
        }

        return prev;
    }


    public void fold() {
        Node mid = midNode(head);
        Node nhead = mid.next;
        mid.next = null;

        nhead = reverse(nhead);

        Node c1 = head, c2 = nhead;
        while (c2 != null) {
            Node f1 = c1.next, f2 = c2.next;

            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }

        if (size() % 2 != 0)
            tail = mid;
        else
            tail = mid.next;
    }


    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;

        Node dummy = new Node(-1);
        Node prev = dummy, c1 = l1, c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.data <= c2.data) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;

        return dummy.next;
    }

     // 21
    //  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    //     if (l1 == null || l2 == null)
    //         return l1 != null ? l1 : l2;

    //     ListNode head = null, prev = null, c1 = l1, c2 = l2;
    //     while (c1 != null && c2 != null) {
    //         if (c1.val <= c2.val) {
    //             if (prev != null) {
    //                 prev.next = c1;
    //                 prev = prev.next;
    //             } else {
    //                 head = c1;
    //                 prev = head;
    //             }
    //             c1 = c1.next;
    //         } else {
    //             if (prev != null) {
    //                 prev.next = c2;
    //                 prev = prev.next;
    //             } else {
    //                 head = c2;
    //                 prev = head;
    //             }
    //             c2 = c2.next;
    //         }
    //     }

    //     prev.next = c1 != null ? c1 : c2;

    //     return head;
    // }

     // 148
    //  public ListNode sortList(ListNode head) {
    //     if (head.next == null)
    //         return head;

    //     ListNode mid = middleNode(head);
    //     ListNode nHead = mid.next;
    //     mid.next = null;

    //     ListNode leftSortedList = sortList(head);
    //     ListNode rightSortedList = sortList(nHead);

    //     return mergeTwoLists(leftSortedList, rightSortedList);
    // }


    // private int lengthOfLL(Node node) {
    //     if (node == null)
    //         return 0;

    //     Node curr = node;
    //     int len = 0;
    //     while (curr != null) {
    //         curr = curr.next;
    //         len++;
    //     }

    //     return len;
    // }

    // private int findIntersection(Node one, Node two) {
    //     int a = lengthOfLL(one);
    //     int b = lengthOfLL(two);

    //     Node biggerListHead = a > b ? one : two;
    //     Node smallerListHead = b < a ? two : one;
    //     int diff = Math.abs(a - b);

    //     while (diff-- > 0)
    //         biggerListHead = biggerListHead.next;

    //     while (biggerListHead != smallerListHead) {
    //         biggerListHead = biggerListHead.next;
    //         smallerListHead = smallerListHead.next;
    //     }

    //     return smallerListHead != null ? smallerListHead.data : -1;
    // }

    // public int findIntersection(linkedlist one, linkedlist two) {
    //     return findIntersection(one.head, two.head);
    // }

    public boolean IsPalindrome() {
        Node mid = midNode(head);
        Node nHead = mid.next;
        mid.next = null;

        nHead = reverse(nHead);
        Node c1 = head, c2 = nHead;
        boolean isPalindrome = true;
        while (c2 != null) {
            if (c1.data != c2.data) {
                isPalindrome = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        nHead = reverse(nHead);
        mid.next = nHead;

        return isPalindrome;
    }

    Node ptr;
    public boolean IsPalindrome(Node node) {
        if (node == null) {
            return true;
        }

        if (!IsPalindrome(node.next))
            return false;
        if (node.data != ptr.data)
            return false;

        ptr = ptr.next;
        return true;
    }

    public boolean IsPalindrome2() {
        ptr = head;
        return IsPalindrome(head);
    }
}
