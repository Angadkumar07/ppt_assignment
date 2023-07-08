package Assignment_8;
/*  <aside>
💡 **Question 2**
Given a string s containing only three types of characters: '(', ')' and '*', return true *if* s *is **valid***.
The following rules define a **valid** string:
- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
**Example 1:**
**Input:** s = "()"
**Output:**
true
</aside> */
import java.util.Stack;

public class Question2 {

    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }

    public static void main(String[] args) {
        Question2 solution = new Question2();
        String s = "()";
        boolean isValid = solution.checkValidString(s);
        System.out.println("Is the string valid? " + isValid);
    }
}
