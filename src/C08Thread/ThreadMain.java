package C08Thread;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {

        /*
        // 단일 스레드 실행
        for (int i = 0; i < 1000; i++) {
            Library.borrow();
        }
        System.out.println(Library.getBookCount());
        */


        // 멀티 스레드 생성 방법
        // 방법 1) 스레드 클래스 생성 방법
        /*
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();
        Thread thread4 = new MyThread();
        // Thread 클래스 안에 start() 메서드가 내장되어 있고, start() 는 MyThread 클래스의 run() 을 호출하면서 스레드 생성
        // 각 스레드의 코드의 실행 순서는 보장되지 않음
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        System.out.println("hello world");
        */

        // 방법 2) Runnable을 직접 구현한 객체를 Thread 클래스 생성자에 주입하는 방식 (Runnable 익명 객체 구현; MyThread 클래스 필요X)
        // 메서드가 run() 밖에 없으므로 생략 가능
//        Thread thread1 = new Thread(() -> System.out.println("스레드 실행 시작(My Thread)"));
//        thread1.start();
//        new Thread(() -> System.out.println("스레드 실행 시작(My Thread 1)")).start();
//        new Thread(() -> System.out.println("스레드 실행 시작(My Thread 2)")).start();
//        new Thread(() -> System.out.println("스레드 실행 시작(My Thread 3)")).start();
//        new Thread(() -> System.out.println("스레드 실행 시작(My Thread 4)")).start();
//        System.out.println("hello world");


        // 멀티 스레드 동시성 이슈 테스트
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> Library.borrow());
            t1.start();
            // 해결책 1) Library.borrow() 메서드에 synchronized 키워드 붙이기
            // 해결책 2) join()
            // 한 스레드의 작업이 모두 완료될 때, 다른 스레드 생성하여 작업 수행
            // -> 사실상 단일 스레드처럼 동작되므로 성능 저하 발생
            t1.join();
        }
        Thread.sleep(20000);
        System.out.println(Library.getBookCount());         // main 스레드가 실행 (순서 보장X)




        


    }
}
