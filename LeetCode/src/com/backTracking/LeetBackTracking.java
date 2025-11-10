package com.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetBackTracking {

    /*
     subset
     permutation
     word search
     N - Queens
     palindrome partitioning
     */
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int start, int[] nums, ArrayList<Integer> objects, List<List<Integer>> res) {
        res.add(new ArrayList<>(objects));
        for (int i= start;i<nums.length;i++){
            objects.add(nums[i]);
            backtrack(i+1,nums,objects,res);
            objects.removeLast();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackPermute(nums,new ArrayList<>(),res);
        return res;
    }

    private void backtrackPermute(int[] nums, ArrayList<Object> objects, List<List<Integer>> res) {
        if(objects.size()==nums.length){
            res.add(new ArrayList<>());
            return;
        }
        for (int num:nums){
            if (objects.contains(num)){
                continue;
            }
            objects.add(num);
            backtrackPermute(nums,objects,res);
            objects.removeLast();
        }
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j) {
        if(idx==word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 || board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board,word,idx+1,i+1,j)
                || dfs(board,word,idx+1,i-1,j)
                || dfs(board,word,idx+1,i,j+1)
                || dfs(board,word,idx+1,i,j-1);
        board[i][j] = temp;
        return res;

    }

        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            backtrack(s, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
            if (start == s.length()) {
                result.add(new ArrayList<>(current));
                return;
            }

            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    current.add(s.substring(start, end + 1));
                    backtrack(s, end + 1, current, result);
                    current.removeLast(); // backtrack
                }
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) return false;
            }
            return true;
        }

        public List<List<String>> solveQueens(int n){
           List<List<String>> res = new ArrayList<>();
           char[][] board = new char[n][n];
           for (char[] row : board) {
               Arrays.fill(row, '.');

           }
           backtrakQueens(0,board,res);
           return res;
        }

    private void backtrakQueens(int i, char[][] board, List<List<String>> res) {
        if (i == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] row : board) list.add(new String(row));
            res.add(list);
            return;


        }
        for (int col =0; col <board.length; col++) {
            if (isSafe(board,i,col)) {
                board[i][col] = 'Q';
                backtrakQueens(i+1,board,res);
                board[i][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for (int i=0; i< row;i++){
            if (board[i][col] == 'Q') return false;

        }
       for (int i = row-1,j=col-1; i >=0 && j>0; i--,j--) {
            if (board[i][j] == 'Q') return false;
       }
       for (int i =row-1,j=col+1; i >=0 && j<board.length;i--,j++) {
           if (board[i][j] == 'Q') return false;
       }
       return true;
    }

}



