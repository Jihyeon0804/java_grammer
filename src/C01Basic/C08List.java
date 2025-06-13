package C01Basic;

import java.util.*;

public class C08List {
    public static void main(String[] args) {

        // List 선언
        // 방법 1)
        ArrayList<String> myList1 = new ArrayList<String>();
        ArrayList<String> myList2 = new ArrayList<>();
        
        // 방법 2) 가장 일반적인 방법
        List<String> myList3 = new ArrayList<>();

        // 초기값 세팅
        // 방법 1) 개별 data add (기본)
        myList3.add("java");
        myList3.add("python");
        myList3.add("C++");

        System.out.println(myList3);

        // 방법 2) 배열을 리스트로 변환
        String[] arr = {"java", "python", "C++"};
        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));
        System.out.println(myList4);

        // 원시 자료형은 Arrays.asList() 사용 불가
        int[] intArr = {10, 20, 30};
        List<Integer> myIntList = new ArrayList<>();
        for (int i : intArr) {
            myIntList.add(i);
        }
        System.out.println(myIntList);


        // add 메서드 : 리스트에 값을 하나씩 추가하는 메서드
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(0, 30);      // list는 중간 데이터 삽입/삭제는 성능 비효율적
        System.out.println(myList);

        // get(index) : 특정 index의 요소 반환
        System.out.println(myList.get(0));
        
        // size() : 리스트의 개수(길이) 반환
        System.out.println(myList.size());

        // for 문을 활용해서 myList값 하나씩 모두 출력
        // 1) 일반 for 문
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        // 2) 향상된 for 문
        for (int m : myList) {
            System.out.println(m);
        }

        // remove : 요소 삭제
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        // 방법 1) index를 사용하여 삭제
        list.remove(0);           // remove 10
        System.out.println(list);       // 20, 30

        // 방법 2) value를 통한 삭제 (일반적 X - 중복된 값이 있을 수 있기 때문)
        list.remove(Integer.valueOf(30));       // remove 30
        System.out.println(list);                  // 20

        // clear : 요소 전체 삭제
        list.clear();
        System.out.println(list);                   //  []

        // indexOf : 특정 값을 찾아 index return (중복 시, 가장 먼저 찾은 값의 index 출력)
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(30);
        System.out.println(list2.indexOf(30));          // 2

        // contains : 값이 있는지 없는지 여부를 리턴  return boolean
        System.out.println(list2.contains(20));         // true
        
        //  프로그래머스 - n의 배수 고르기
        List<Integer> list1 = new ArrayList<>();
        int n = 3;
        int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        for (int i : numlist) {
            if (i % n == 0) {
                list1.add(i);
            }
        }

        int[] answer = new int[list1.size()];
        int idx = 0;
        for (int i : list1) {
            answer[idx++] = i;
        }
        System.out.println(Arrays.toString(answer));

        // 정렬
        List<Integer> list4 = new ArrayList<>();
        list4.add(5);
        list4.add(3);
        list4.add(2);
        list4.add(1);
        list4.add(4);
        // 방법 1) Collections 클래스 사용
        Collections.sort(list4);                                    // 오름차순
        System.out.println(list4);
        Collections.sort(list4, Comparator.reverseOrder());         // 내림차순
        System.out.println(list4);

        // 방법 2) 객체 사용
        list4.sort(Comparator.naturalOrder());
        System.out.println(list4);
        list4.sort(Comparator.reverseOrder());
        System.out.println(list4);

        // 이중 리스트 : 리스트안의 리스트
        // [[1, 2, 3], [3, 4], [5, 6]]
        List<List<Integer>> list5 = new ArrayList<>();
        List<Integer> list6 = new ArrayList<>();
        list5.add(list6);
        list5.add(new ArrayList<>());           // 위와 동일
        list5.get(0).add(1);
        list5.get(0).add(2);                    // [[1, 2], []]
        list5.get(1).add(3);                    // [[1, 2], [3]]
        list5.get(1).add(4);                    // [[1, 2], [3, 4]]

        list5.add(new ArrayList<>());

        // for 문을 이용해서 이중 리스트 생성 [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12]]
        List<List<Integer>> list7 = new ArrayList<>();
        int idx1 = 1;
        for (int i = 0; i < 4; i++) {
            list7.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                list7.get(i).add(idx1++);
            }
        }
        System.out.println(list7);

        // 리스트 안에 배열 생성
        List<int[]> list8 = new ArrayList<>();
        list8.add(new int[]{1, 2});
        list8.add(new int[]{1, 2, 3});
        list8.add(new int[]{1, 2, 3, 4});
        // 출력
        for (int[] m : list8) {
            System.out.println(Arrays.toString(m));
        }

        for (int i = 0; i < list8.size(); i++) {
            System.out.println(Arrays.toString(list8.get(i)));
        }
    }
}
