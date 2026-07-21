import org.testng.Assert;
import org.testng.annotations.Test;

public class SumOfBinaryString {

    @Test
    public void test() {
        String a = "11";
        String b = "1";
        String expectedOuput = "100" ;
        Assert.assertEquals(addBinary(a,b),expectedOuput);

    }

    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        StringBuilder s = new StringBuilder();
        while (indexA >=0 || indexB >=0 || carry > 0) {
            int digitA = indexA>=0 ? a.charAt(indexA) - '0' : 0;
            int digitB = indexB>=0 ? b.charAt(indexB) - '0' : 0;
            int sum = digitA + digitB + carry;
            int rem = sum % 2;
            s.append(String.valueOf(rem));
            carry = sum / 2;
            indexA--;
            indexB--;
        }
        return s.reverse().toString();
    }
}
