package C01Basic;

public class C03Operator {
    public static void main(String[] args) {

        // 산술 연산자 : 사칙연산
//        int n1 = 8;
//        int n2 = 3;
//        // * : 곱셈, / : 나눗셈(몫), % : 나머지
//        System.out.println("n1 * n2 = " + (n1 * n2));
//        System.out.println("n1 / n2 = " + (n1 / n2));
//        System.out.println("n1 % n2 = " + (n1 % n2));


        // 대입 연산자
//        int n1 = 7;
//        int n2 = 7;
//        int n3 = 7;
//        n1 = n1 - 3;    // 4
//        n2 -= 3;        // 4
//        n3 = -3;         // -3 대입
//        System.out.println(n1);
//        System.out.println(n2);
//        System.out.println(n3);
//
//        int n4 = 10;
//        int n5 = 10;
//        n4 /= 3;
//        n5 %= 3;
//        System.out.println(n4);
//        System.out.println(n5);
        
        
        // 증감 연산자
        int a = 10;
        a = a + 1;
        System.out.println(a);      // 11

        a += 1;
        System.out.println(a);      // 12

        a++;                        // 후위 증감 연산자
        System.out.println(a);      // 13

        ++a;                        // 전위 증감 연산자
        System.out.println(a);      // 14
        
        // 후위 증감 연산자 : "현재 라인"의 명령문이 "실행되고 나서" 증가
        // 전위 증감 연산자 : "현재 라인"의 명령문이 "실행되기 전에" 증가
        int n = 10;
        System.out.println(n++);    // 10


        int b = 5;
        int c = b++;    // 5
        int d = ++b;    // 7


        // 비교 연산자 : ==, !=, >, >= 등
        char c1 = 'a';
        char c2 = 'b';
        System.out.println(c1 == c2);       // false
        System.out.println(c1 != c2);       // true


        // 논리 연산자 : &&, ||, !
        int num1 = 10;
        int num2 = 20;
        boolean b1 = num1 > 5 && num1 < 20;
        System.out.println(b1);
        
        // num2가 10과 30사이에 있는지 여부를 b2에 값 세팅
        boolean b2 = num2 >= 10 && num2 <= 30;
        boolean b3 = !(num2 < 10 || num2 > 30);
        System.out.println(b2);
        System.out.println(b3);

        // 비트 연산자 : 컴퓨터의 이진 체계에서의 연산 방식 (&, |, ^, ~, >>, <<)
        int n1 = 5;     // 0101
        int n2 = 4;     // 0100
        // 두 수를 &(AND 연산) 하게 되면 각 자릿수에 모두 1이 있어야 1의 결과값이 나옴
        System.out.println(n1 & n2);    // 0100 => 4

        // 두 수를  |(OR 연산) 하게 되면 각 자릿수에 둘 중 하나라도 1이 있으면 1의 결과값이 나옴
        System.out.println(n1 | n2);    // 0101 => 5

        // 왼쪽으로 1칸 옮긴다는 의미는 해당 숫자값에 X2 한다는 의미
        // 0101 => 1010
        System.out.println(n1<<1);      // 10

        // 오른쪽으로 1칸 옮긴다는 의미는 해당 숫자값에 /2 한다는 의미
        // 0101 => 0010
        System.out.println(n1>>1);      // 2
    }
}
