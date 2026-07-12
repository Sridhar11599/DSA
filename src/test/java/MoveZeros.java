import org.testng.Assert;

public class MoveZeros {

    public void test1() {
        int[] nums = {0,1,0,3,12};
        int[] expectedOutput = {1,3,12,0,0};
        Assert.assertEquals(moveZeroes(nums),expectedOutput);

    }

    public int[] moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j<nums.length; j++) {
            if(nums[j]!=0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return nums;
    }
}
