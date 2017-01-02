public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        
        // first row
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        res.add(firstRow);
        if (numRows == 1) {
            return res;
        }
        
        int curRowNum = 1;
        List<Integer> prevRow = null;
        while(curRowNum < numRows) {
            curRowNum++;
            List<Integer> curRow = new ArrayList<Integer>();
            for (int i = 0; i < curRowNum; ++i) {
                if (i == 0 || i == curRowNum - 1) {
                    curRow.add(1);
                }
                else {
                    curRow.add(prevRow.get(i - 1) + prevRow.get(i));
                }
            }
            
            res.add(curRow);
            
            prevRow = curRow;
        }
        
        return res;
    }
}