package main;

import java.util.HashSet;
import java.util.Set;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println((0+(3-0)/2));
    }
    //3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    //704. 二分查找
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
    // 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    //28. 实现 strStr()

    //977. 有序数组的平方（双指针）
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }
    //283. 移动零
    public void moveZeroes(int[] nums) {
        int m = nums.length;
        int left = 0;
        int right = 0;
        while(right < m){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    //189. 旋转数组
    //dsafd
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        //
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    //557. 反转字符串中的单词 III(java未解决）
    public String reverseWords(String s) {
        int n = s.length();
        int left = 0,right = 0;
        while(true){
            if((" ").equals(s.charAt(right)) || right == n-1){
                for(int l = left, r = right;l < r;l++,r--){
                    char param = s.charAt(l);
                    //s.charAt(l) = s.charAt(r);
                    //s.charAt(r) = param;
                }
                left = right+1;
            }
            right++;
        }

    }

    //167. 两数之和 II - 输入有序数组(缩减搜索空间)
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{-1, -1};
    }
}
