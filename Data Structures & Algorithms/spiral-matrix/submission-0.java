class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        List<Integer> resultlist = new ArrayList<>();

        while(left < right && top < bottom) {
            for(int i = left; i < right; i++) {
                resultlist.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i < bottom; i++) {
                resultlist.add(matrix[i][right-1]);
            }
            right--;

            if(!(top < bottom && left < right)) {
                break;
            }
            for(int i = right-1; i >= left; i--) {
                resultlist.add(matrix[bottom-1][i]);
            }
            bottom--;
            for(int i = bottom-1; i >= top; i--) {
               resultlist.add(matrix[i][left]);
            }
            left++;
        }

        return resultlist;  
    }
}
