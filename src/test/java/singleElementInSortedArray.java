import org.testng.Assert;
import org.testng.annotations.Test;

public class singleElementInSortedArray {

    @Test
    public void test() {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int expOutput = 2;
        Assert.assertEquals(singleNonDuplicate(nums),expOutput);
    }


    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // Edge case: The unique element is at the very beginning
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        // Edge case: The unique element is at the very end
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int low = 1;
        int high = nums.length - 2;
        while(low<=high) {
            int mid  = low + (high - low) /2 ;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            if(mid % 2 == 0) {
                if(nums[mid] != nums[mid+1]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(nums[mid]!=nums[mid-1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
