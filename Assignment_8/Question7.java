package Assignment_8;
/*  <aside>
💡 **Question 7**
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
**Example 1:**
**Input:** s = "3[a]2[bc]"
**Output:** "aaabcbc"
</aside> */
import java.util.Stack;

public class Question7 {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);

            if (Character.isDigit(ch)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (ch == '[') {
                stringStack.push(result.toString());
                result = new StringBuilder();
                index++;
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(result);
                }
                result = temp;
                index++;
            } else {
                result.append(ch);
                index++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Question7 solution = new Question7();
        String s = "3[a]2[bc]";
        String decodedString = solution.decodeString(s);
        System.out.println("Decoded string: " + decodedString);
    }
}
