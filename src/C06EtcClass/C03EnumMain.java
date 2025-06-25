package C06EtcClass;

public class C03EnumMain {
    public static void main(String[] args) {

        // classGrade를 일반 문자열로 세팅할 경우 아래와 같은 문제 발생 가능
        // 정해진 문자열이 아닌 개별적으로 생성된 문자열 삽입
//        Student s1 = new Student("hong", "1학년");
//        Student s2 = new Student("hong", "firstGrade");
//        Student s3 = new Student("hong", "first_grade");

        // static final을 통해 변수값 관리하는 방법 -> "타입이 String" 이므로 얼마든지 자유롭게 세팅이 가능한 문제점 존재
//        Student s1 = new Student("hong", ClassGrade.c1);
//        Student s2 = new Student("hong2", ClassGrade.c1);
//        Student s3 = new Student("hong3", ClassGrade.c2);

        // Enum 클래스를 활용한 ClassGrade 세팅
        // 타입 불일치 시 error
        Student s1 = new Student("hong", ClassGrade.FIRST_GRADE);
        Student s2 = new Student("hong2", ClassGrade.FIRST_GRADE);
        Student s3 = new Student("hong3", ClassGrade.SECOND_GRADE);
        System.out.println(s1);
        
        // Enum 클래스 내부에는 값이 저장된 순서대로 0부터 index 값이 내부적으로 할당
        System.out.println(s1.getClassGrade().ordinal());       // 0
        System.out.println(s3.getClassGrade().ordinal());       // 1

    }
}

enum ClassGrade {
    FIRST_GRADE,
    SECOND_GRADE,
    THIRD_GRADE;
}

//class ClassGrade {
//    static final String c1 = "FIRST_GRADE";
//    static final String c2 = "SECOND_GRADE";
//    static final String c3 = "THIRD_GRADE";
//}

class Student {
    private String name;
    private ClassGrade classGrade;

    public Student(String name, ClassGrade classGrade) {
        this.name = name;
        this.classGrade = classGrade;
    }

    public String getName() {
        return name;
    }

    public ClassGrade getClassGrade() {
        return classGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classGrade=" + classGrade +
                '}';
    }
}
