class MyHashSet {
    boolean[] arr;
    public MyHashSet() {
        arr = new boolean[100];
    }
    
    public void add(int key) {
        if(key >= arr.length)   extend(key);
        arr[key] = true;
    }
    
    public void remove(int key) {
        if(key >= arr.length)   return;
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        if(key >= arr.length)   return false;
        return arr[key] == true;
    }
    
    public void extend(int key){
        arr = Arrays.copyOf(arr,key+1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */