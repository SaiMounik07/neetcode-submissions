class Solution {
    public int[] productExceptSelf(int[] nums) {
        int m = 1;
        boolean b = false;
        int c = 0;
        for(int num : nums){
            if(num != 0){
                m*=num;
            }else{
                b = true;
                c++;
            }
        }
        if(c >1){
            m = 0;
        }
        int[] a = new int[nums.length];
        int  i = 0;
        for(int n : nums){
            if(!b){
                if(n != 0){
                    a[i] = m/n;
                    i++;
                }
            }else{
                if(n == 0){
                     a[i] = m;
                     i++  ; 
                }else{
                    a[i] = 0;
                    i++;
                }
            }
        }
        return a;
    }
}  
