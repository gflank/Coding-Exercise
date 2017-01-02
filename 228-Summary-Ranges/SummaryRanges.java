
import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
        	return result;
        }

        if (nums.length == 1) {
        	String temp = "";
        	temp += nums[0];
        	result.add(new String(temp));
        	return result;
        }

        int curRange = 1;
        int lastHead = nums[0];
        for (int i = 1; i < nums.length; ++i) {
        	if (nums[i - 1] + 1 < nums[i]) {
        		if (curRange == 1) {
		        	String temp = "";
        			temp += nums[i - 1];
        			result.add(new String(temp));
        		}
        		else {
        			String temp = "";
        			temp += lastHead + "->" + nums[i - 1];
        			result.add(new String(temp));
        		}
    			lastHead = nums[i];
    			curRange = 1;
        	}
        	else {
        		++curRange;	
        	}
        }

        if (curRange == 1) {
        	String temp = "";
			temp += nums[nums.length - 1];
			result.add(new String(temp));
		}
		else {
			String temp = "";
			temp += lastHead + "->" + nums[nums.length - 1];
			result.add(new String(temp));
		}

        return result;
    }

    public static void main(String[] args) {
    	SummaryRanges test =  new SummaryRanges();
    	int[] nums = {0, 1, 2, 4, 5, 7};
    	List<String> result = test.summaryRanges(nums);
    	for (String element : result) {
    		System.out.println(element);
    	}
    }
}
