package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

public class C07Constructor {
    public static void main(String[] args) {
        
        // 캘린더 객체 생성 : 연도, 월, 일 세팅
//        Calendar calendar = new Calendar();
//        calendar.setYear("2025");
//        calendar.setMonth("06");
//        calendar.setDay("18");

        Calendar calendar = new Calendar("2005", "06", "18");


        // 캘린더 객체 출력 : "오늘은 xxxx년 xx월 xx일 입니다."
        System.out.println(calendar.printDay());
        // toString() 메서드는 특별한 메서드로 객체명을 출력할 때 자동으로 실행
        System.out.println(calendar);
        // 예)
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        System.out.println(list);       // toString() 해주지 않아도 객체의 메모리 주소 값이 아닌 저장된 값이 출력
    }
}

// Calendar 클래스 생성 : year, month, day 모두 String
class Calendar {

    private String year;
    private String month;
    private String day;

    // 생성자를 통해 객체 변수 값들을 객체가 만들어지는 시점에 초기화(세팅)
    public Calendar(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    // 위와 같은 별도 생성자를 추가할 경우 초기(기본) 생성자는 무시되므로, 필요 시 별도 생성
    public Calendar() {
        
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "year='" + this.year + '\'' +
                ", month='" + this.month + '\'' +
                ", day='" + this.day + '\'' +
                '}';
    }

    public String printDay() {
        return "오늘은 " + this.year + "년 " + this.month + "월 " + this.day + "일 입니다.";
    }
}
