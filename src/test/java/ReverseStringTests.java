/*
Problem solving template

 1. Did I understand the problem? yes or no
  If no ask the person to provide with more details with examples
  If yes go to the next step
 No.
 Question:
 what do return when string is null or empty
 Ignore trialing and leading spaces. Honor the spaces in middle

 What is the input(s)? - String input
 What is the expected output? - reversed String out
 Do I’ve constraints to solve the problem? - No constratints
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 "Hello" o/p: "olleH"
 "Hello world" o/p: "dlroW olleH"
 negative: null or empty
 edge case:

 3. Do I know to solve it?
 Yes- great is there an alternate ?
 No - can I break the problem into sub problems?

 4. Ask for hint (if you don’t know how to solve this
 5.  Do I know alternate solutions as well
 Yes- what are those?
 No- that is still fine, proceed to solve by what you know

 Simple technique brute force

 6. If you know the alternate solution find out the O-notations (performance)
 7. Then, explain either both are the best (depends on the time)
 Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
 Approach 2: Write down the options and benefits and code the best
 8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
 -write the code
 9. Test against different test data
 10. If it fails then debug to solve it
 11. Optimize the code and remove unnecessary code*/

/*
Pseudo code:
Brute Force Approach:
1. Read the input and trim the trialing and leading spaces
2. Split the string by space if we have spaces
3. Convert each string to character array
4. Place two pointers at start and end of array
5. Swap the character between first and last pointers until we reach midpoint. Store it in a variable
6. Concatenate the final string

Algorithm - Two pointers
1. Read the input and trim the trialing and leading spaces
2. Convert the string to char array
3. Intialize two points at first and last of array in the loop
4. Skip that particular iteration if we encounter spaces
5. Swap the characters when the characters are found other than spaces */

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseStringTests {

    @Test
    public void reverseString() {
        String str = "Hello World";

        // Brute force - Fails on multiple spaces in between words
        String[] strArray = str.split(" ");

        char[] firstCharArray = strArray[0].toCharArray();
        char[] secondCharArray = strArray[1].toCharArray();

        String finalString = reverseString(firstCharArray) + " "+reverseString(secondCharArray);
        Assert.assertEquals(finalString,"olleH dlroW");
    }

    @Test
    public void TwoPointers() {
        String str2 = "     Hello     World   ";
        char[] charactersArray = str2.trim().toCharArray();

        Assert.assertEquals(reverseStringTwoPointers(charactersArray), "dlroW     olleH");
    }

    public String reverseString(char[] chars) {
        for(int i = 0,j=chars.length - 1; i<j; i++,j--) {
            char temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
        }
        return new String(chars);
    }

    public String reverseStringTwoPointers(char[] charactersArray) {
        for(int i = 0,j=charactersArray.length - 1;i<j;i++,j--) {
            if(charactersArray[i] == ' ') {
                continue;
            }else if(charactersArray[j] == ' ') {
                continue;
            }
            char tempVar = charactersArray[j];
            charactersArray[j] = charactersArray[i];
            charactersArray[i] = tempVar;
        }
        return new String(charactersArray);
    }

}
