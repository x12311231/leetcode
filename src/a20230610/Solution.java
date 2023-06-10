package a20230610;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.numSmallerByFrequency(new String[]{"abc", "aaa"}, new String[]{"icfs", "dfafawefffsfs", "dsfasd"});
        for (int i: ints) {
            System.out.println(i);
        }

    }
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //int[] counterQueries = new int[queries.length];
        int[] counterWords = new int[words.length];
        int[] result = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            counterWords[i] = this.f(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            //counterQueries[i] = f(queries[i]);
            int countQuery = this.f(queries[i]);
            for (int cw: counterWords) {
                if (cw > countQuery) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    public int f(String s) {
        int[] counter = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            counter[s.charAt(i) - 97]++;
        }
        for (int i: counter) {
            if (i != 0) {
                return i;
            }
        }
        return 0;
    }
}
