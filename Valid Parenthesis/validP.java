import java.util.*;

public class validP {
    public static void main(String[] args) {
        String str = "()[]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String str) {
        // If the string is of odd length it cannot ever be valid
        if (str.length() % 2 != 0)
            return false;

        Stack<Character> st = new Stack<>();

        for (char ch : str.toCharArray()) {
            // If we encounter an opening bracket just push onto the stack
            // else check if it matches the top element of stack and then pop it
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else if (ch == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            } else if (ch == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            }
            // Also return false if it not matches
            else {
                return false;
            }
        }

        // If in the end the stack is completely empty then string is valid
        return st.isEmpty();
    }
}
