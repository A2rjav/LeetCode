class LRUCache {
    class Node{
        Node prev,next;
        int key,val;
        Node(int k,int v){
            key = k;
            val = v;
        }
    }
    HashMap<Integer,Node> map = new HashMap<>();
    Node head,tail;
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);

        remove(node);
        insertToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            insertToHead(node);
        }else{
            if(map.size() == size){
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            insertToHead(node);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insertToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node; 
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */