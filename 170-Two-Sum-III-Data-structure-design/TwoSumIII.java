
public class TwoSum {
    private HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

	public void add(int number) {
	    if (!numMap.containsKey(number)) {
	        numMap.put(number, 0);
	    }
	    else {
	        numMap.put(number, 1);
	    }
	}

	public boolean find(int value) {
	    for (int key : numMap.keySet()) {
	        int another = value - key;
	        if (numMap.containsKey(another)) {
	            if (key == another) {
	                if (numMap.get(another) == 1) {
	                    return true;
	                }
	            }
	            else {
    	            return true;	                
	            }
	        }
	    }
	    
	    return false;
	}
}
