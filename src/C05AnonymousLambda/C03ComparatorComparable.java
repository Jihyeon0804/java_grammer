package C05AnonymousLambda;

import java.lang.reflect.Array;
import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
        
        // 자바에서는 비교를 위한 인터페이스가 대표적으로 2개가 제공
        // Comparator 인터페이스 : compareTo 메서드 선언
        // Comparable 인터페이스 : compare 메서드 선언

        // String 클래스에 compareTo 메서드 내장
        // String 클래스 및 java의 많은 클래스에서 Comparable을 상속하여 compareTo 메서드를 구현
        String a = "hello";
        String b = "world";
        System.out.println(a.compareTo(b));     // 마이너스


        List<String> list= new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("javascript");
        // String 안의 compareTo 메서드를 사용하여 정렬이 이뤄짐
        Collections.sort(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        // 직접 만든 Student를 List에 담아 정렬
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Kim", 24));
        studentList.add(new Student("Lee", 21));
        studentList.add(new Student("Park", 44));
        studentList.add(new Student("Choi", 26));
        studentList.add(new Student("Kim", 20));
        
        // 정렬 방법 1) Student 객체에서 Comparable을 직접 구현한 방식
        // 단점 : Student 객체를 직접 수정해야하므로 유연성이 떨어짐
        // Collections.sort 에서 Comparable을 구현한 객체를 요구
        Collections.sort(studentList);
        System.out.println(studentList);
        
        // 정렬 방법 2) Comparator를 구현한 익명 객체 사용
        // Comparator 활용도가 높은 이유는 많은 정렬 메서드에서 Comparator 객체를 요구하기 때문
        studentList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(studentList);

        String[] arr = {"hello", "java", "C++", "world2"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));

        // 글자 길이를 기준으로 내림차순 정렬
        // [world2, hello, java, C++]
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.toString(arr));


        Queue<String> pq = new PriorityQueue<>((o1, o2) -> o1.length() - o2.length());

        // 백준 - 절대값 힙(11286); solved
        
        // 배열 안의 배열 정렬
        // [4, 5], [1, 2], [5, 0], [3, 1]
        List<int[]> myList = new ArrayList<>();
        myList.add(new int[]{4, 5});
        myList.add(new int[]{1, 2});
        myList.add(new int[]{5, 0});
        myList.add(new int[]{3, 1});

        // 정렬 : 리스트 안의 배열에 index 1번째 값을 기준으로 오름차순
        myList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int[] m : myList) {
            System.out.println(Arrays.toString(m));
        }

        // 백준 - 선 긋기 (2170)
        // arr[0] 기준으로 정렬
        // 3가지 경우의 수에 따라 total 길이 계산
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    // 정렬은 결국 2개의 값을 비교하는 것으로, A와 B대상 2개만 있으면 충분
    // 두 수 (또는 문자) 비교의 경수 음수, 0, 양수 세 값 중에 하나만 return. 이를 통해 정렬 수행
    // this가 앞에 있을 땐 오름차순, this가 뒤에 있으면 내림차순으로 내부적으로 정렬 로직 동작
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());           // 이름 기준 오름차순 정렬
//        return o.getName().compareTo(this.getName());         // 이름 기준 내림차순 정렬
//        return this.getAge() - o.getAge();                    // 나이 기준 오름차순 정렬
//        return this.getAge() - o.getAge();                    // 나이 기준 내림차순 정렬
    }
}