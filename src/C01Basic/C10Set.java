package C01Basic;

import java.util.HashSet;
import java.util.Set;

public class C10Set {
    public static void main(String[] args) {

        // Set : 중복X, 순서X
        Set<String> mySet = new HashSet<>();
        mySet.add("h");
        mySet.add("h");
        mySet.add("h");
        mySet.add("h");
        mySet.add("e");
        mySet.add("e");
        mySet.add("e");
        mySet.add("l");
        mySet.add("l");
        mySet.add("o");
        mySet.add("o");
        System.out.println(mySet);
    }
}
