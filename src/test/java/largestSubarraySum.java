import org.testng.Assert;
import org.testng.annotations.Test;

public class largestSubarraySum {

    @Test
    public void test1() {
        int[] nums = {2, 3, 4, 5};
        Assert.assertEquals(subArraySumKadane(nums),14);
    }

    public int subArraySumKadane(int[] arr) {
        int currSum = arr[0];
        int maxSum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            currSum = currSum + arr[i];
            currSum = Math.max(currSum, arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
