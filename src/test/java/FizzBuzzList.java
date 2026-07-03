/*
Problem solving template

Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.

 1. Did I understand the problem? yes

 What is the input(s)? - integer
 What is the expected output? - String array with value as per given conditions
 Do I’ve constraints to solve the problem? - No

 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well - No

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
Approach:
1. Declare a array list of string type
2. Run a loop from 1 to n times as given input
3. Add "FizzBuzz" to list if number is divisible by 3 and 5
4. Add "Fizz" to list if number is divisible by 3
5. Add "Buzz" to list if number is divisible by 5
6. If none of the condition matches convert the integer to string and add it to arraylist.
*/


import java.util.ArrayList;
import java.util.List;

public class FizzBuzzList {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            if(i%3==0 && i%5== 0) {
                list.add("FizzBuzz");
            } else if(i%3==0) {
                list.add("Fizz");
            } else if(i%5==0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;

    }
}
