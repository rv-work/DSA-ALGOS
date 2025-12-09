class Solution {
    public boolean isValidSudoku(char[][] board) {
    Set seen = new HashSet();
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            if (board[i][j] != '.') {
                String b = "(" + board[i][j] + ")";
                if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                    return false;
            }
        }
    }
    return true;
}
}



class Solution {
    public boolean isValidSudoku(char[][] board) {
        return check(board, 0, 0);
    }

    private boolean check(char[][] board, int row, int col) {

        // ✅ End of board
        if (row == 9) return true;

        // ✅ Move to next row
        if (col == 9) return check(board, row + 1, 0);

        // ✅ Skip filled cell
        if (board[row][col] != '.') {
            return check(board, row, col + 1);
        }

        // ✅ Try placing 1 to 9
        for (char ch = '1'; ch <= '9'; ch++) {

            if (isSafe(board, row, col, ch)) {
                board[row][col] = ch;

                if (check(board, row, col + 1))
                    return true;

                board[row][col] = '.'; // 🔁 backtrack
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {

        // ✅ Row & Column check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }

        // ✅ 3x3 Box check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num)
                    return false;
            }
        }

        return true;
    }
}



class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (row[i][num] || col[j][num] || box[boxIndex][num])
                    return false;

                row[i][num] = true;
                col[j][num] = true;
                box[boxIndex][num] = true;
            }
        }

        return true;
    }
}



class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;

                char curr = board[i][j];

                // Check Row
                for (int col = 0; col < 9; col++) {
                    if (col != j && board[i][col] == curr) return false;
                }

                // Check Column
                for (int row = 0; row < 9; row++) {
                    if (row != i && board[row][j] == curr) return false;
                }

                // Check 3x3 Box
                int startRow = (i / 3) * 3;
                int startCol = (j / 3) * 3;

                for (int r = startRow; r < startRow + 3; r++) {
                    for (int c = startCol; c < startCol + 3; c++) {
                        if ((r != i || c != j) && board[r][c] == curr)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}

