package Search;


public class Problem79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y += 1) {
            for (int x = 0; x < board[y].length; x += 1) {
                if (exist(board, y , x, w, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int y, int x, char[] word, int i, boolean[][] visited) {
        if (i == word.length) {
            return true;
        }
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }
        if (visited[y][x]) {
            return false;
        }
        if (board[y][x] != word[i]) {
            return false;
        }
        visited[y][x] = true;
        if (exist(board, y, x - 1, word, i + 1, visited) ||
                exist(board, y, x + 1, word, i + 1, visited) ||
                exist(board, y - 1, x, word, i + 1, visited) ||
                exist(board, y + 1, x, word, i + 1, visited)) {
            return true;
        } else {
            visited[y][x] = false;
            return false;
        }
    }
}
