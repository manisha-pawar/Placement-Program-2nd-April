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
            Node nn = new Node();
            nn.data = val;
            nn.next = null;

            if (size == 0) {
                //linked list is empty
                head = nn;
                tail = nn;
            } else {
                tail.next = nn;
                tail = nn;
            }
            size++;
        }

        public int size() {
            return size;
        }

        public void display() {
            Node temp = this.head;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }


        public void addFirst(int val) {
            Node nn = new Node();
            nn.data = val;
            nn.next = null;

            if (size == 0) {
                //linked list is empty
                head = tail = nn;
            } else {
                nn.next = head;
                head = nn;
            }
            size++;
        }


        public Node getNodeAt(int idx) {
            Node temp = head;

            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }

            return temp;
        }

        public void addAt(int idx, int val) {
            if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else {
                //idx -> 1 to size-1
                Node nn = new Node();
                nn.data = val;
                nn.next = null;

                Node im1n = getNodeAt(idx - 1); //idx-1 node
                nn.next = im1n.next;
                im1n.next = nn;

                size++;
            }
        }


        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node idxn = getNodeAt(idx); //idx node
                return idxn.data;
            }
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                Node hn = head.next;
                head.next = null;
                head = hn;
                size--;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                Node sln = getNodeAt(size - 2); //second last node

                sln.next = null;
                tail = sln;
                size--;
            }
        }

        public void removeAt(int idx) {
            if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else {
                Node im1n = getNodeAt(idx - 1); //idx-1 node
                im1n.next = im1n.next.next;
                size--;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        //input can be managed
    }
}