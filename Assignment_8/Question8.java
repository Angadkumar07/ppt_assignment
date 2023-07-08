package Assignment_8;
/* <aside>
💡 **Question 8**
Given two strings s and goal, return true *if you can swap two letters in* s *so the result is equal to* goal*, otherwise, return* false*.*
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
- For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
**Example 1:**
**Input:** s = "ab", goal = "ba"
**Output:** true
**Explanation:** You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
</aside>  */
public class Question8 {

    public boolean canBeEqualBySwapping(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int diffCount = 0;
        int[] diffIndices = new int[2];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (diffCount >= 2) {
                    return false;
                }
                diffIndices[diffCount] = i;
                diffCount++;
            }
        }

        if (diffCount != 2) {
            return false;
        }

        return s.charAt(diffIndices[0]) == goal.charAt(diffIndices[1])
                && s.charAt(diffIndices[1]) == goal.charAt(diffIndices[0]);
    }

    public static void main(String[] args) {
        Question8 solution = new Question8();
        String s = "ab";
        String goal = "ba";
        boolean canBeEqual = solution.canBeEqualBySwapping(s, goal);
        System.out.println("Can be equal by swapping: " + canBeEqual);
    }
}

