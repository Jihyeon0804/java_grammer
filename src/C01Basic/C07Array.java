package C01Basic;

import java.util.*;

public class C07Array {
    public static void main(String[] args) {

        // 배열의 길이는 고정
        // 배열 표현식 1) 배열 선언 후 할당 방식
        // 배열은 반드시 사전에 길이가 결정되어야 함
        int[] arr1 = new int[5];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[3] = 40;
        arr1[4] = 50;
//        arr1[5] = 10;                     // ArrayIndexOutOfBoundsException 발생; 배열의 길이가 동적으로 늘어날 수 없음.
        System.out.println(arr1[2]);        // int 배열의 경우 0으로 초기화; String 배열은 null로 초기화

        // 배열 표현식 2) 리터럴 방식
        int[] arr2 = {10, 20, 30, 40, 50};

        // 배열 표현식 3) 배열 선언과 동시에 할당 방식
        int[] arr3 = new int[]{10, 20, 30, 40, 50};

        // 예시)
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[5]);
        list.add(new int[]{1, 3, 5, 7});        // list.add({1, 3, 5, 7}); 은 불가
        System.out.println(list.get(1)[0]);

        // 배열 표현식 4) 불가 -> 배열의 길이를 반드시 확정시켜야 함
//        int[] arr4 = new int[];

        // Arrays.fill : 배열의 모든 값을 변경
        String[] arr = new String[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }

        Arrays.fill(arr, "");       // 위 반복문과 동일
        System.out.println(Arrays.toString(arr));


        // 실습 1) 85, 65, 90으로 구성된 int 배열을 선언하고, 총합과 평균을 구해보시오.
        int[] array = new int[]{85, 65, 90};
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        double avg = (double) sum / array.length;
        System.out.println(sum);
        System.out.println(avg);

        // 실습 2) 배열의 최솟값, 최댓값 구하기
        int[] array2 = new int[]{10, 20, 30, 12, 8, 17};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : array2) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.println(max);
        System.out.println(Arrays.stream(array2).max());
        System.out.println(min);
        System.out.println(Arrays.stream(array2).min());


        // 배열의 자리 바꾸기
        int[] array3 = {20, 10, 30};
        int temp = array3[0];
        array3[0] = array3[1];
        array3[1] = temp;
        System.out.println(Arrays.toString(array3));

        // 배열 뒤집기
        int[] array4 = {10, 20, 30, 40, 50};
        int[] newArr = new int[arr.length];
        for (int i = array4.length - 1; i >= 0; i--) {
            newArr[array4.length - i - 1] = array4[i];
        }
        System.out.println(Arrays.toString(newArr));
        
        // 배열의 정렬
        int[] array5 = {17, 12, 20, 10, 15};
        Arrays.sort(array5);                                    // 오름차순 정렬
//        Arrays.sort(array5, Comparator.reverseOrder());       // int[] 은 내림차순 정렬 불가능 -> 원시 자료형은 Comparator 사용 불가능
        System.out.println(Arrays.toString(array5));

        String[] strArr = {"abc", "aaa", "acb", "abb"};
        Arrays.sort(strArr, Comparator.reverseOrder());         // 내림차순 정렬
        System.out.println(Arrays.toString(strArr));

        // 선택 정렬 알고리즘 직접 구현
        // min 값 찾기
        // 자리 바꾸기
        // 2중 for 문 (안쪽 for 문 index 주의)

        int[] array6 = {17, 12, 20, 10, 15};
         // 방법 1)
        for (int i = 0; i < array6.length; i++) {
            int min_value = Integer.MAX_VALUE;
            int idx = 0;
            for (int j = i; j < array6.length; j++) {
                if (array6[j] <min_value) {
                    min_value = array6[j];
                    idx = j;
                }
            }
            int temp_value = array6[i];
            array6[i] = array6[idx];
            array6[idx] = temp_value;
        }
        System.out.println(Arrays.toString(array6));


        // 방법 2)
        array6 = new int[]{17, 12, 20, 10, 15};
        for (int i = 0; i < array6.length; i++) {
            for (int j = i + 1; j < array6.length; j++) {
                if (array6[j] < array6[i]) {
                    int temp2 = array6[i];
                    array6[i] = array6[j];
                    array6[j] = temp2;
                }
            }
        }
        System.out.println(Arrays.toString(array6));


        // 문제 1) 조합 : 모두 각기 다른 숫자의 배열이 있을 때, 만들어질 수 잇는 두 숫자의 조합을 문자열 형태로 출력
        // 출력 예시) (10, 20), (10, 30), (10, 40), (10, 50), (20, 30), ...
        int[] intArr = {10, 20, 30, 40, 50};
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                System.out.println("(" + intArr[i] + ", " + intArr[j] + ")");
            }
        }

        // 배열의 중복 제거 : set 자료 구조를 활용하여 중복 제거; set은 중복X, 순서X
        int[] intArray = {10, 10, 20, 30, 30, 40};
        Set<Integer> mySet = new HashSet<>();
        for (int a : intArray) {
            mySet.add(a);
        }
        System.out.println(mySet);

        // 중복 제거 후 정렬
        int[] answer = new int[mySet.size()];
        int index = 0;
        for (int a : mySet) {
            answer[index] = a;
            index++;
        }
        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));

        // 프로그래머스 - 두 개 뽑아서 더하기 (조합 + 중복 제거)
        int[] numbers = {5,0,2,7};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] result = new int[set.size()];
        int idx = 0;
        for (int a : set) {
            result[idx] = a;
            idx++;
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        
        
        // 배열의 검색
        int[] arr4 = {5, 3, 1, 8, 7};
        int target = 8;
        // 8이 몇 번째 index에 있는지 출력
        
        // 1) for 문을 통한 검색 (하나하나 검색)
        // 시간 복잡도 : O(n)
        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] == target) {
                System.out.println(i);
                break;
            }
        }

        // 2) 이분 탐색 (이진 검색) - binary search(); 시간 복잡도 -  O(log(n))
        // 사전에 데이터가 오름차순 정렬되어 있을 경우, 이분 탐색 가능
        int[] arr5 = {1, 3, 6, 8, 9, 11, 15};
        // binarySearch() : 값이 있으면 index 반환, 값이 없으면 -1 반환
        System.out.println(Arrays.binarySearch(arr5, 15));

        // 백준 - 수 찾기 (1920)
        int[] nums = {4, 1, 5, 2, 3};
        int[] targetArr = {1, 3, 7, 9, 5};
        
        // 방법 1) 그냥 찾기 (시간 초과)

        // 방법 2) 이진 검색 사용


        // 배열 값 비교
        int[] intArr1 = {10, 20, 30};
        int[] intArr2 = {10, 20, 30};
        System.out.println(intArr1 == intArr2);                     // false
        System.out.println(Arrays.equals(intArr1, intArr2));        // true
        
        
        // 이차원 배열의 선언과 값 할당
        // 1) 선언 후 할당 방식
        int[][] arr6 =  new int[3][2];          // new int[n][];  뒤에 부분은 생략 가능 (가변 배열)
        arr6[0][0] = 1;
        arr6[0][1] = 2;
        arr6[1][0] = 3;
        arr6[1][1] = 4;
        arr6[2][0] = 5;
        arr6[2][1] = 6;

        // 2) 리터럴 방식
        int[][] arr7 = {{1, 2}, {3, 4}, {5, 6}};

        // 3) 가변 배열 : 배열의 전체 길이는 반드시 할당
        int[][] arr8 = {{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};

        int[][] arr9 = new int[3][];
        arr9[0] = new int[2];
        arr9[1] = new int[3];
        arr9[2] = new int[4];
        
        // 이차원 배열의 출력
        System.out.println(arr8);                           // 이차원 배열의 주소 값
        System.out.println(Arrays.toString(arr8));          // 각 1차원 배열의 주소 값 모음
        System.out.println(Arrays.deepToString(arr8));      // 각 1차원 배열의 값을 출력
        
        // 실습 1)
        // [3][4] 사이즈 선언하고 1 ~ 12까지 숫자 값을 각 배열에 순차적으로 할당
        // {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        int[][] arr10 = new int[3][4];
        int start = 1;
        for (int i = 0; i < arr10.length; i++) {
            for (int j = 0; j < arr10[0].length; j++) {
                arr10[i][j] = start++;
            }
        }
        System.out.println(Arrays.deepToString(arr10));
        
        // 실습 2)
        // 가변 배열 값 채우기
        int[][] arr11 = new int[3][];
        start = 1;
        for (int i = 0; i < arr11.length; i++) {
            arr11[i] = new int[12 / arr11.length];
            for (int j = 0;  j < 12 / arr11.length; j++) {
                arr11[i][j] = start++;
            }
        }
        System.out.println(Arrays.deepToString(arr11));


        // 프로그래머스 - 행렬의 덧셈
        int[][] intArr11 = {{1}, {2}};
        int[][] intArr22 = {{3}, {4}};
        int[][] answer11 = new int[intArr11.length][intArr11[0].length];
        for (int i = 0; i < intArr11.length; i++) {
            for (int j = 0; j < intArr11[0].length; j++) {
                answer11[i][j] += intArr11[i][j] + intArr22[i][j];
            }
        }
        System.out.println(Arrays.deepToString(answer11));

        // 프로그래머스 - K번째 수
        // 배열 복사 메서드
        // Arrays.copyOf(배열명, length)
        // Arrays.copyOfRange(배열명 start, end)
        int[] arr55 = {1, 4, 6, 7, 8 , 12, 1, 6, 7};
        int[] arr66 = Arrays.copyOf(arr55, 4);
        System.out.println(Arrays.toString(arr66));

        int[] arr77 = Arrays.copyOfRange(arr55, 3, 6);
        System.out.println(Arrays.toString(arr77));

    }
}
