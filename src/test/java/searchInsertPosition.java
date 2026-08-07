import org.testng.Assert;
import org.testng.annotations.Test;

public class searchInsertPosition {

    @Test
    public void test() {
       int[] nums = {1,3,5,6};
       int target = 5;
        Assert.assertEquals(searchInsertPos(nums, target), 2);
    }

    @Test
    public void test1() {
        int[] nums = {1,3,5,6};
        int target = 2;
        Assert.assertEquals(searchInsertPos(nums, target), 1);
    }

    @Test
    public void test3() {
        int[] nums = {1,3,5,6};
        int target = 7;
        Assert.assertEquals(searchInsertPos(nums, target), 4);
    }

    public int searchInsertPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2 ;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
