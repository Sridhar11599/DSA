import org.testng.Assert;
import org.testng.annotations.Test;

public class DietPlanPerformance {

    @Test
    public void test1() {
        int[] nums={1,2,3,4,5};
        int k = 1;
        int lower = 3;
        int upper = 3;
        Assert.assertEquals(dietPlan(nums,k,lower,upper),0);
    }

    @Test
    public void test2() {
        int[] nums={3,2};
        int k = 2;
        int lower = 0;
        int upper = 1;
        Assert.assertEquals(dietPlan(nums,k,lower,upper),1);
    }

    @Test
    public void test3() {
        int[] nums={6,5,0,0};
        int k = 2;
        int lower = 1;
        int upper = 5;
        Assert.assertEquals(dietPlan(nums,k,lower,upper),0);
    }

    public int dietPlan(int[] cal, int k, int lower, int upper) {

        int count = 0;
        if(k == 1) {
            for(int i = 0; i < cal.length; i++) {
                if(cal[i] > upper) {
                    count++;
                } else if (cal[i] < lower) {
                    count--;
                }
            }
            return count;
        }

        int left = 0;
        int right = 0;
        int calSum = 0;

        for(int i = 0; i < k; i++) {
            calSum+=cal[i];
        }
        if(calSum > upper) {
            count++;
        } else if(calSum < lower) {
            count--;
        }

        for(int i = k; i < cal.length; i++) {
            calSum+=cal[i];
            calSum = calSum - cal[i-k];
            if(calSum > upper) {
                count++;
            } else if(calSum < lower) {
                count--;
            }
        }
        return count;
    }
}
