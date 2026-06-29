/*
Problem solving template

 1. Did I understand the problem? yes

 What is the input(s)? - the input string is given as an array of character
 What is the expected output? - reversed String as array of character
 Do I’ve constraints to solve the problem? - array of characters not null
 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 ['h','e','l','l','o'] o/p: ['o','l','l','e','h']
 negative: cannot be null
 edge case:
 ['H','e','l','l','o'] o/p: ['o','l','l','e','H']
 retain the case sensitive

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well
 Yes. Two pointers

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
1. Declare a result array with length of given input char array
2. Iterate the loop in reverse (Start from last)
3. Initialize index = 0;
4. Insert all the characters in result array starting from index 0 and increment the index.
5. return the reversed result array

Algorithm - Two pointers
1. Place two points at start and end of array.
2. Swap the characters until i < j
3. return the final reversed array
 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseStringInArray {

    @Test
    public void reverseStringBruteForceApproach() {
        String[] s = {"h","e","l","l","o"};
        String[] expectedOutput = {"o","l","l","e","h"};
        Assert.assertEquals(reverseCharsBruteForce(s), expectedOutput);
    }

    @Test
    public void reverseStringTwoPointersApproach() {
        String[] s = {"h","e","l","l","o"};
        String[] expectedOutput = {"o","l","l","e","h"};
        Assert.assertEquals(reverseStringTwoPointers(s), expectedOutput);
    }

    public String[] reverseStringTwoPointers(String[] str) {
        if(str.length == 0) throw new RuntimeException("String array cannot be empty");
        for(int i = 0,j = str.length - 1; i<j; i++,j--) {
            String temp = str[j];
            str[j] = str[i];
            str[i] = temp;
        }
        return str;
    }


    public String[] reverseCharsBruteForce(String[] chars) {
        String[] result = new String[chars.length];
        int index = 0;
        for(int i = chars.length - 1; i >=0; i--) {
            result[index] = chars[i];
            index++;
        }
        return result;
    }
}
