import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }


        //normal mid node's data
        public int mid() {
            Node slow = head;
            Node fast = head;

            while (fast.next != null && fast.next.next != null) {
                //move slow by 1
                slow = slow.next;

                //move fast by 2
                fast = fast.next.next;
            }

            return slow.data;
        }


        //merge two sorted linked lists
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            Node t1 = l1.head;
            Node t2 = l2.head;

            LinkedList ml = new LinkedList();

            while (t1 != null && t2 != null) {
                if (t1.data <= t2.data) {
                    ml.addLast(t1.data);
                    t1 = t1.next;
                } else {
                    ml.addLast(t2.data);
                    t2 = t2.next;
                }
            }

            while (t1 != null) {
                ml.addLast(t1.data);
                t1 = t1.next;
            }

            while (t2 != null) {
                ml.addLast(t2.data);
                t2 = t2.next;
            }

            return ml;
        }

        //custom mid node
        private static Node midNode(Node head, Node tail) {
            Node slow = head;
            Node fast = head;

            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }


        //merge sort on a linked list
        public static LinkedList mergeSort(Node head, Node tail) {
            if (head == tail) {
                LinkedList bl = new LinkedList();
                bl.addLast(head.data);
                return bl;
            }

            Node mid = midNode(head, tail);

            LinkedList left = mergeSort(head, mid);
            LinkedList right = mergeSort(mid.next, tail);

            LinkedList ml = mergeTwoSortedLists(left, right);

            return ml;
        }
    }

    public static void main(String[] args) {
        //input can be managed
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(9);
        list.addLast(3);
        list.addLast(5);

        list.display();

        LinkedList ml = LinkedList.mergeSort(list.head,list.tail);
        ml.display();
    }

}