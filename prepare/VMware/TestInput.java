import java.util.*;
import java.io.*;

public class TestInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int num = Integer.parseInt(sc.nextLine());
			List<String> res = new ArrayList<>();
			for (int i = 0; i < num; ++i) {
				res.add(sc.nextLine().trim());
			}

			for (String r : res) {
				System.out.println(r);
			}
		}
	}
}