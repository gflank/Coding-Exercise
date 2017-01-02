import java.util.*;

public class DayChange {
	public static int[] change(int[] cells, int days) {
		if (cells.length <= 0 || days <= 0) {
			return null;
		}
		else if (cells.length == 1) {
			cells[0] = 0;
			return cells;
		}

		for (int i = 0; i < days; ++i) {
			int prev = cells[0];
			// the first cell depends on next one
			cells[0] = cells[1];
			for (int j = 1; j < cells.length - 1; ++j) {
				int temp = cells[j];
				if (prev != cells[j + 1]) {
					cells[j] = 1;
				}
				else {
					cells[j] = 0;
				}
				prev = temp;
			}
			// the last cell depends on the second last cell
			cells[cells.length - 1] = prev;
		}
		return cells;
	}

	public static void main(String[] args) {
		int[] cells = {1, 0, 0, 0, 0, 1, 0, 0};
		int days = 1;
		cells = DayChange.change(cells, days);
		for (int n : cells) {
			System.out.printf("%d ", n);
		}
		System.out.println("");
	}
}