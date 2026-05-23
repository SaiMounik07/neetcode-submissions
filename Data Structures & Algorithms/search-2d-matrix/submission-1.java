class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length ;
        int n = matrix[0].length;
        int t = 0;
        for(int i = 0;i<m;i++){
            if(matrix[i][0]<= target && matrix[i][n-1]>=target){
                t = i;
            }
        }
        for(int i = 0;i<n;i++){
            if(matrix[t][i] == target) return true;  
        }
        return false;
    }
}
