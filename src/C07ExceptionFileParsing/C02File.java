package C07ExceptionFileParsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class C02File {
    public static void main(String[] args) throws IOException {

        // 콘솔창에 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);
        
        // 파일에서 읽기 : IO 패키지 -- NIO 패키지보다 성능 떨어짐
        BufferedReader br2 = new BufferedReader(new FileReader("src/C07ExceptionFileParsing/text.txt"));
        String line = br2.readLine();
        while (line != null) {
            System.out.println(line);
            line = br2.readLine();
        }
        
        // 파일에서 읽기 : NIO(Non-Blocking) 패키지 -- IO 패키지보다 성능 좋음
        Path filePath = Paths.get("src/C07ExceptionFileParsing/text.txt");
        // readString : 문자열 전체를 통째로 read 해서 String 으로 출력
        String st1 = Files.readString(filePath);
        System.out.println(st1);
        // readAllLines : 문자열을 라인별로 split 하여 list 형태로 저장
        List<String> list = Files.readAllLines(filePath);
        for (String s : list) {
            System.out.println(s);
        }
        
        // 파일 쓰기
        Path filePath2 = Paths.get("src/C07ExceptionFileParsing/test1.txt");
        Files.write(filePath2, "홍길동0\n".getBytes(), StandardOpenOption.CREATE_NEW);        // CREATE_NEW : 새로 입력
        Files.write(filePath2, "홍길동1\n".getBytes(), StandardOpenOption.WRITE);             // WRITE : 덮어쓰기
        Files.write(filePath2, "홍길동2\n".getBytes(), StandardOpenOption.APPEND);            // APPEND : 추가 모드
    }
}
