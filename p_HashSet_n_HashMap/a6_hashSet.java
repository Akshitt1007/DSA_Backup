package p_HashSet_n_HashMap;

import java.util.HashSet;

public class a6_hashSet {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A"); // Ignored (duplicate)

        System.out.println("HashSet: " + set);
    }
}
