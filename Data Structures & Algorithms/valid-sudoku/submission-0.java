class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] blocks = new int[9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int curNum = board[r][c] - '0';
                int curNumMasked = 1 << (curNum - 1);
                int b = (r / 3) * 3 + c / 3;

                if ((rows[r] & curNumMasked) != 0) return false;
                if ((cols[c] & curNumMasked) != 0) return false;
                if ((blocks[b] & curNumMasked) != 0) return false;

                rows[r] |= curNumMasked;
                cols[c] |= curNumMasked;
                blocks[b] |= curNumMasked;
            }
        }

        return true;
    }
}
