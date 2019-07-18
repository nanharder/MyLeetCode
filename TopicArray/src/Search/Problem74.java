package Search;

public class Problem74 {
    public boolean searchMatrixV1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int low = 0;
        int high = matrix.length - 1;
        int end = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] > target) {
                high = mid - 1;
            } else if (matrix[mid][end] < target) {
                low = mid + 1;
            } else {
                break;
            }
        }
        int pos;
        if (high < 0 || low >= matrix.length) {
            return false;
        } else {
            pos = low + (high - low) / 2;
        }

        low = 0;
        high = end;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[pos][mid] > target) {
                high = mid - 1;
            } else if (matrix[pos][mid] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int len = matrix[0].length;
        int low = 0;
        int high = matrix.length * len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid / len][mid % len] > target) {
                high = mid - 1;
            } else if (matrix[mid / len][mid % len] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
