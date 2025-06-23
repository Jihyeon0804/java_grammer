package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

// 조합(Combination)과 순열(Permutation)
// 주로 백트래킹 알고리즘 상황에서 사용
public class C13RecursiveCombiPermu {
    public static void main(String[] args) {

        // 이중 for문 활용하여 hello world 1, hello world 2, ..., hello world n 까지 출력
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("hello world" + total);
                total++;
            }
        }

        // 위 for 문의 반복 횟수는 동적으로 결정되지 않고, 정적으로 코딩할 수 밖에 없는 한계가 존재
        forRecur(0, 2);
        System.out.println(staticCount);        // 9


        // 조합
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

        // 숫자 1, 2, 3, 4 를 가지고 만들 수 있는 2개까지 숫자 조합을 이중 리스트에 담아 출력
        // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
        List<List<Integer>> doubleList = new ArrayList<>();
//        for (int i = 0; i < myList.size(); i++) {
//            for (int j = i + 1; j < myList.size(); j++) {
//                List<Integer> list = new ArrayList<>();
//                list.add(myList.get(i));
//                list.add(myList.get(j));
//                doubleList.add(list);
//            }
//        }
//        System.out.println(doubleList);

        // 재귀 함수를 만들기 위한 for 문 변형
        List<List<Integer>> doubleList2 = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < myList.size(); i++) {
//            list.add(myList.get(i));
//            for (int j = i + 1; j < myList.size(); j++) {
//                list.add(myList.get(j));
//                doubleList2.add(new ArrayList<>(list));     // list의 주소값이 똑같기 때문에 doubleList2에 들어간 것도 같이 지워짐
//                list.remove(list.size() - 1);
//            }
//            list.remove(list.size() - 1);
//        }
//        System.out.println(doubleList2);

        // 조합
        combi(myList, new ArrayList<>(), doubleList2, 2, 0);
        System.out.println(doubleList2);


        // 순열
        // 1, 2, 3, 4를 n개씩 뽑은 순열 구하기
        // [1, 2], [1, 3], [1, 4], [2, 1], ..., [4, 3]
        permu(myList, new ArrayList<>(), doubleList, 2, new boolean[myList.size()]);
        System.out.println(doubleList);


    }

    // 순열
    static void permu(List<Integer> myList, List<Integer> list, List<List<Integer>> doubleList, int target, boolean[] visited) {
        if (list.size() == target) {
            doubleList.add(new ArrayList<>(list));      // doubleList.add(list); 아님 주의!!
            return;
        }
        for (int i = 0; i < myList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;      // 선택한 것은 제외
                list.add(myList.get(i));
                permu(myList, list, doubleList, target, visited);
                list.remove(list.size() - 1);
                visited[i] = false;     // 다시 원상 복구
            }
        }
    }

    
    // 조합
    static void combi(List<Integer> myList, List<Integer> list, List<List<Integer>> doubleList, int target, int start) {
        if (list.size() == target) {
            doubleList.add(new ArrayList<>(list));      // doubleList.add(list); 아님 주의!!
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            list.add(myList.get(i));
            combi(myList, list, doubleList, target, i + 1); // 순서 상관X
            list.remove(list.size() - 1);
        }
    }

    static int staticCount = 0;

    static void forRecur(int num, int target) {
        if (num == target) {
            System.out.println("hello world" + staticCount);    // 9번
            staticCount++;
            return;

        }
        for (int i = 0; i < 3; i++) {
//            System.out.println("hello world");        // 12번
            forRecur(num + 1, target);
        }
    }
}
