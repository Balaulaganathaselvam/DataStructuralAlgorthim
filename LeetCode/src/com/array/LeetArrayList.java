package com.array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LeetArrayList {

    /*
    Two Sum


     */
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    Map<Integer, Integer> map = new HashMap<>();
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public boolean palindrome(String s) {
      StringBuilder reverse = new StringBuilder();
        for (int i = s.length()-1; i > 0; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString().equals(s);
    }
    //maxSubArray

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0],currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
    public void moveZeroes(int[] nums){
       int insertPos = 0;
       for (int num : nums) {
           if (num != 0) {
               nums[insertPos++] = num;
           }
       }
       while (insertPos < nums.length) {
           nums[insertPos++] = 0;
       }
    }
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j=i; j< n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    public int trap(int[] height) {
        int n = height.length,water =0;
        int left =0, right = n-1;
        int leftMax =0,rightMax =0;
        while(left<right){
            if(height[left]<height[right]){
                if (height[left]>leftMax){
                    leftMax = height[left];
                }else{
                    water += leftMax-height[left];
                }
                left++;
            }else{
                if (height[right]>rightMax){
                    rightMax = height[right];
                }else{
                    water += rightMax-height[right];
                }
                right--;
            }

        }
        return water;

    }







}
