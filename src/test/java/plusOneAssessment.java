import org.testng.Assert;
import org.testng.annotations.Test;


/*
Pseudo code:
1. Initialize carry to 1 to add plus to the element in array
2. Iterate the from right to left
3. compute plus one of the element
4. If the computed sum is less than 10, assign current element with computed sum and return
5. Else assign current sum as sum % 10
6. Assign carry as sum/10;
7. Initialize a final result array with given array length + 1
8. Assign 1 to first index of array and return the result
 */

/*
Time complexity: o(n)
Space complexity: o(n)
 */
public class plusOneAssessment {

    @Test
    public void test1() {
        int[] arr = {1,2,3};
        int[] expOutput = {1,2,4};
        Assert.assertEquals(plusOne(arr), expOutput);
    }

    @Test
    public void test2() {
        int[] arr = {1,1,0};
        int[] expOutput = {1,1,1};
        Assert.assertEquals(plusOne(arr), expOutput);
    }

    @Test
    public void test3() {
        int[] arr = {9,9,9};
        int[] expOutput = {1,0,0,0};
        Assert.assertEquals(plusOne(arr), expOutput);
    }


    public int[] plusOne(int[] digits) {
        int carry  = 1;

        for(int i = digits.length - 1; i>=0; i--) {
            int sum = digits[i] + carry;
            if(sum < 10) {
                digits[i] = sum;
                return digits;
            }
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
