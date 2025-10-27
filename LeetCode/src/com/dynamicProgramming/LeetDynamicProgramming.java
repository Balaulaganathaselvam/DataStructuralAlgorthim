package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetDynamicProgramming {

    /*
    climbing stairs
    House robber
    coin change
    LongestIncrease subsequence
    edit distance
     */
    public static void main(String[] args) {

    }
    public int climbStairs(int n){
        if(n<2){
            return n;
        }
        int first = 1;
        int second =2;
        for (int i= 3;i <=n; i++){
            int temp = first+second;
            first = second;
            second = temp;
        }
        return second;
    }

    public int rob(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int prev1 = 0,prev2 = 0;
        for(int num:nums){
            int temp = prev1;
            prev1 = Math.max(prev1,prev2+num);
            prev2 = temp;
        }
        return prev1;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i-coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? dp[amount] : 0;
    }
    public int longestSubsequence(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j=0;j < i;j++){
                if (nums[i] > nums[j]){
                   dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int num:dp){
            max = Math.max(max,num);
        }
        return max;
    }
    public int lengthOfLIS(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int num:nums){
            int i = Collections.binarySearch(list, num);
            if (i < 0) {
                i = -(i + 1);

            }
            if (i == list.size()) list.add(num);
            else list.set(i,num);
        }
        return list.size();
    }
    public int editDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }

        }
     return dp[m][n];
    }


}
