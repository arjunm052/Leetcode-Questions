import java.util.*;

public class wordsear {
    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {
        // Traverse over the whole matrix
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // If the character is first letter of the word and we can form a word from
                // there then return true

                // count here is basically like the index of the element in the word we are
                // looking for
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        // else return false;
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, int count, String word) {
        // If we have found all the characters then just return true
        if (count == word.length()) {
            return true;
        }

        // Edge cases covering out of bounds and also when the current char is not equal
        // to the required char
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        // temporary store the char
        char temp = board[i][j];
        // replace the char with a space
        board[i][j] = ' ';
        // apply dfs on all four sides to find the remaining word
        boolean found = dfs(board, i + 1, j, count + 1, word) || dfs(board, i, j + 1, count + 1, word)
                || dfs(board, i - 1, j, count + 1, word) || dfs(board, i, j - 1, count + 1, word);
        // restore the char to its orignal place
        board[i][j] = temp;

        // return the answer
        return found;
    }
}
