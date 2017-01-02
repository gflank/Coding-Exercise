
public class JumpGame {
    // // dp version TLE
    // public boolean canJump(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //     	return false;
    //     }

    //     boolean[] table = new boolean[nums.length];
    //     table[0] = true;

    //     for (int i = 1; i < nums.length; ++i) {
    //     	for (int j = 0; j < i; ++j) {
    //     		if (table[j] && nums[j] + j >= i) {
    //     			table[i] = true;
    //     			break;
    //     		}
    //     		else {
    //     			table[i] = false;
    //     		}
    //     	}
    //     }

    //     return table[nums.length - 1];
    // }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        
        return true;
    }
}