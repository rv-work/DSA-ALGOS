// class LRUCache {
//     private final int capacity;
//     private final HashMap<Integer, Integer> cache;
//     private final LinkedHashSet<Integer> usage;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         this.cache = new HashMap<>();
//         this.usage = new LinkedHashSet<>();
//     }
//     public int get(int key) {
//         if (!cache.containsKey(key)) {
//             return -1;
//         }
//         // Move the accessed key to the end to show that it was recently used
//         usage.remove(key);
//         usage.add(key);
//         return cache.get(key);
//     }
//     public void put(int key, int value) {
//         if (cache.containsKey(key)) {
//             // Remove the old key to update its position in usage
//             usage.remove(key);
//         } else if (cache.size() >= capacity) {
//             int lruKey = usage.iterator().next();
//             usage.remove(lruKey);
//             cache.remove(lruKey);
//         }
//         cache.put(key, value);
//         usage.add(key);
//     }
// }



class LRUCache {

    class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    public Node[] map;
    public int count, capacity;
    public Node head, tail;

    public LRUCache(int capacity) {
        this.capacity= capacity;
        count= 0;
        
        map= new Node[10_000+1];
        
        head= new Node(0,0);
        tail= new Node(0,0);
        
        head.next= tail;
        tail.prev= head;
        
        head.prev= null;
        tail.next= null;
    }

    public void deleteNode(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;       
        
        return;
    }
    
    public void addToHead(Node node){
        node.next= head.next;
        node.next.prev= node;
        node.prev= head;
        
        head.next= node;      
        
        return;
    }
    
    public int get(int key) {
        if( map[key] != null ){
            
            Node node= map[key];
            
            int nodeVal= node.value;
            
            deleteNode(node);
            
            addToHead(node);
            
            return nodeVal;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map[key] != null){
            
            Node node= map[key];
            
            node.value= value;
            
            deleteNode(node);
            
            addToHead(node);
            
        } else {
            
            Node node= new Node(key,value);
            
            map[key]= node;
            
            if(count < capacity){
                count++;
                addToHead(node);
            } 
            else {
                
                map[tail.prev.key]= null;
                deleteNode(tail.prev);
                
                addToHead(node);
            }
        }
        
        return;
    }
}




/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */