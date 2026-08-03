import org.testng.Assert;
import org.testng.annotations.Test;

public class FindMinimumInSortedArray {

//    @Test
//    public void test() {
//        int[] nums = {3, 4, 5, 1, 2};
//        Assert.assertEquals(findMinimum(nums),1);
//    }

//    @Test
//    public void test1() {
//        int[] nums = {4,5,6,7,0,1,2};
//        Assert.assertEquals(findMinimum(nums),0);
//    }

    @Test
    public void test2() {
        int[] nums = {11,13,15,17};
        Assert.assertEquals(findMinimum(nums),11);
    }

    /**
     * Intution:
     *  - since the array is rotated at pivot index, we will have two distinct upward slopes [4,5,6,7] [0,1,2]
     *  - inflection point is where there is sharp dip or change between two increasing slope curves
     *  - Rule 1: All the elements that are left of inflection point (4,5,6,7) are greater than the first element of array 4
     *  - Rule2 : All elements that are right to the inflection part (0,1,2) are lesser than the first element of array 4
     *  Algo: use binary search for O(logn)
     *  - define two pointers low=0, high=nums.length-1
     *  - if the array is sorted and not rotated, nums[0]<=nums[nums.length-1] then return nums[low]
     *  - while low and high are not meeting on the same point
     *      - compute mid point
     *      - if mid is greater than mid+1, i.e its rotated probably at mid+1 and nums[mid+1] be likely the smallest element
     *      - if the mid is less than mid-1 i.e its rotated probably at mid and nums[mid] be likely the smallest element
     *      - based above intution
     *          - if the nums[mid]<= nums[low], you have to skip right part and move right high=mid-1;
     *          - else low=mid+1
     * @param nums
     * @return
     */


    public int findMinimum(int[] nums) {
        int low=0, high=nums.length-1;
        if(nums[low]<=nums[high]) return nums[low];
        while (low<=high){
            int mid= low+(high-low)/2;
            if(mid!= nums.length-1 && nums[mid]>nums[mid+1]) return nums[mid+1];
            else if(mid!=0 && nums[mid]<nums[mid-1]) return nums[mid];
            else if(nums[mid]<=nums[0]) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}
