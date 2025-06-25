package C06EtcClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

// <> : 제네릭
public class C04GenericMain {
    public static void main(String[] args) {

        String[] stArr = {"java", "python", "C"};
        stChange(stArr, 0, 1);
        System.out.println(Arrays.toString(stArr));

        Integer[] intArr = {10, 20, 30};
        intChange(intArr, 0, 1);
        System.out.println(Arrays.toString(intArr));

        allChange(stArr, 0, 1);
        allChange(intArr, 0, 1);

        // 일반 객체 생성 시
        Person p1 = new Person("hongildong");
        GenericPerson<Integer> p2 = new GenericPerson<>(10);
        GenericPerson<String> p3 = new GenericPerson<>("hongildong");

        // 제네릭 사용 예시
        List<String> myList = new ArrayList<>();
        Stream<String> myStream;
        Optional<Student> optionalStudent;
    }

    // 제네릭 메서드는 반환 타입 왼쪽에 <T>라고 선언
    // 이때 T에는 참조형 변수인 객체 타입만을 허용
    static <T> void allChange(T[] arr, int idx1, int idx2) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void stChange(String[] arr, int idx1, int idx2) {
        String temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void intChange(Integer[] arr, int idx1, int idx2) {
        Integer temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}

// 제네릭 클래스는 클래스명 옆에 <T> 선언
class GenericPerson<T> {
    private T value;

    public GenericPerson(T value) {
        this.value = value;
    }

    public T getName() {
        return value;
    }

    public void setName(T value) {
        this.value = value;
    }
}

class Person{
    private String value;

    public Person(String value) {
        this.value = value;
    }

    public String getName() {
        return value;
    }

    public void setName(String value) {
        this.value = value;
    }
}