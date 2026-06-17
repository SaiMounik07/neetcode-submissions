class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a, b) -> b - a;
        PriorityQueue<Integer> min = new PriorityQueue<>(c);
        for(int n:stones){
            min.offer(n);
        }
        while(min.size()>1){
            int x = min.poll();
            int y = min.poll();
            if(x == y) continue;
            if(x<y || y<x) min.offer(Math.abs(y-x));
        }
        
        if(min.size()==1) return min.peek();
        return min.isEmpty()?0:min.size();
    }
}
