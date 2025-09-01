class LFUCache {
    class Node{
        int key,val,freq;
        Node prev,next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    class DoublyLinkedList{
        Node head,tail;
        int size;
        DoublyLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size =0;
        }
        void add(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast(){
            if(size>0){
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }
    int capacity,minFreq;
    HashMap<Integer,Node> map = new HashMap<>(); //key -> node
    HashMap<Integer,DoublyLinkedList> freqMap = new HashMap<>(); // freq -> DoublyLinkedList

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            updateFreq(node);
        }else{
            if(map.size() == capacity){
                DoublyLinkedList list= freqMap.get(minFreq);
                Node removal = list.removeLast();
                map.remove(removal.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode );
            minFreq = 1;
            freqMap.putIfAbsent(1,new DoublyLinkedList());
            freqMap.get(1).add(newNode);
        }
    }
    void updateFreq(Node node){
        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(node.freq);
        oldList.remove(node);
        if(oldFreq == minFreq && oldList.size == 0){
            minFreq++;
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq,new DoublyLinkedList());
        freqMap.get(node.freq).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */