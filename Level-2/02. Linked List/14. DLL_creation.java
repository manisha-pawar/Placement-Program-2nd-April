import java.util.*;

class Main {

    public static class DoublyLinkedList {
        private class Node {
            int data = 0;
            Node prev = null;
            Node next = null;

            Node(int data) {
                this.data = data;
            }

        }

        private Node head = null;
        private Node tail = null;
        private int size = 0;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node curr = this.head;
            sb.append("[");
            while (curr != null) {
                sb.append(curr.data);
                if (curr.next != null)
                    sb.append(", ");
                curr = curr.next;
            }
            sb.append("]");

            return sb.toString();
        }

        // Exceptions========================================

        private boolean ListIsEmptyException() {
            if (this.size == 0) {
                System.out.print("ListIsEmpty: ");
                return true;
            }
            return false;
        }

        private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
            if (index < leftRange || index > rightRange) {
                System.out.print("IndexIsInValid: ");
                return true;
            }
            return false;
        }

        // BasicFunctions======================================

        public int size() {
            return this.size;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        // AddFunctions======================================


        public void addFirst(int val) {
            Node nn = new Node(val);

            if (size == 0) {
                head = tail = nn;
            } else {
                nn.next = head;
                head.prev = nn;
                head = nn;
            }

            size++;
        }

        public void addLast(int val) {
            Node nn = new Node(val);

            if (size == 0) {
                head = tail = nn;
            } else {
                tail.next = nn;
                nn.prev = tail;
                tail = nn;
            }
            size++;
        }


        public void addAt(int index, int data) {
            if (indexIsInvalidException(index, 0, size) == true) {
                System.out.println("-1");
            } else if (index == 0) {
                addFirst(data);
            } else if (index == size) {
                addLast(data);
            } else {
                Node nn = new Node(data);

                Node p = getNodeAt(index); //pos node
                Node pm1 = p.prev; //position minus 1 node

                pm1.next = nn;
                nn.prev = pm1;

                nn.next = p;
                p.prev = nn;

                size++;
            }
        }

        public void addBefore(Node refNode, int data) {
            if (refNode == null) {
                return;
            } else if (refNode == head) {
                addFirst(data);
                return;
            }

            Node nn = new Node(data);
            Node rp = refNode.prev;

            rp.next = nn;
            nn.prev = rp;

            nn.next = refNode;
            refNode.prev = nn;

            size++;
        }

        public void addBefore(int idx, int data) {
            Node node = getNodeAt(idx);
            addBefore(node, data);
        }

        public void addAfter(Node refNode, int data) {
            if (refNode == null) {
                return;
            } else if (refNode == tail) {
                addLast(data);
                return;
            }

            Node nn = new Node(data);
            Node rn = refNode.next;

            refNode.next = nn;
            nn.prev = refNode;

            nn.next = rn;
            rn.prev = nn;

            size++;
        }

        public void addAfter(int idx, int data) {
            Node node = getNodeAt(idx);
            addAfter(node, data);
        }



        // RemoveFunctions======================================

        public int removeFirst() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            }

            int data = head.data;
            if (size == 1) {
                head = tail = null;
            } else {
                Node hn = head.next;
                head.next = null;
                hn.prev = null;

                head = hn;
            }
            size--;
            return data;
        }


        public int removeLast() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            }

            int data = tail.data;
            if (size == 1) {
                head = tail = null;
            } else {
                Node tp = tail.prev;
                tp.next = null;
                tail.prev = null;

                tail = tp;
            }
            size--;
            return data;
        }


        public int removeAt(int index) {
            if (indexIsInvalidException(index, 0, size - 1) == true) {
                return -1;
            } else if (index == 0) {
                return removeFirst();
            } else if (index == size - 1) {
                return removeLast();
            } else {
                Node i = getNodeAt(index);
                Node ip = i.prev;
                Node in = i.next;

                ip.next = in ; in .prev = ip;

                i.next = i.prev = null;

                size--;
                return i.data;
            }
        }

        public int removeAfter(Node refNode) {
            if (refNode == tail) {
                System.out.print("LocationIsInvalid: ");
                return -1;
            } else if (refNode == tail.prev) {
                return removeLast();
            } else {
                Node rn = refNode.next;
                Node rnn = rn.next;

                //to remove rn
                refNode.next = rnn;
                rnn.prev = refNode;

                rn.prev = rn.next = null;

                size--;
                return rn.data;

            }
        }


        public int removeAfter(int idx) {
            Node node = getNodeAt(idx);
            return removeAfter(node);
        }


        public int removeBefore(Node refNode) {
            if (refNode == head) {
                System.out.print("LocationIsInvalid: ");
                return -1;
            } else if (refNode == head.next) {
                return removeFirst();
            } else {
                Node rp = refNode.prev;
                Node rpp = rp.prev;

                //remove rp
                rpp.next = refNode;
                refNode.prev = rpp;

                rp.next = rp.prev = null;

                size--;
                return rp.data;
            }
        }

        public int removeBefore(int idx) {
            Node node = getNodeAt(idx);
            return removeBefore(node);
        }


        // getFunctions======================================

        public int getFirst() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            } else {
                return tail.data;
            }
        }

        private Node getNodeAt(int idx) {
            Node temp = head;
            int ci = 0;

            while (ci < idx) {
                temp = temp.next;
                ci++;
            }

            return temp;
        }

        public int getAt(int index) {
            if (size == 0) {
                ListIsEmptyException();
                return -1;
            }

            if (indexIsInvalidException(index, 0, size - 1) == true) {
                return -1;
            }

            Node n = getNodeAt(index);
            return n.data;
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        String str = scn.nextLine();
        while (!str.equals("stop")) {
            String[] s = str.split(" ");
            if (s[0].equals("addFirst"))
                dll.addFirst(Integer.parseInt(s[1]));
            else if (s[0].equals("addLast"))
                dll.addLast(Integer.parseInt(s[1]));
            else if (s[0].equals("removeFirst"))
                System.out.println(dll.removeFirst());
            else if (s[0].equals("removeLast"))
                System.out.println(dll.removeLast());
            else if (s[0].equals("getFirst"))
                System.out.println(dll.getFirst());
            else if (s[0].equals("getLast"))
                System.out.println(dll.getLast());
            else if (s[0].equals("size"))
                System.out.println(dll.size());
            else if (s[0].equals("isEmpty"))
                System.out.println(dll.isEmpty());
            else if (s[0].equals("getAt"))
                System.out.println(dll.getAt(Integer.parseInt(s[1])));
            else if (s[0].equals("addAt"))
                dll.addAt(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            else if (s[0].equals("removeAt"))
                dll.removeAt(Integer.parseInt(s[1]));
            else if (s[0].equals("addBefore"))
                dll.addBefore(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            else if (s[0].equals("addAfter"))
                dll.addAfter(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            else if (s[0].equals("removeAfter"))
                System.out.println(dll.removeAfter(Integer.parseInt(s[1])));

            str = scn.nextLine();
        }

        System.out.println(dll);
    }
}