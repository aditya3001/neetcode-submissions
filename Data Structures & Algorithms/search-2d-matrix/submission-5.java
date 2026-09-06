class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int searchRowIndex = rowIndexBinarySearch(matrix, target, 0, matrix.length - 1);
        if (searchRowIndex == -1) return false;
        return rowBinarySearch(matrix, searchRowIndex, target, 0, matrix[0].length - 1);

        
    }

    public int rowIndexBinarySearch(int[][] matrix, int target, int start, int end) {

        if (start > end) return end;

        int mid = start + (end - start)/2;
        // if (mid == start) return start;
        if (matrix[mid][0] > target) {
            return rowIndexBinarySearch(matrix, target, start, mid-1);
        } else {
            return rowIndexBinarySearch(matrix, target, mid+1, end);
        }
    }

    public boolean rowBinarySearch(int[][] matrix, int index, int target, int start, int end) {

        if (start > end) return false;

        int mid = start + (end - start)/2;
        if (matrix[index][mid] > target) {
            return rowBinarySearch(matrix, index, target, start, mid - 1);
        } else if (matrix[index][mid] < target) {
            return rowBinarySearch(matrix, index, target, mid+1, end);
        } else {
            return true;
        }
    }
}


//  4 -> 1,0
// 10 -> 2,2
