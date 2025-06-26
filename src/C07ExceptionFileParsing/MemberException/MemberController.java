package C07ExceptionFileParsing.MemberException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// 사용자의 입출력을 받아 처리하는 계층 (사용자와 상호작용)
public class MemberController {
    public static void main(String[] args) {

        MemberService memberService = new MemberService();

        Scanner scan = new Scanner(System.in);
        
        while (true) {
            System.out.println("서비스 번호를 입력해 주세요.");
            System.out.println("1. 회원 가입   2. 회원 상세 조회   3. 회원 목록 조회");
            String input = scan.nextLine();
            if (input.equals("1")) {
                // 회원 가입
                // 이름, 이메일, 패스워드 입력 받아서 service에 전달하여 회원 가입
                // 예외 발생 시 적절한 문구를 사용자에게 출력 (try - catch)
                try {
                    System.out.println("회원 가입입니다.");
                    System.out.print("이름을 입력해 주세요 : ");
                    String name = scan.nextLine();
                    System.out.print("이메일을 입력해 주세요 : ");
                    String email = scan.nextLine();
                    System.out.print("비밀번호를 입력해 주세요 : ");
                    String password = scan.nextLine();
                    memberService.register(name, email, password);
                    System.out.println("회원 가입이 완료되었습니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equals("2")) {
                // 상세 조회
                // 회원 정보 출력
                System.out.print("조회할 ID를 입력해 주세요 : ");
                long id = Long.parseLong(scan.nextLine());

                // 적절한 예외 처리 필요 (Optional)
                try {
                    Member member = memberService.findById(id);
                    System.out.println(member.toString());
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                }

            } else if (input.equals("3")) {
                // 회원 목록 조회
                // 회원 목록 정보 출력
                List<Member> memberList = memberService.findAll();
                for (Member member : memberList) {
                    System.out.println(member.toString());
                }
            } else if (input.equals("4")) {
                String email = scan.nextLine();
                String password = scan.nextLine();
                try {
                    memberService.login(email, password);
                    System.out.println("로그인 성공입니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
