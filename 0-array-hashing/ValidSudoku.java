/**
 * https://neetcode.io/problems/valid-sudoku/question
 * 
 * You are given a 9 x 9 Sudoku board board. A Sudoku board is valid if the following rules are followed:
 * Each row must contain the digits 1-9 without duplicates.
 * Each column must contain the digits 1-9 without duplicates.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without duplicates.
 * Return true if the Sudoku board is valid, otherwise return false
 * Note: A board does not need to be full or be solvable to be valid.
 * 
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> r = new HashMap<>();
        Map<Integer, Set<Character>> c = new HashMap<>();
        Map<String, Set<Character>> s = new HashMap<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                String sk = i/3 + "_" + j/3;
                
                if (r.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                    c.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                    s.computeIfAbsent(sk, k -> new HashSet<>()).contains(board[i][j])) {
                    return false;
                }

                r.get(i).add(board[i][j]);
                c.get(j).add(board[i][j]);
                s.get(sk).add(board[i][j]);
            }
        }

        return true;
    }
}
