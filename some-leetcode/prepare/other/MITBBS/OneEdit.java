// unfinshed

import java.util.*;

public class OneEdit {
	public boolean isDistanceZeroOrOne(String a, String b) {
		boolean insert = true, remove = true, replace = true;
		char preA, preB;

		int indexA = 0, indexB = 0;
		int lenA = a.length(), lenB = b.length();
		int diff = 0;

		while (indexA < lenA && indexB < lenB) {
			char curA = a.charAt(indexA);
			char curB = b.charAt(indexB);
			++indexA;
			++indexB;

			if (diff == 1) {
				if (curA != curB) {
					replace = false;
				}
				if (curA != preB) {
					remove = false;
				}
				if (curB != preA) {
					insert = false;
				}
				if (!replace && !remove && ! insert) {
					return false;
				}
			}

			if (diff == 0) {
				if (curA != curB) {
					++diff;
				}
			}

			if (diff == 1) {
				preA = curA;
				preB = curB;
			}
		}

		if (indexA == lenA && indexB == lenB) {
			return (diff == 0) || replace;
		}
		if (indexA != lenA && remove) {
			char curA = a.charAt(indexA);
			++indexA;
			if (indexA != lenA) {
				remove = false;
				break;
			}
			if (curA != preB) {
				remove = false;
			}
		}
		if (indexB != lenB) {
			char curB = b.charAt(indexB);
			++indexB;
			if (indexB != lenB) {
				insert = false;
				break;
			}
			if (curB != preA) {
				insert = false;
			}
		}

	}
}
