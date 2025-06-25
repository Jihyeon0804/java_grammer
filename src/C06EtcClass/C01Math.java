package C06EtcClass;

public class C01Math {
    public static void main(String[] args) {
        
        // Math.random() : 임의의 수 반환 (0.0 ~ 1.0 사이의 double 형 반환)
        System.out.println(Math.random());
        // 로또 번호 7개 뽑기
        for (int i = 0; i < 7; i++) {
            System.out.println((int) (Math.random() * 100));
        }

        // Math.abs() : 절댓값 반환
        System.out.println(Math.abs(-5));

        // Math.ceil() : 올림
        System.out.println(Math.ceil(5.7));

        // Math.floor() : 내림
        System.out.println(Math.floor(5.7));

        // Math.round() : 반올림
        System.out.println(Math.round(5.7));
        
        // Math.max(a, b) : 두 수의 최댓값
        System.out.println(Math.max(1, 2));

        // Math.min(a, b) : 두 수의 최솟값
        System.out.println(Math.min(1, 2));

        // Math.pow(a, b) : a의 b제곱 (b가 승수); return double형
        System.out.println(Math.pow(2, 3));
        
        // Math.sqrt(a) : a의 제곱근; return double형
        System.out.println(Math.sqrt(25));
    }
}
