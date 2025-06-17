package C01Basic;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11QueStackDeque {
    public static void main(String[] args) {

        // Queue : FIFO
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
        System.out.println("LinkedList 값 중간 add 시 소요 시간 : " + (endTime - startTime));       // 195

//        long startTime2 =  System.currentTimeMillis();
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            arrayList.add(0, i);
//        }
//        long endTime2 = System.currentTimeMillis();
//        System.out.println("ArrayList 값 중간 add 시 소요 시간 : " + (endTime2 - startTime2));      // 556781


        // 길이 제한 큐
        Queue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        // add : 길이 제한된 경우 제한된 길이 초과시 error
//        blockingQueue.add("문서1");
//        blockingQueue.add("문서2");
//        blockingQueue.add("문서3");
//        blockingQueue.add("문서4");
        System.out.println(blockingQueue);

        // offer : 길이 제한될 경우 제한된 길이까지만 insert
        blockingQueue.offer("문서1");
        blockingQueue.offer("문서2");
        blockingQueue.offer("문서3");
        System.out.println(blockingQueue);


        // 우선순위 큐 : 데이터를 poll할 때 "정렬"된 데이터 결과 값 보장 (FIFO X)
        // 전체 데이터가 계속해서 변경되면서 지속적으로 최소값을 추춯해야 하는 경우 사용
        // 시간 복잡도 - O(nlog(n))
        // pq.poll() 한 개의 복잡도는 log(n)
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(20);
        pq.add(10);
        pq.add(40);
        pq.add(50);
        System.out.println(pq.poll());      // add할 때 까지는 전체 정렬이 돼 있지 않음
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());      // 1개씩 poll할 때마다 최소값을 뽑아낸다. - O(log(n))
        }
        
        // 백준 - 최소 힙(1927)

        // 최대 힙
        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.add(30);
        pq2.add(20);
        pq2.add(10);
        pq2.add(40);
        pq2.add(50);
        System.out.println(pq2.poll());      // add할 때 까지는 전체 정렬이 돼 있지 않음
        while (!pq2.isEmpty()) {
            System.out.println(pq2.poll());      // 1개씩 poll할 때마다 최소값을 뽑아낸다. - O(log(n))
        }
        
        // 프로그래머스 - 더 맵게
        int[] scoville = {1,1};
        int K = 7;
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        while (queue.peek() < K) {
            if (queue.size() >= 2) {
                int min1 = queue.poll();
                int min2 = queue.poll();
                queue.add(min1 + min2 * 2);
                answer++;
            } else {
                System.out.println(-1);
                break;
            }
        }
        System.out.println(answer);

        // Stack : 후입선출(LIFO)
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());        // 제거되면서 값 return
        System.out.println(stack.peek());       // 제거하지 않고 값만 return
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        
        // 프로그래머스 - 같은 숫자는 싫어
        int[] arr = {1,1,3,3,0,1,1};
        Stack<Integer> stack1 = new Stack<>();
        for (int i : arr) {
            if (stack1.isEmpty()) {
                stack1.push(i);
            } else {
                if (stack1.peek() != i) {
                    stack1.push(i);
                }
            }
        }
        int[] answer1 = new int[stack1.size()];
        for (int i = answer1.length - 1; i >= 0; i--) {
            answer1[i] = stack1.pop();
        }
        System.out.println(Arrays.toString(answer1));

        // 프로그래머스 - 올바른 괄호
//        String s = ")()(";
        // deque 사용X
//        int sum = 0;
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                sum++;
//            } else {
//                sum--;
//            }
//            if (sum < 0) {
//                System.out.println(false);
//                break;
//            }
//        }
//        System.out.println(sum == 0);


        String s = "(())()";
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack2.isEmpty() || c == '(') {
                stack2.push(c);
            } else {
                if (c == ')' && stack2.peek() == '(') {
                    stack2.pop();
                }
            }
        }
        System.out.println(stack2.isEmpty());
        System.out.println(stack2);


        // deque : addLast, pollLast, pollFirst, peekFirst, peekLast
        Deque<Integer> dq1 = new ArrayDeque<>();
        dq1.addLast(10);
        dq1.addLast(20);
        dq1.addLast(30);
        System.out.println(dq1.pollLast());
        System.out.println(dq1.pollFirst());
        System.out.println(dq1.peekLast());



    }
}
