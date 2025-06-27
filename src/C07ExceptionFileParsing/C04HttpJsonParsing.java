package C07ExceptionFileParsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class C04HttpJsonParsing {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // 외부 데이터(API) 요청해서 데이터 받아 오기 : 서버 간의 통신
        // 라이브러리 - RestTemplate, RestClient : 스프링에서 가장 많이 사용하는 라이브러리
        // 위 라이브러리 사용 시 파싱 기능이 내장되어 있어 데이터를 요청 받아오면 자동으로 파싱 처리
        
        // HttpClient는 자바의 내장 클래스로서 별도의 역직렬화, 직렬화 작업이 필요
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String postString = response.body();
//        System.out.println(postString);

        ObjectMapper o1 = new ObjectMapper();
        JsonNode jsonNode = o1.readTree(postString);
        List<Post> postList = new ArrayList<>();
        for (JsonNode j : jsonNode) {
            Post post = o1.readValue(j.toString(), Post.class);
            postList.add(post);
        }
        System.out.println(postList);
    }
}

class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post() {

    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}