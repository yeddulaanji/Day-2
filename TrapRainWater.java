import java.util.*;

class Main {
    public static int trapRainwater(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 1, 0, 4};
        System.out.println(trapRainwater(arr));
    }
}
