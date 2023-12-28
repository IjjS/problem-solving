class MyHashMap {
    
    private int[] map;

    public MyHashMap() {
        map = new int[1000001];
    }
    
    public void put(int key, int value) {
        if (value == 0) map[key] = -1;
        
        map[key] = value + 1;
    }
    
    public int get(int key) {
        if (map[key] == -1) return 0;
        
        if (map[key] == 0) return -1;
        
        return map[key] - 1;
    }
    
    public void remove(int key) {
        map[key] = 0;
    }
}
