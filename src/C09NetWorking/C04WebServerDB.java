package C09NetWorking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class C04WebServerDB {
    public static void main(String[] args) throws IOException, SQLException {

        //        mysql드라이버 별도 다운로드 및 추가
        String url = "jdbc:mysql://localhost:3306/board?useSSL=false";
        String userName = "root";
        String password = "test1234";
        Connection connection = DriverManager.getConnection(url, userName, password);
//        Statement객체에 쿼리를 담아 db에 전달
        Statement st = connection.createStatement();
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버 시작");
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null && !line.isEmpty()) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            String requestString = sb.toString();
            String firstLine = requestString.split("\n")[0];
            String infos = firstLine.split(" ")[1];
            String id = "";
            if (infos.contains("?")) {
                id = infos.split("=")[1];
            }

            ResultSet rs = st.executeQuery("select * from post where id=" + "\"" + id + "\"");
            StringBuilder response = new StringBuilder("HTTP/1.1 200 OKay\r\n\r\n");

            while (rs.next()) {
                response.append("id : ");
                response.append(rs.getInt("id")).append("\n");
                response.append("title : ");
                response.append(rs.getString("title")).append("\n");
                response.append("contents : ");
                response.append(rs.getString("contents")).append("\n");
            }
//            사용자에게 메시지 응답
            socket.getOutputStream().write(response.toString().getBytes(StandardCharsets.UTF_8));
//            플러시란 일반적으로 변경사항을 확정하는 것을 의미
            socket.getOutputStream().flush();
            socket.close();
        }

    }
}
