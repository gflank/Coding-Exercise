// Repeated DNA Sequences Total Accepted: 17893 Total Submissions: 91409 My Submissions Question Solution 
// All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

// For example,

// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].
// Hide Tags Hash Table Bit Manipulation

import java.util.*;

public class DNA {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> result = new ArrayList<String>();
    	if (s == null || s.length() == 0) {
    		return result;
    	}

    	HashMap<Integer, Integer> dnaMap = new HashMap<Integer, Integer>();
    	String temp;
    	int dnaKey;
    	for (int i = 0; i < s.length() - 9; ++i) {
    		temp = s.substring(i, i + 10);
    		dnaKey = d2i(temp);
    		if (!dnaMap.containsKey(dnaKey)) {
    			dnaMap.put(dnaKey, 1);
    		}
    		else {
    			if (dnaMap.get(dnaKey) == 1) {
    				result.add(temp);
    				dnaMap.put(dnaKey, dnaMap.get(dnaKey) + 1);
    			}
    		}

    	}

    	return result;
	}

	private int d2i(String dna) {
		int res = 0;
		int temp = 0;
		for (int i = 0; i < dna.length(); ++i) {
			if (dna.charAt(i) == 'A') {
				temp = 1;
			}
			else if (dna.charAt(i) == 'C') {
				temp = 2;
			}
			else if (dna.charAt(i) == 'G') {
				temp = 3;				
			}
			else if (dna.charAt(i) == 'T') {
				temp = 4;				
			}
			res = res * 10 + temp;
		}

		return res;
	}

	public static void main(String[] args) {
		DNA A = new DNA();
		String s = "AAAAAAAAAAA";
		System.out.println(A.findRepeatedDnaSequences(s));
	}
}
