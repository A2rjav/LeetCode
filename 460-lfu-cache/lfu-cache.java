class LFUCache {
    class Node{
        int key,value,freq;
        Node prev,next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    class DLL{
        Node head,tail;
        int size;
        DLL(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;   
            size = 0;
        }
        public void add(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        public void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }
        public Node removeLast(){
            if(size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, DLL> freqMap = new HashMap<>();
    int minFreq,capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        updateDLL(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            updateDLL(node);
        }else{
            if(map.size() == capacity){
                DLL list = freqMap.get(minFreq);
                Node removal = list.removeLast();
                map.remove(removal.key);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            minFreq = 1;
            freqMap.putIfAbsent(minFreq,new DLL());
            freqMap.get(minFreq).add(newNode);
        }
    }
    public void updateDLL(Node node){
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);

        if(freq == minFreq && list.size == 0){
            minFreq++;
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq,new DLL());
        freqMap.get(node.freq).add(node);
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */