class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
       int[][] a = new int[n][2];
       for(int i = 0;i<n;i++){
            a[i][0] = position[i];
            a[i][1] = speed[i];
       }
       Arrays.sort(a,(p,q)-> Integer.compare(q[0],p[0]) );
       double p = (double)(target-a[0][0])/a[0][1];
       int f = 1;
       for(int i = 1;i<n;i++){
        double c = (double)(target - a[i][0])/a[i][1];
            if(c>p){
                f++;
                p = c;
            }
       }
       return f;
    }
}
