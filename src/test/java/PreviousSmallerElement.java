import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class PreviousSmallerElement {

    @Test
    public void test1() {
        int[] arr = {1,6,2};
        int[] expOutput = {-1,1,1};
        Assert.assertEquals(prevSmallerElement(arr), expOutput);
    }

    @Test
    public void test2() {
        int[] arr = {1,5,5,3,2,2,4};
        int[] expOutput = {-1, 1, 1, 1, 1, 1, 2};
        Assert.assertEquals(prevSmallerElement(arr), expOutput);
    }

    public int[] prevSmallerElement(int[] arr) {
        int min  = -1;
       int[] result = new int[arr.length];
       int k = 0;
        Stack<Integer> s =  new Stack<>();
//        5,4,3,2,1;
        for(int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && s.peek() >= arr[i]) {
                s.pop();
            }

            if(s.empty()) {
               result[i] = -1;
            } else {
                result[i] = s.peek();
            }

            s.push(arr[i]);
        }


        return result;

    }
}
