class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rowValues = new ArrayList<>();
        List<HashSet<Character>> colValues = new ArrayList<>();
        List<HashSet<Character>> boxValues = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            rowValues.add(new HashSet<>());
            colValues.add(new HashSet<>());
            boxValues.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowValues.get(i).contains(board[i][j])) {
                    return false;
                }
                if (colValues.get(j).contains(board[i][j])) {
                    System.out.print("g");
                    return false;
                }
                if (boxValues.get((i / 3) * 3 + (j / 3)).contains(board[i][j])) {
                    System.out.print(board[i][j]);
                    return false;
                }
                rowValues.get(i).add(board[i][j]);
                colValues.get(j).add(board[i][j]);
                boxValues.get((i / 3) * 3 + (j / 3)).add(board[i][j]);
            }
        }
        return true;
    }
}
