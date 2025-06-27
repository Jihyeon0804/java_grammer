package C09NetWorking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class C01WebServerGet {
    public static void main(String[] args) throws IOException {

//        소켓이란 서버와 사용자가 통신을 하기 위한 네트워크 통신의 끝점을 나타내는 개념
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");

        while (true) {
//            accept() : 사용자의 연결 요청을 수락
//            socket 객체 안에는 사용자의 정보(ip 등)
            Socket socket = serverSocket.accept();
//            사용자에게 응답을 줄 메시지를 http 프로토콜에 맞게 세팅 (줄바꿈으로 header, body 구분)
            String response = "HTTP/1.1 200 OK\r\n\r\n" + "hello world java";
//            사용자에게 메시지 응답
            socket.getOutputStream().write(response.getBytes(StandardCharsets.UTF_8));
//            flush()는 일반적으로 변경사항을 확정하는 것을 의미
            socket.getOutputStream().flush();
            socket.close();
        }
    }
}
