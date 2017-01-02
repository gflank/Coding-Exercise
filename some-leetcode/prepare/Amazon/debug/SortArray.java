public class SortArray {
	public static int[] sortArray(int arr[]) {
		int len = arr.length;
		int small, pos, i, j, temp;
		for (i = 0; i < len - 1; ++i) {
			for (j = i; j < len; ++j) {
				temp = 0;
				if (arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}
}
