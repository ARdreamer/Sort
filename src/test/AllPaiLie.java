package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPaiLie {
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    private void PermutationHelper(char[] c, int i, List<String> res) {
        if (i >= c.length - 1) {
            String val = String.valueOf(c);
            if (!res.contains(val)) {
                System.out.println("add\t" + val);
                res.add(val);
            }
        } else {
            for (int j = i; j < c.length; j++) {
                System.out.println("start swap " + c[i] + " and " + c[j]);
                swap(c, i, j);
                PermutationHelper(c, i + 1, res);
                swap(c, i, j);
                System.out.println("end swap " + c[j] + " and " + c[i]);
            }
        }
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public ArrayList<String> noPermutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            noPermutationHelper(str.toCharArray(), 0, res);
        }
        return (ArrayList) res;
    }

    private void noPermutationHelper(char[] c, int i, List<String> res) {
        if (i >= c.length - 1) {
            String val = String.valueOf(c);
            res.add(val);
        } else {
            for (int j = i; j < c.length; j++) {
                if (canSwap(i, j, c)) {
                    swap(c, i, j);
                    noPermutationHelper(c, i + 1, res);
                    swap(c, i, j);
                }
            }
        }
    }

    private boolean canSwap(int i, int j, char[] c) {
        for (int k = i; k < j; k++) {
            if (c[k] == c[j])
                return false;
        }
        return true;
    }



    public int StrToInt(String str) {
        int n = str.length(), s = 1;
        long res = 0;
        if (n == 0) return 0;
        if (str.charAt(0) == '-')
            s = -1;
        for (int i = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0; i < n; ++i) {
            if (!('0' <= str.charAt(i) && str.charAt(i) <= '9'))
                return 0;
            res = (res << 1) + (res << 3) + (str.charAt(i) & 0xf);
            System.out.println("asas:" + res + " i:" + i);
        }
        return (int) (res * s);
    }

    public static void main(String[] args) {
//        final AllPaiLie allPaiLie = new AllPaiLie();
//        System.out.println(allPaiLie.Permutation("abcd").toString());
//        System.out.println(allPaiLie.StrToInt("11111111111111111111"));
//        AllPaiLie asa = new AllPaiLie();
//        allPaiLie = asa;
        final AllPaiLie allPaiLie = new AllPaiLie();
        System.out.println(allPaiLie.noPermutation("aacd").toString());
        System.out.println(allPaiLie.noPermutation("aba").toString());

    }
}
