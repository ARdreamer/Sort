package first;

import java.util.ArrayList;
import java.util.Arrays;

public class TTT {
    public static void main(String[] args) {
        ArrayList<ArrayList> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(i);
        }
        list.add(new ArrayList(list1));
        System.out.println(Arrays.toString(list.toArray()));
        list1.remove(0);
        list1.clear();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(list1.toArray()));


    }
}
