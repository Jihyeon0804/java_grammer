package C07ExceptionFileParsing.MemberException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

// 핵심 로직을 구현하는 계층
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService() {
       this.memberRepository = new MemberRepository();
    }

    // 회원 가입
    public void register(String name, String email, String password) {
        if (memberRepository.findByEmail(email).isPresent()) {          // DB에 이메일 중복일 경우 예외 발생
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        } else if (password.length() < 8) {                             // 비밀번호가 너무 짧으면 예외 발생
            throw new IllegalArgumentException("비밀번호가 너무 짧습니다. 8자 이상으로 입력해 주세요.");
        } else {                                                        // 객체를 조립 후 repository를 통해 register
            memberRepository.register(new Member(name, email, password));
        }
    }

    // 회원 상세 조회 (Optional이 넘어오니 없으면 예외 발생)
    public Member findById(Long id) {
        // Optional 객체에 값이 없을 경우 예외 발생, 있으면 Member를 꺼내서 return
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            return member.get();
        } else {
            throw new NoSuchElementException("일치하는 회원 ID가 없습니다.");
        }
    }

    // 회원 목록 조회
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // 로그인
    public void login(String email, String password) throws NoSuchElementException, IllegalArgumentException {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (!optionalMember.isPresent()) {
            throw new NoSuchElementException("이메일을 잘못 입력하셨습니다.");
        }
        if (!optionalMember.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
    }
}
