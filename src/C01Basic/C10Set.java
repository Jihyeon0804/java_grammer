package C01Basic;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

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

        // 백준 - 숫자 카드(10815)

        // 프로그래머스 - 폰켓몬
        int[] nums = {3,1,2,3};
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        System.out.println(Math.min(set.size(), nums.length / 2));

        // LinkedHashSet : 입력 순서 보장
        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(1);
        linkedSet.add(1);
        linkedSet.add(0);
        linkedSet.add(3);
        linkedSet.add(1);
        System.out.println(linkedSet);          // [1, 0, 3]

        // TreeSet : 데이터를 오름차순 정렬
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(0);
        treeSet.add(3);
        treeSet.add(1);
        System.out.println(treeSet);            // [0, 1, 3]

        // 집합 관련 함수
        Set<String> set1 = new HashSet<>();
        set1.add("java");
        set1.add("python");
        set1.add("C++");

        Set<String> set2 = new HashSet<>();
        set2.add("java");
        set2.add("html");
        set2.add("css");
        
        // 교집합
//        set1.retainAll(set2);             // set1에는 java만 남음
//        System.out.println(set1);

        // 합집합
//        set1.addAll(set2);
//        System.out.println(set1);       // java, python, c++, html, css

        // 차집합
        set1.removeAll(set2);
        System.out.println(set1);       // python, c++
    }
}
