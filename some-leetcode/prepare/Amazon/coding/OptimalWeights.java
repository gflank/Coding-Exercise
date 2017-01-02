import java.util.*;

public class OptimalWeights {
	public static class Container {
	    public double first;
	    public double second;

	    public Container() {
	    	first = 0;
	    	second = 0;
	    }
	}

	public Container optimalWeights(double[] weights, double capacity) {
		Container res = new Container();
		if (weights.length == 0) {
			return res;
		}
		else if (weights.length == 1) {
			res.first = weights[0];
			return res;
		}

		Arrays.sort(weights);
		double closest = 0;
		// now use two pointers to locate the closest pair
		int start = 0;
		int end = weights.length - 1;
		while (start < end) {
			double sum = weights[start] + weights[end];
			if (sum == capacity) {
				res.first = weights[start];
				res.second = weights[end];
				return res;
			}
			else if (sum < capacity) {
				if (sum > closest) {
					res.first = weights[start];
					res.second = weights[end]; 
				}
				++start;
			}
			else {
				// check both two weights seperately incase using only one is the best solution
				if (weights[start] <= capacity && weights[start] > closest) {
					closest = weights[start];
					res.first = weights[start];
					res.second = 0;
				}
				if (weights[end] <= capacity && weights[end] > closest) {
					closest = weights[end];
					res.first = weights[end];
					res.second = 0;
				}
				--end;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		OptimalWeights test = new OptimalWeights();
		double[] weights = {1, 2, 3.6, 4};
		double capacity = 5.7;
		Container res = test.optimalWeights(weights, capacity);
		System.out.println(res.first); 
		System.out.println(res.second); 
	}
}



		// // binary search the array to gain the closest value if using only one
		// int start = 0, end = weights.length - 1;
		// while (start + 1 < end) {
		// 	int mid = start + (end - start) / 2;
		// 	if (weights[mid] == capacity) {
		// 		res.first = capacity;
		// 		res.second = 0;
		// 		return res;
		// 	}
		// 	else if (weights[mid] > capacity) {
		// 		end = mid;
		// 	}
		// 	else {
		// 		start = mid;
		// 	}
		// }
		// if (weights[start] <= capacity) {
		// 	closest = weights[start];
		// 	res.first = weights[start];
		// 	res.second = 0;
		// }
		// if (weights[end] <= capacity) {
		// 	if (weights[end] > closest) {
		// 		closest = weights[end];
		// 		res.first = weights[end];
		// 		res.second = 0;
		// 	}
		// }