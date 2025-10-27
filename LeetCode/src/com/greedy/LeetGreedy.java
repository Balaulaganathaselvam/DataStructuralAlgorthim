package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetGreedy {

    /*
     jump Game
     gas station
     merge intervals
     non overlapping intervals
     assign cookies
     */
    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums){
        int reachable =0;
        for (int i=0;i < nums.length;i++){
            if (i > reachable) return false;
            reachable=Math.max(reachable,i+nums[i]);
        }
        return true;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0,curr =0,start =0;
        for (int i=0; i<gas.length; i++){
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0){
                start = i+1;
                curr = 0;
            }
        }
        return total < 0?-1:start;
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else{
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        return res.toArray(new int[res.size()][]);
    }

    public int eraseOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int end = intervals[0][1],count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else{
                end = intervals[i][1];
            }
        }
        return count;
    }

    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookies = 0;
        while (child < g.length && cookies < s.length){
            if (g[child] >= s[cookies]) child++;
            else cookies++;
        }
        return child;
    }
}
