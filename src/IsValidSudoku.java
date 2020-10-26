import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, char[]> h = new HashMap<>();
        Map<Integer, char[]> z = new HashMap<>();
        Map<Integer, char[]> hz = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            h.put(i, board[i]);
            char[] chars = new char[9];
            for (int j = 0; j < 9; j++) {
                chars[j] = board[j][i];
            }
            z.put(i, chars);
        }
        for (int index = 0; index < 9; index++) {
            for (int i = 0; i < 3; i++) {
                char[] chars = new char[9];
                if (hz.get(index) != null) {
                    System.arraycopy(hz.get(index), 0, chars, 0, 9);
                }
                for (int j = 0; j < 3; j++) {
                    chars[i * 3 + j] = board[i + (index / 3) * 3][(index % 3) * 3 + j];
                }
                hz.put(index, chars);
            }
        }
        for (Map.Entry<Integer, char[]> integerEntry : hz.entrySet()) {
            for (char c : integerEntry.getValue()) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        return check(hz);
    }
    public boolean check(Map<Integer, char[]> map) {
        for (Map.Entry<Integer, char[]> entry : map.entrySet()) {
            char[] value = entry.getValue();
            Set<Integer> nums = new HashSet<>();
            for (char c : value) {
                if (Character.isDigit(c)) {
                    int num = c;
                    if (nums.contains(num)) {
                        return false;
                    } else {
                        nums.add(num);
                    }
                }
            }
        }
        return true;
    }

}
