
import java.util.*;

public class FractionRec {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
        	return "";
        }
        if (numerator == 0) {
        	return "0";
        }
        
        long num, den;
        String result = "";
        int pos = 0;
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
        	result += "-";
        	++pos;
        }
    	num = Math.abs((long)numerator);
    	den = Math.abs((long)denominator);
        long remain, cur;
        cur = num / den;
        remain = num % den;
        result += cur;
        if (remain == 0) {
        	return result;
        }

        //store as <remain, position>
        HashMap<Long, Integer> remainSet = new HashMap<>();

        // calculate the pos now
        long dividend = 10;
        int length = 1;
        while (cur / dividend != 0) {
        	++length;
        	dividend *= 10;
        }
        pos += length + 1;

        remainSet.put(remain, pos);
        
        result += ".";
        // do the imitation of division
        num -= cur * den;
        num *= 10;

        while (remain != 0) {
        	++pos;
	        remain = num % den;
	        cur = num / den;
	        if (remainSet.containsKey(remain)) {
	        	pos = remainSet.get(remain);
	        	result = result.substring(0, pos) + "(" + result.substring(pos) + cur + ")";
	        	break;
	        }
	        remainSet.put(remain, pos);

	        result += cur;
            num -= cur * den;
	        num *= 10;
        }

        return result;
    }

    public static void main(String args[]) {
    	FractionRec a = new FractionRec();
    	// System.out.println(a.fractionToDecimal(2, 3));
    	// System.out.println(a.fractionToDecimal(2, -3));
    	// System.out.println(a.fractionToDecimal(2147483647, 370000));
    	System.out.println(a.fractionToDecimal(-1, -2147483648));
    }
}
