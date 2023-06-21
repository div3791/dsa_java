package sliding_window;

public class LargestSubArrayOfSumK {
    public int largestSubArrayOfSumK(int[] input, int k) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0, j = 0;

        while (j < input.length && i < input.length) {
            if (input[j] < 0) {
                sum -= input[j];
            } else {
                sum += input[j];
            }
            if (sum == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (sum < k) {
                j++;
            } else if (sum > k) {
                while (sum > k) {
                    if (input[i] < 0) {
                        sum = sum + input[i];
                    } else {
                        sum = sum - input[i];
                    }
                    i++;
                }
                j++;
            }
        }

        return max;
    }
}
