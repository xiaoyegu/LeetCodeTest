package main.demo0614;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(in.nextLine());
        int[] nums = new int[10];
        for (int i = 0; in1.hasNext(); i++) {
            nums[i] = in1.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        System.out.println(Arrays.toString(ans));
    }
}
