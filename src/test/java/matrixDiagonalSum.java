/*
Problem solving template

Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements
on the secondary diagonal that are not part of the primary diagonal.

 1. Did I understand the problem? yes

 What is the input(s)? - the input is 2D array of integers
 What is the expected output? - integer -sum of diagonal elements
 Do I’ve constraints to solve the problem? - No

 Do Ive all the information to go to the next steps - Yes
 How big is your test data set will be?

 2. Test data set
 Minimum  3 data set including positive, negative and edge
 Validate with the interviewer if the data set is fine by his/ her assumptions

 positive:
 Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

 negative: 2D Array empty?

 edge case:
 Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Input: mat = [[5]]
Output: 5

 3. Do I know to solve it? - Yes

 4. Ask for hint (if you don’t know how to solve this) - No
 5.  Do I know alternate solutions as well - No.

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
1. Return the only integer present if the 2D array has length 1;
2. Compute the length of the 2D array
3. If the length of the array is odd deduct the overlapping index from final answer
4. Iterate the 2D array for sum the first diagonal and second diagonal values
5. return the result array after deduction if overlapping integer is noted.
 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class matrixDiagonalSum {

    @Test
    public void test() {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int expectedOutput = 25;
        Assert.assertEquals(diagonalSum(mat),expectedOutput);
    }
    @Test
    public void test1() {
        int[][] mat = {{5}};
        int expectedOutput = 5;
        Assert.assertEquals(diagonalSum(mat),expectedOutput);
    }

    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        if(mat.length == 1) return mat[0][0];

        for(int i = 0; i<mat.length;i++) {
            ans = ans + mat[i][i] + mat[i][n - i - 1];
        }

        if(mat.length % 2 != 0) {
            int mid = 0;
            mid = (mat.length / 2);
            ans = ans - mat[mid][mid];
        }

        return ans;
    }
}
