class LRUCache {
    HashMap<Integer,Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int cap,count;
    public LRUCache(int capacity) {
        cap = capacity;
        count = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null)   return -1;
        update(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        if(n == null){
            n = new Node(key,value);
            map.put(key,n);
            add(n);
            count++;
        }
        else{
            n.val = value;
            update(n);
        }
        if(count > cap){
            Node temp = tail.prev;
            remove(temp);
            map.remove(temp.key);
            count--;
        }
    }
    
    private void update(Node node){
        remove(node);
        add(node);
    }
    private void add(Node node){
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node){
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    } 
}
class Node{
    int key,val;
    Node prev, next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */