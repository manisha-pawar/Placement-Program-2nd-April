class LRUCache {

    static class ListNode {
        int key; //app name
        int value; //app state
        ListNode prev;
        ListNode next;
        
        ListNode() {
            
        }
        
        ListNode(int key,int value) {
            this.key = key;
            this.value = value;
        } 
    }
    
    HashMap<Integer,ListNode>map; //app name vs node
    
    //doubly linked list
    ListNode head;
    ListNode tail;
    int size;
    
    int limit = 0;
    
    public LRUCache(int capacity) {
        limit = capacity;
        map = new HashMap<>();
    }
    public int get(int key) {
        //key -> app name
         if(map.containsKey(key) == false) {
            //app is not present yet
            return -1;
        }
        else {
            //app is already present
            ListNode node = map.get(key);
            
            //make this app most recent
            remove(node);
            addLast(node);
            
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        //key -> app name
        //value -> app state
        
        if(map.containsKey(key) == false) {
            //app is not present yet
            
            ListNode node = new ListNode(key,value);
            map.put(key,node);
            
            addLast(node);
            
            if(size > limit) {
                //delete the least recent app
                int hd = removeFirst(); //head's data
                map.remove(hd);
            }
        }
        else {
            //app is already present
            ListNode node = map.get(key);
            
            //make this app most recent
            remove(node);
            addLast(node);
            
            node.value = value;
        }
    }
    
    //doubly linked list functions
    private void addLast(ListNode node) {
        if(size == 0) {
            head = tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            
            tail = node;
        }
        size++;
    }
    

    private void remove(ListNode node) {
        if(size == 0) {
            return;
        }
        else if(node == head) {
            removeFirst();
        }
        else if(node == tail) {
            removeLast();
        }
        else {
            ListNode tp = node.prev;
            ListNode tn = node.next;
            
            //to remove node
            tp.next = tn;
            tn.prev = tp;
            
            node.next = node.prev = null;
            
            size--;
        }
    }
    
    private int removeFirst() {
        if(size == 0) {
            return -1;
        }
       
        int data = head.key;
        
        if(size == 1) {
            head = tail = null;
        }
        else {
            ListNode hn = head.next;
            
            head.next = null;
            hn.prev = null;
            
            head = hn;
        }
        size--;
        return data;
    }
    
    private int removeLast() {
        if(size == 0) {
            return -1;
        }
       
        int data = tail.key;
        
        if(size == 1) {
            head = tail = null;
        }
        else {
            ListNode tp = tail.prev;
            
            tp.next = null;
            tail.prev = null;
            
            tail = tp;
        }
        size--;
        return data;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */