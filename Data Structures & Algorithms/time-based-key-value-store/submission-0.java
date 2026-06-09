class TimeMap {
HashMap<String,List<Pair<Integer,String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer,String> pair = new Pair(timestamp,value);
        map.computeIfAbsent(key, k ->new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values = map.getOrDefault(key,new ArrayList<>());
        int l = 0,r = values.size()-1;
        String rs = "";
        while(l<=r){
            int m = (l+r)/2;
            if(values.get(m).getT() <= timestamp){
                rs = values.get(m).getV();
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return rs;
    }
}
class Pair<T,V>{
    private final T t;
    private final V v;
    public Pair(T t,V v){
        this.t = t;
        this.v = v;
    }
    public T getT(){
        return t;
    }
    public V getV(){
        return v;
    }
}
