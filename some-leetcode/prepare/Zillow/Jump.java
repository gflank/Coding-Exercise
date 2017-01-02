import java.util.*;

// backtacking version, improved version, fixed first jump distance
public class Jump {
	private int[] river;
	private List<Integer> stones;

	public boolean jump(int[] river) {
		if (river.length <= 1)
			return true;

		this.river = river;

		// scan to record stone position
		stones = new ArrayList<Integer>();
		for (int i = 0; i < river.length; ++i) {
			if (river[i] == 1)
				stones.add(i);
		}
		if (stones.size() == 1)
			return true;

		// start from the second stone
		return helper(1, 0, 1);
	}

	private boolean helper(int prevDistance, int prevStone, int curStone) {
		// if reach the very end
		if (curStone == stones.size()) {
			if (checkValid(prevDistance, river.length - stones.get(prevStone)))
				return true;
			return false;
		}

		for (int i = curStone; i < stones.size(); ++i) {
			if (checkValid(prevDistance, stones.get(i) - stones.get(prevStone))) {
				if (helper(stones.get(i) - stones.get(prevStone), i, i + 1))
					return true;
			}
		}

		return false;
	}

	private boolean checkValid(int prevDistance, int curDistance) {
		if (curDistance == prevDistance)
			return true;
		else if (curDistance - prevDistance == 1)
			return true;
		else if (curDistance - prevDistance == -1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Jump test = new Jump();
		// int[] river = {1, 0};
		// int[] river = {1, 1, 0, 1, 0, 0, 1, 0};
		int[] river = {1, 1, 0, 1, 0, 0, 0, 1, 0};
		System.out.println(test.jump(river));
	}
}

// --------------------------------------------------------------------


	// weiran solution
	// public boolean isReachable(int[] array) {
	// 	if (array == null || array.length == 0) return false;
	// 	List<HashSet<Integer>> setList = new ArrayList<HashSet<Integer>>();
	// 	for (int i = 0; i <= array.length; i++) {
	// 		setList.add(new HashSet<Integer>());
	// 	}
	// 	setList.get(0).add(1);
	// 	for (int i = 0; i < array.length; i++) {
	// 		if (array[i] != 1) continue;
	// 		for (int prevStep : setList.get(i)) {
	// 			for (int currStep = prevStep - 1; currStep <= prevStep + 1; currStep++) {
	// 				if (i + currStep <= array.length) setList.get(i + currStep).add(currStep);
	// 			}
	// 		}
	// 	}
	// 	return setList.get(array.length).size() != 0;
	// }


// --------------------------------------------------------------------

// // backtacking version, needed to be verified and improved
// public class Jump {
// 	private int[] river;
// 	private boolean foundStone = false;

// 	public boolean jump(int[] river) {
// 		if (river.length <= 1)
// 			return true;

// 		this.river = river;
// 		return helper(-1, 0, 1);
// 	}

// 	private boolean helper(int prevDistance, int prevPos, int curPos) {
// 		// if reach the very end
// 		if (curPos == river.length) {
// 			// if first jump or valid
// 			if (prevPos == 0 || checkValid(prevDistance, curPos - prevPos))
// 				return true;
// 			return false;
// 		}

// 		for (int i = curPos; i < river.length; ++i) {
// 			// if encounter a stone
// 			if (river[i] == 1) {
// 				foundStone = true;
// 				// if first jump or valid
// 				if (prevPos == 0 || checkValid(prevDistance, i - prevPos)) {
// 					if (helper(i - prevPos, i, seekNext(i + 1)))
// 						return true;
// 				}
// 			}
// 		}

// 		// if no another stone
// 		if (!foundStone) {
// 			return true;
// 		}
// 		return false;
// 	}

// 	// need to prevent this function being called
// 	private int seekNext(int begin) {
// 		for (int i = begin; i < river.length; ++i) {
// 			if (river[i] == 1)
// 				return i;
// 		}
// 		return river.length;
// 	}

// 	private boolean checkValid(int prevDistance, int curDistance) {
// 		if (curDistance == prevDistance)
// 			return true;
// 		else if (curDistance - prevDistance == 1)
// 			return true;
// 		else if (curDistance - prevDistance == -1)
// 			return true;
// 		return false;
// 	}

// 	public static void main(String[] args) {
// 		Jump test = new Jump();
// 		// int[] river = {1, 0};
// 		// int[] river = {1, 1, 0, 1, 0, 0, 1, 0};
// 		int[] river = {1, 1, 0, 1, 0, 0, 0, 1, 0};
// 		System.out.println(test.jump(river));
// 	}
// }

// --------------------------------------------------------------------

//stack version, failed
// public class Jump {
// 	public boolean jump(int[] river) {
// 		int len = river.length;
// 		boolean dp = new boolean[len + 1];
// 		Stack<Integer> stack = new Stack<>();

// 		// set all positions with stones to true in dp table
// 		for (int i = 0; i < len; ++i) {
// 			if (river[i] == 1) {
// 				dp[i] = true;
// 			}
// 		}

// 		stack.push(0); // first stone position
// 		int prevPos = 0, prevJump = 0;
// 		for (int i = 1; i < len; ++i) {
// 			// if encounter stone
// 			if (dp[i] == true) {
// 				// if first jump or satisfy rule, continue
// 				if (prevJump == 0 || checkValid(prevJump, i - prevPos)) {
// 					stack.push(i);
// 				}
// 				// if invalid, try other stones
// 				else {

// 				}
// 			}
// 		}
// 	}

// 	private boolean checkValid(int prev, int cur) {
// 		if (cur == prev) {
// 			return true;
// 		}
// 		else if (cur - prev == 1) {
// 			return true;
// 		}
// 		else if (cur - prev == -1) {
// 			return true;
// 		}
// 		return false;
// 	}
// }

