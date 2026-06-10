class LRUCache {
    HashMap<Integer,Node> map = null;
    int capacity;
    Node first,last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
    }
    public void remove(Node n){
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }
    public void insert(Node n){
        n.next = first.next;
        n.next.prev = n;
        first.next = n;
        n.prev = first;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) remove(map.get(key));
        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
        if(map.size()>capacity){
            map.remove(last.prev.key);
            remove(last.prev);
            
        }
    }
}
class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
    public Node(){}
}
