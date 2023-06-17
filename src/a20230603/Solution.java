package a20230603;

import java.util.ArrayList;
import java.util.Collection;

public class Solution {
    public static void main(String[] args) {
        int res;
        res = max("aabaa");
        assert res == 4;
        res = max("bbbcebbb");
        assert res == 4;
        res = max("eeeeakeeeeeeee");
        assert res == 9;
        res = max("aaabaacaadaaaaaaaa");
        assert res == 11;
        res = max("abcdef");
        assert res == 1;
    }

    public static int max(String text) {
        int[] charCount = new int[26];
        for (int i = text.length() - 1; i >= 0 ; i--) {
            charCount[text.charAt(i) - 97]++;
        }
        Character curChar;
        char startChar;
        ArrayList<Character> maxChars = new ArrayList<>();
        int maxLen = 0;
        int len = text.length();
        int i = 0;
        int j = 0;
        while (j < len) {
            int curLen = 0;
            curChar = text.charAt(i);
            startChar = text.charAt(i);
            int endFlagCount = 0;
            j = i;
            while (endFlagCount < 2) {
                //
                if (!curChar.equals(text.charAt(j))) {
                    if (++endFlagCount == 1) {
                        i = j;
                    }
                } else {
                    curLen++;
                }
                if (++j >= len) {
                    break;
                }
            }
            if (curLen < maxLen) {
                continue;
            } else if (curLen > maxLen) {
                maxLen = curLen;
                maxChars.clear();
            }
            maxChars.add(startChar);
        }
        for (char c: maxChars) {
            if (charCount[c - 97] > maxLen) {
                maxLen++;
                break;
            }
        }
        return maxLen;
    }
}

/**
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text = "ababa"
 * 输出：3
 *
 * 示例 2：
 *
 * 输入：text = "aaabaaa"
 * 输出：6
 *
 * 示例 3：
 *
 * 输入：text = "aaabbaaa"
 * 输出：4
 *
 * 示例 4：
 *
 * 输入：text = "aaaaa"
 * 输出：5
 *
 * 示例 5：
 *
 * 输入：text = "abcdef"
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= text.length <= 20000
 *     text 仅由小写英文字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/swap-for-longest-repeated-character-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */