import org.testng.Assert;
import org.testng.annotations.Test;

/*
Pseudo code:
1. Compute the length of two strings indexA and indexB
2. initialize carry to 0
3. Initialize a string builder to append the results to the string
4. Iterate over given strings from last index to the first index
5. Compute the ascii value for each character in string a and String b
    Ex: "11"
    ascii value = ascii('1') - ascii('0) => 49 - 48 = 1
    If the index goes below the bounds assign it to 0 =>
    Ex: 11 + 1 will be computed as 11+01 = 100

6. Compute the Sum the digits

// Note: The sum or addition of binary digits will always result in 2 or 1 which can further manipulated
with % and / operation

7. Compute reminder and append it to the string
    Ex: adding 1 + 1 = 2 => 2%2 = 0
        adding 1 + 0 = 1 => 1%2 = 1
8. Compute carry by sum/2
    Ex: 1 + 1 = 2/2 = 1
        1 + 0 = 1 => 0
9. Decrement the index of string a and b
10. Revert the result string as return the result
 */

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
