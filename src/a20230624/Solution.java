package a20230624;

import java.util.ArrayList;

class Solution {

    public int[][] layout(int m, int n, int[] member) {
        int[][] ret = new int[m][n];
        int sIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = member[sIndex++];
            }
        }
        return ret;
    }

    public int[][] getMembers(int m, int n, int introvertsCount, int extrovertsCount) {
        int over = Math.max(0, (introvertsCount + extrovertsCount) - m * n);
        int[][] members = new int[over + 1][m * n];
        for (int j = 0; j <= over; j++) {
            int[] member = new int[m * n];
            for (int i = 0; i < introvertsCount - j; i++) {
                member[i] = 1;
            }
            for (int i = introvertsCount - j; i < extrovertsCount + introvertsCount - over; i++) {
                member[i] = 2;
            }
            members[j] = member;
        }
        return members;
    }

    public ArrayList<int[][]> getAllLayout(int m, int n, int introvertsCount, int extrovertsCount) {
        ArrayList<int[][]> layout = new ArrayList<>();
        int[][] members = getMembers(m, n, introvertsCount, extrovertsCount);
        for (int[] member: members) {
            layout.add(layout(m, n, member));
            for (int i = 0; i < m * n; i++) {
                for (int j = i; j < m * n; j++) {
                    int[] seederCpy = new int[member.length];
                    System.arraycopy(member, 0, seederCpy, 0, member.length);
                    do {
                        if (j + 1 >= m * n) {
                            break;
                        }
                        if (seederCpy[i] != seederCpy[++j]) {
                            int tmp = seederCpy[i];
                            seederCpy[i] = seederCpy[j];
                            seederCpy[j] = tmp;
                            break;
                        }
                    } while (seederCpy[i] == seederCpy[j]);
                    layout.add(layout(m, n, seederCpy));
                }
            }
        }
        return layout;
    }
    public int getScore(int m, int n, int i, int j, int[][] layout) {
        if (layout[i][j] == 0) {
            return 0;
        }
        int[] initScores = new int[]{0, 120, 40};
        int[] mapScores = new int[]{0, -30, 20};
        int score = initScores[layout[i][j]];
        int joint = 0;
        // up
        if (i > 0 && layout[i - 1][j] != 0) {
            joint++;
        }
        // down
        if (i < m - 1 && layout[i + 1][j] != 0) {
            joint++;
        }
        // left
        if (j > 0 && layout[i][j - 1] != 0) {
            joint++;
        }
        // right
        if (j < n - 1 && layout[i][j + 1] != 0) {
            joint++;
        }
        return score + mapScores[layout[i][j]] * joint;
    }
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        ArrayList<int[][]> layouts = getAllLayout(m, n, introvertsCount, extrovertsCount);
        int max = 0;
        for (int[][] layout: layouts) {
            int score = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    score += getScore(m, n, i, j, layout);
                }
            }
            max = Math.max(max, score);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ret;
//        ret = solution.getMaxGridHappiness(2, 3, 1, 2);
//        System.out.println(ret);
//        assert ret == 240;
//        ret = solution.getMaxGridHappiness(3, 1, 2, 1);
//        System.out.println(ret);
//        assert ret == 260;
//        ret = solution.getMaxGridHappiness(2, 2, 4, 0);
//        System.out.println(ret);
//        assert ret == 240;
//        ret = solution.getMaxGridHappiness(3, 1, 1, 3);
//        System.out.println(ret);
//        assert ret == 230;
        ret = solution.getMaxGridHappiness(3, 3, 3, 1);
        System.out.println(ret);
        assert ret == 400;
    }
}