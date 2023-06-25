package a20230624;

import java.util.ArrayList;

public class Layout {
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
                for (int j = i + 1; j < m * n; j++) {
                    int[] memberCpy = new int[member.length];
                    System.arraycopy(member, 0, memberCpy, 0, member.length);
                    do {
                        if (memberCpy[i] != memberCpy[j]) {
                            int tmp = memberCpy[i];
                            memberCpy[i] = memberCpy[j];
                            memberCpy[j] = tmp;
                            layout.add(layout(m, n, memberCpy));
                            break;
                        }
                        if (++j >= m * n) {
                            break;
                        }
                    } while (memberCpy[i] == memberCpy[j]);
                }
            }
        }
        return layout;
    }

    public boolean identical(ArrayList<int[][]> expected, ArrayList<int[][]> actual) {
        for (int i = 0; i < expected.size(); i++) {
            int[][] matrixExpected = expected.get(i);
            int[][] matrixActual = actual.get(i);
            for (int j = 0; j < matrixExpected.length; j++) {
                int[] rowExpected = matrixExpected[j];
                int[] rowActual = matrixActual[j];
                for (int k = 0; k < rowActual.length; k++) {
                    if (rowExpected[k] != rowActual[k]) {
                        System.out.println("expected is not identical actual");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Layout layout = new Layout();
        ArrayList<int[][]> l;
        l = layout.getAllLayout(3, 1, 1, 2);
        System.out.println(l);
        l = layout.getAllLayout(4, 1, 1, 2);
        System.out.println(l);

    }
}
