public class Solution {
    // O(nk) version (refined)
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        else if (costs[0].length == 0) {
            return 0;
        }

        int color1 = -1, color2 = -1;
        for (int house = 0; house < costs.length; ++house) {
            // copy colores with min values
            int curColor1 = color1, curColor2 = color2;
            // reset the color indice
            color1 = -1;
            color2 = -1;
            for (int color = 0; color < costs[house].length; ++color) {
                int prev = 0;
                if (color != curColor1) {
                    if (house != 0) {
                        prev = costs[house - 1][curColor1];
                    }
                }
                else {
                    if (house != 0) {
                        prev = costs[house - 1][curColor2];
                    }
                }
                costs[house][color] += prev;
                
                // calculate the min values
                if (color1 < 0 || costs[house][color] < costs[house][color1]) {
                    color2 = color1;
                    color1 = color;
                }
                else if (color2 < 0 || costs[house][color] < costs[house][color2]) {
                    color2 = color;
                }
            }
        }
        
        return costs[costs.length - 1][color1];
    }

    // O(nk) version but ugly version
    // public int minCostII(int[][] costs) {
    //     if (costs.length == 0) {
    //         return 0;
    //     }
    //     else if (costs[0].length == 0) {
    //         return 0;
    //     }

    //     // go through the costs for the first house to get the min1 and min2, also color1 and color2
    //     int min1 = Integer.MAX_VALUE;
    //     int min2 = Integer.MAX_VALUE;
    //     int color1 = -1, color2 = -1;
    //     for (int color = 0; color < costs[0].length; ++color) {
    //         if (costs[0][color] < min1) {
    //             int temp = min1;
    //             int tempColor = color1;
    //             min1 = costs[0][color];
    //             color1 = color;
    //             if (temp < min2) {
    //                 min2 = temp;
    //                 color2 = tempColor;
    //             }
    //         }
    //         else if (costs[0][color] < min2) {
    //             min2 = costs[0][color];
    //             color2 = color;
    //         }
    //     }
        
    //     for (int house = 1; house < costs.length; ++house) {
    //         // copy colores with min values
    //         int curColor1 = color1;
    //         int curColor2 = color2;
    //         // reset min values
    //         min1 = Integer.MAX_VALUE;
    //         min2 = Integer.MAX_VALUE;
    //         for (int color = 0; color < costs[house].length; ++color) {
    //             if (color != curColor1) {
    //                 costs[house][color] = costs[house - 1][curColor1] + costs[house][color];
    //             }
    //             else {
    //                 costs[house][color] = costs[house - 1][curColor2] + costs[house][color];
    //             }
                
    //             // calculate the min values
    //             if (costs[house][color] < min1) {
    //                 int temp = min1;
    //                 int tempColor = color1;
    //                 min1 = costs[house][color];
    //                 color1 = color;
    //                 if (temp < min2) {
    //                     min2 = temp;
    //                     color2 = tempColor;
    //                 }
    //             }
    //             else if (costs[house][color] < min2) {
    //                 min2 = costs[house][color];
    //                 color2 = color;
    //             }
    //         }
    //     }
        
    //     return min1;
    // }
}