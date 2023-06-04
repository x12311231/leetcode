package a20230603;

public class Solution {
    public static void main(String[] args) {
        int res = max("aabaa");
        assert res == 4;
        res = max("abcdef");
        assert res == 1;
        res = max("bbbcebbb");
        assert res == 4;
        res = max("eeeeakeeeeeeee");
        assert res == 9;
        res = max("aaabaacaadaaaaaaaa");
        assert res == 11;
    }

    public static int max(String ss) {
        char maxChar;
        int[] charCount = new int[26];
        Character curChar;
        int maxLen = 0;
        int curLen = 0;
        int len = ss.length();
        int i = 0;
        while (i < len) {
            curChar = ss.charAt(i);
            int endFlagCount = 0;
            while (endFlagCount < 2) {
                curLen++;

                if (++i >= len) {
                    break;
                }
                //
                charCount[ss.charAt(i) - 97]++;
                if (!curChar.equals(ss.charAt(i))) {
                    endFlagCount++;
                }
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
