package C10Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C02Validation {
    public static void main(String[] args) throws IllegalAccessException {

        List<Member> memberList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("회원가입 서비스입니다.");
            System.out.print("이름을 입력해 주세요 : ");
            String name = scan.nextLine();
            System.out.print("이메일을 입력해 주세요. : ");
            String email = scan.nextLine();

            Member member = new Member(name, email);
            validate(member);
            memberList.add(member);
            System.out.println(memberList);

        }
    }

    static void validate(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields) {
            // 리플렉션은 기본적으로 런타임에 동작하므로 어노테이션 사용 시에 기본적으로 RUNTIME 세팅 필요
            if (f.isAnnotationPresent(NotEmpty.class)) {
                f.setAccessible(true);
                String value = (String) f.get(object);

                if (value == null || value.isEmpty()) {
                    NotEmpty n1 = f.getAnnotation(NotEmpty.class);
                    throw new IllegalArgumentException(n1.message());
                }
            }
        }
    }
}

// 어노테이션을 선언적 표시이고 어떠한 기능도 수행하지 않음
// 어노테이션 클래스를 통해 해당 클래스명으로 특정 필드 검사, 클래스 검사, 특정 기능 주입 등에 활용
@Retention(RetentionPolicy.RUNTIME)         // 어노테이션은 default는 컴파일 타임에 동작 -> 일반적으로 런타임 동작으로 변경
@interface NotEmpty {
    // 어노테이션의 속성 정의 방식
    String message() default "this field cannot be empty!!!";

}

class Member {
    private String name;

    @NotEmpty
    private String email;

    public Member() {
    }

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}