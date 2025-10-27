package com.string;

import java.util.*;

public class LeetString {

    /*
  isAnagram
  LongestPalindromic
  group anagram
  Longest common prefix
  roman to integer
     */
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s){
        int maxLen = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j+1);
                if (isPalindrome(sub) && sub.length() > maxLen){
                    result = sub;
                    maxLen = sub.length();
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String sub) {
        int left = 0;
        int right = sub.length() - 1;
        while (left < right) {
            if (sub.charAt(left++) != sub.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome2(String s){
        if (s== null || s.isEmpty()) return "";
        int start =0,end=0;
        for (int i=0; i<s.length(); i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int lenn = Math.max(len1,len2);
            if (lenn > end-start){
                start = i - (lenn-1)/2;
                end = i+lenn/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]){
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            visited[i] = true;
            for (int j=i+1; j < strs.length; j++) {
                if (!visited[j] && isAnagram(strs[i],strs[j])) {
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(list);
        }
        return result;
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I',1,'V',5,'X',10,'L',50,'C',100, 'D',500,'M',1000
        );
        int sum =0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i +1 < s.length() && val < map.get(s.charAt(i+1))) {
                sum -= val;
            }else{
                sum += val;
            }

        }
        return sum;
    }


}
