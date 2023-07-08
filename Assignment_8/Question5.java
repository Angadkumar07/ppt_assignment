package Assignment_8;
/*  <aside>
💡 **Question 5**
Given an array of characters chars, compress it using the following algorithm:
Begin with an empty string s. For each group of **consecutive repeating characters** in chars:
- If the group's length is 1, append the character to s.
- Otherwise, append the character followed by the group's length.
The compressed string s **should not be returned separately**, but instead, be stored **in the input character array chars**. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
After you are done **modifying the input array,** return *the new length of the array*.
You must write an algorithm that uses only constant extra space.
**Example 1:**
**Input:** chars = ["a","a","b","b","c","c","c"]
**Output:** Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
**Explanation:**
The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
</aside> */
public class Question5 {

    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }

        int index = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1];

                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1;
            }
        }

        chars[index++] = chars[chars.length - 1];

        if (count > 1) {
            String countStr = String.valueOf(count);
            for (char c : countStr.toCharArray()) {
                chars[index++] = c;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Question5 solution = new Question5();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int newLength = solution.compress(chars);

        System.out.println("New length: " + newLength);
        System.out.print("Compressed array: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print("'" + chars[i] + "'");
            if (i != newLength - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

