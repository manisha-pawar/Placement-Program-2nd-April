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

        private Node getNodeAt(int idx) {
            Node temp = head;

            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }

            return temp;
        }


        //reverse data iterative
        public void reverseDI() {
            int li = 0;
            int ri = size - 1;

            Node ln = head;

            while (li < ri) {
                Node rn = getNodeAt(ri);
                
                //swap data of left node and right node
                int temp = ln.data;
                ln.data = rn.data;
                rn.data = temp;

                ln = ln.next;
                li++;
                ri--;
            }
        }


        //reverse pointer iterative
        public void reversePI() {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                //backup
                Node next = curr.next;
                //reverse link
                curr.next = prev;
                //move
                prev = curr;
                curr = next;
            }

            //swap head,tail
            Node temp = head;
            head = tail;
            tail = temp;
        }
    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }
}