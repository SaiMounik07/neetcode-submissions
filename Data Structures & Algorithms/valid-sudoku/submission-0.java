class Solution {
    public boolean isValidSudoku(char[][] nums) {
        Set<String> set = new HashSet<>();
        for(int  i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                char ch =  nums[i][j];
                if(nums[i][j] == '.') continue;
                String row = ch + "r" + i;
                String col = ch + "c" + j;
                String box = ch + "b" + ((i / 3) * 3 + (j / 3));

                // If already exists -> invalid sudoku
                if (!set.add(row) ||
                    !set.add(col) ||
                    !set.add(box)) {

                    return false;
                }
            }
        }
        return true;
    }
}
