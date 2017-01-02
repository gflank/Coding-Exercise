public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return res;
        }
        
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        
        int curRowNum = 1;
        List<Integer> prevRow = res;
        while(curRowNum < rowIndex + 1) {
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
            
            prevRow = curRow;
        }
        
        return prevRow;
    }
}