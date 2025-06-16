package C01Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class C11QueStackDeque {
    public static void main(String[] args) {

        // Queue
        // Queue 인터페이스를 LinkedList가 구현한 아래와 같은 방식을 가장 많이 사용
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(10);
        myQue.add(20);
        myQue.add(30);
        
        // poll() : queue에서 데이터를 "삭제"하면서, 동시에 return 하는 메서드
        int temp = myQue.poll();        // 10
        System.out.println(temp);
        System.out.println(myQue);      // 20, 30
        
        // peek() : queue에서 데이터를 "삭제하지 않고", 가장 앞의 데이터를 반환
        int temp2 = myQue.peek();       // 20
        System.out.println(temp2);
        System.out.println(myQue);      // 20, 30

        
        // LinkedList와 ArrayList 성능 차이 비교
        long startTime =  System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(0, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("LinkedList 값 중간 add 시 소요 시간 : " + (endTime - startTime));

        long startTime2 =  System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(0, i);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("ArrayList 값 중간 add 시 소요 시간 : " + (endTime2 - startTime2));
    }
}
