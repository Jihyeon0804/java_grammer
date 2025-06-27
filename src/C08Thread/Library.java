package C08Thread;

public class Library {

    private static int bookCount = 100;

    // synchronized : 메서드 내에서 한 개의 스레드만 실행되도록 강제 (대기 중인 스레드들은 메서드 앞에서 대기)
    // RDB의 재고관리를 할 경우에는 synchronized를 통한다 하더라고 쿼리와 commit 실행 시점의 차이로 인해 동시성 이슈 발생
//    public synchronized static void borrow() {
    public static void borrow() {
        if (bookCount > 0) {
            try {
                Thread.sleep(100);      // checked exception -> try - catch로 감싸기
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount -= 1;
            System.out.println("대출 완료");
        } else {
            System.out.println("대출 불가");
        }
    }
    
    // 책 재고
    public static int getBookCount() {
        return bookCount;
    }
}
