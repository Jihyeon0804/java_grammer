package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C02Calendar {
    public static void main(String[] args) {
        
        // java.util 패키지의 Calendar 클래스
        Calendar myCalendar = Calendar.getInstance();
        System.out.println(myCalendar.getTime());                           // Wed Jun 25 11:42:16 KST 2025
        System.out.println(myCalendar.get(Calendar.YEAR));                  // 연도
        System.out.println(myCalendar.get(Calendar.MONTH) + 1);             // 월 (달의 시작이 0부터)
        System.out.println(myCalendar.get(Calendar.DAY_OF_MONTH));          // 일
        System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK));           // 요일 (일요일부터 시작)
        System.out.println(myCalendar.get(Calendar.HOUR));                  // 시 (12시 체계)
        System.out.println(myCalendar.get(Calendar.HOUR_OF_DAY));           // 시 (24시 체계)
        System.out.println(myCalendar.get(Calendar.MINUTE));                // 분
        System.out.println(myCalendar.get(Calendar.SECOND));                // 초

        // java.time 패키지의 LocalDateTime, LocalDate, LocalTime 클래스
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);                          // 2025-06-25
        System.out.println(localDate.getYear());                // 2025
        System.out.println(localDate.getMonth());               // JUNE
        System.out.println(localDate.getMonthValue());          // 6 (1부터 시작)
        System.out.println(localDate.getDayOfMonth());          // 25
        System.out.println(localDate.getDayOfWeek());           // WEDNESDAY

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());                // 시
        System.out.println(localTime.getMinute());              // 분
        System.out.println(localTime.getSecond());              // 초

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());            // 연도
        System.out.println(localDateTime.getHour());            // 시
        // get 메서드와 ChronoField 매개 변수로 다양한 형식의 날짜/시간 정보 조회
        System.out.println(localDateTime.get(ChronoField.YEAR));
        System.out.println(localDateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(localDateTime.get(ChronoField.AMPM_OF_DAY));         // 0 : 오전, 1 : 오후
        System.out.println(localDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY));   // 24시 체계
        
        // .of() : 임의로 특정 시간 정보 객체를 만들어 내고 싶을 때 사용
        LocalDate birthDay = LocalDate.of(2000, 11, 12);
        System.out.println(birthDay);

        LocalDateTime birthDateTime = LocalDateTime.of(2000, 11, 12, 15, 14, 10);
        System.out.println(birthDateTime);
    }
}
