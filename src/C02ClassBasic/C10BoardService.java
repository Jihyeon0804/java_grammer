package C02ClassBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C10BoardService {
    
//        1.회원가입 : 이름, 이메일, 비밀번호, id값(auto_increment)
//        2.회원 전체 목록 조회 : id, email
//        3.회원 상세 조회(id로 조회) : id, email, name, password, 작성 글 수
//        4.게시글 작성 : id, title, contents, 작성자Email (Author 객체 가능)
//        5.게시물 목록 조회 : id(post), title
//        6.게시물 상세 조회 (id로 조회) : id(post), title, contents, 작성자 email(작성자 이름으로 조회)
//        7.서비스 종료
    
    public static void main(String[] args) throws IOException {
        List<Author> authorList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            System.out.println("서비스 번호를 입력하세요.");
            System.out.println("1. 회원가입   2. 회원 전체 목록 조회   3. 회원 상세 조회   4. 게시글 작성 \n" +
                    "5. 게시물 목록 조회   6. 게시물 상세 조회    7. 서비스 종료");
            System.out.print("서비스 번호 : ");
            int serviceNum = Integer.parseInt(br.readLine());

            // 회원가입
            if (serviceNum == 1) {
                System.out.println("회원 가입할 이름, 이메일, 비밀번호를 입력해주세요.");
                System.out.print("이름 : ");
                String name = br.readLine();

                System.out.print("이메일 : ");
                String email = br.readLine();

                System.out.print("비밀번호 : ");
                String password = br.readLine();

                Author author = new Author(name, email, password);
                authorList.add(author);

                System.out.println("회원 가입이 완료되었습니다.");


            // 회원 전체 목록 조회
            } else if (serviceNum == 2) {
                for (Author author : authorList) {
                    System.out.println("ID : " + author.getId() + ", EMAIL : " + author.getEmail());
                }

            // 회원 상세 조회
            } else if (serviceNum == 3) {
                System.out.println("조회할 회원의 ID를 입력해주세요.");
                System.out.print("회원 ID : ");
                int id = Integer.parseInt(br.readLine());
                for (Author author : authorList) {
                    if (author.getId() == id) {
                        System.out.println("회원 ID : " + author.getId());
                        System.out.println("회원 이메일 : " + author.getEmail());
                        System.out.println("회원 이름 : " + author.getName());
                        int postSize = author.getPostList().size();
                        System.out.println("작성 글 수 : " + postSize);
                    } else {
                        System.out.println("없는 회원 번호 입니다.");
                    }
                    break;
                }


            // 게시글 작성
            } else if (serviceNum == 4) {
                System.out.print("회원 ID를 입력해 주세요 : ");
                int id = Integer.parseInt(br.readLine());


                System.out.println("게시글 제목을 작성해 주세요 : ");
                String title = br.readLine();

                System.out.println("게시글 내용을 작성해 주세요.");
                String contents = br.readLine();

                for (Author author : authorList) {
                    if (author.getId() == id) {
                        Post post = new Post(id, title, contents, author);
                        postList.add(post);
                        System.out.println("등록되었습니다.");
                        break;
                    }
                }

            // 게시물 목록 조회
            } else if (serviceNum == 5) {
                for (Post post : postList) {
                    System.out.println("게시글 ID : " + post.getId() + ", 제목 : " + post.getTitle());
                }

            // 게시물 상세 조회
            } else if (serviceNum == 6) {
                System.out.println("조회할 글의 작성자 이름을 입력해주세요. : ");
                String name = br.readLine();
                for (Post post : postList) {
                    if (post.getAuthor().getName().equals(name)) {
                        System.out.println("게시글 ID : " + post.getId());
                        System.out.println("제목 : " + post.getTitle());
                        System.out.println("내용 : " + post.getContents());
                        System.out.println("작성자 이메일 : " + post.getAuthor().getEmail());
                        break;
                    }
                }

            // 서비스 종료
            } else if (serviceNum == 7) {
                System.out.println("서비스가 종료되었습니다.");
                break;

            // 잘못 입력
            } else {
                System.out.println("잘못 입력 하셨습니다.");
            }
            
        }
    }
}

class Author {
    // 일반적으로 클래스를 정의할 때 원시 자료형은 wrapper 클래스로 정의
    private Long id;
    // wrapper 클래스 Long 의 기본 값은 null 이기 때문에 값을 초기화 해 주어야 함
    private static Long static_id = 0L;
    private String name;
    private String email;
    private String password;
    // Author 객체에 본인이 작성한 게시글 목록인 postList 객체를 만들어 둠으로서 편의성 향상
    private List<Post> postList;

    // 회원가입
    public Author(String name, String email, String password) {
        this.id = static_id++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public static Long getTotalId() {
        return static_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPostList() {
        return postList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", postCount=" + postList.size() +
                '}';
    }
}

class Post {
    private Long id;
    private static Long static_id = 0L;
    private String title;
    private String contents;
    // 객체 안에 객체를 선언함으로서 post 객체에서 쉽게 author 객체에 접근 가능
    private Author author;
//    private String authorEmail;

    // 게시글 작성
    public Post(int id, String title, String contents, Author author) {
        this.id = static_id++;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.author.getPostList().add(this);
//        this.authorEmail = authorEmail;
    }

    public Long getId() {
        return id;
    }

    public static Long getTotalId() {
        return static_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Author getAuthor() {
        return author;
    }

}

