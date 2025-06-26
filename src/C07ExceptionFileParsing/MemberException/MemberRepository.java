package C07ExceptionFileParsing.MemberException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 저장소 역할을 하는 계층
// DB의 CRUD를 수행하는 계층
public class MemberRepository {

    // DB의 역할
    private static List<Member> memberList = new ArrayList<>();

    // 회원 가입
    public void register(Member member) {

        memberList.add(member);
    }

    // 회원 상세 조회 By email
    public Optional<Member> findByEmail(String email) {
//        for (Member member : memberList) {
//            if (member.getEmail().equals(email)) {
//                return Optional.of(member);
//            }
//        }
//        return Optional.empty();
        return memberList.stream().filter(m -> m.getEmail().equals(email)).findFirst();
    }

    // 회원 상세 조회 By id
    public Optional<Member> findById(long id) {
        for (Member member : memberList) {
            if (member.getId() == id) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    // 회원 목록 조회
    public List<Member> findAll() {

        return memberList;
    }


}
