//kth node from end of linked list
//remove duplicates in sorted linked list
//odd even linked list
//k reverse in linked list
//fold a linked list
//add two linked lists
//intersection of two linked lists

public int kthFromLast(int k) {
    // write your code here

    Node slow = this.head;
    Node fast = this.head;

    //1. maintain k gap between slow and fast
    int temp = k;

    while (temp-- > 0) {
        fast = fast.next;
    }

    while (fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow.data;

}


// T : O(n) , S : O(1)
public void removeDuplicates() {
    // write your code here
    LinkedList ans = new LinkedList();

    while (this.size > 0) {
        Node rem = this.removeFirst(0);

        if (ans.size == 0 || ans.tail.data != rem.data) {
            ans.addLast(rem);
        }
    }

    this.head = ans.head;
    this.tail = ans.tail;
    this.size = ans.size;
}



public void oddEven() {
    // write your code here

    LinkedList odd = new LinkedList();
    LinkedList even = new LinkedList();

    while (this.size > 0) {
        int data = this.head.data;

        this.removeFirst();

        if (data % 2 == 0) {
            //data -> even
            even.addLast(data);
        } else {
            //data -> odd
            odd.addLast(data);
        }
    }

    if (odd.size > 0 && even.size > 0) {
        //both odd and even content
        odd.tail.next = even.head;

        this.head = odd.head;
        this.tail = even.tail;
        this.size = odd.size + even.size;
    } 
    else if (odd.size > 0) {
        //only odd has content
        this.head = odd.head;
        this.tail = odd.tail;
        this.size = odd.size;
    } 
    else if (even.size > 0) {
        //only even has content
        this.head = even.head;
        this.tail = even.tail;
        this.size = even.size;
    }
}


public void kReverse(int k) {
    // write your code here
    LinkedList oans = new LinkedList();
    LinkedList curr = new LinkedList();

    while (this.size >= k) {
        //settle k nodes group
        for (int i = 0; i < k; i++) {
            int data = this.head.data;
            this.removeFirst();
            curr.addFirst(data);
        }

        if (oans.size == 0) {
            oans.head = curr.head;
            oans.tail = curr.tail;
            oans.size = curr.size;
        } 
        else {
            oans.tail.next = curr.head;
            oans.tail = curr.tail;
            oans.size += curr.size;
        }

        curr = new LinkedList();
    }


    //less than k nodes are left in this
    while (this.size > 0) {
        int data = this.head.data;
        this.removeFirst();
        oans.addLast(data);
    }

    this.head = oans.head;
    this.tail = oans.tail;
    this.size = oans.size;

}


public void foldHelper(Node hi, int lev) {
    if (hi == null) {
        return;
    }

    foldHelper(hi.next, lev + 1);
    int factor = (size / 2) + 1;

    if (lev > factor) {
        //swap the pointers
        Node lon = lo.next; //lo's next
        lo.next = hi;
        hi.next = lon;
        lo = lon;
    } 
    else if (lev == factor) {
        //set tail
        hi.next = null;
        this.tail = hi;
    } 
    else {
        //do nothing
    }
}

Node lo;
public void fold() {
    // write your code here
    lo = head;
    foldHelper(head, 1);
}



public static int addHelper(Node c1, Node c2, int pv1, int pv2, LinkedList ans) {
    if (c1 == null && c2 == null) {
        return 0;
    }

    int sum = 0;

    if (pv1 == pv2) {
        int oc = addHelper(c1.next, c2.next, pv1 - 1, pv2 - 1, ans);
        sum = oc + c1.data + c2.data;

    } 
    else if (pv1 > pv2) {
        int oc = addHelper(c1.next, c2, pv1 - 1, pv2, ans);
        sum = oc + c1.data;
    } 
    else {
        int oc = addHelper(c1, c2.next, pv1, pv2 - 1, ans);
        sum = oc + c2.data;
    }

    int val = sum % 10;
    int nc = sum / 10;

    ans.addFirst(val);

    return nc;
}

public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
    LinkedList ans = new LinkedList();

    int carry = addHelper(one.head, two.head, one.size - 1, two.size - 1, ans);

    if (carry == 1) {
        ans.addFirst(1);
    }

    return ans;
}



public static int findIntersection(LinkedList one, LinkedList two) {
    // write your code here
    int gap = Math.abs(one.size - two.size);
    Node p1 = one.head;
    Node p2 = two.head;

    if (one.size > two.size) {
        //move p1 gap times
        while (gap-- > 0) {
            p1 = p1.next;
        }
    } 
    else {
        //move p2 gap times
        while (gap-- > 0) {
            p2 = p2.next;
        }
    }

    while (p1 != p2) {
        p1 = p1.next;
        p2 = p2.next;
    }

    if (p1 == null && p2 == null) {
        //no intersection point
        return -1;
    }

    return p1.data;

}