package C01Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class C09Map {
    public static void main(String[] args) {
        
        // key, value 로 이루어진 자료 구조
        // key 값은 중복이 있으면 value로 덮어쓰기
        Map<String, Integer> sports = new HashMap<>();
        sports.put("농구", 2);
        sports.put("배구", 1);

        // map은 key를 통해 value를 get
        // map 에서 key 값을 통한 검색 복잡도 - O(1)
        System.out.println(sports.get("농구"));


        // map의 전체 데이터 출력
        // map의 key 값 접근 시에 인덱스 사용 불가능 (순서X)
        // keySet() : map의 키 목록을 리턴하는 메서드; return Set
        // values() : map의 value 목록을 리턴

        // value의 합 구하기
        // 방법 1)
        int total = 0;
        for (int v : sports.values()) {
            total += v;
        }
        System.out.println(total);

        // 방법 2)
        total = 0;
        for (String k : sports.keySet()) {
            total += sports.get(k);
        }
        System.out.println(total);

        // remove() : key를 통해 map의 특정 요소 삭제
        sports.remove("농구");
        System.out.println(sports);

        // map에서 기존의 key 값에 put 할 경우 덮어쓰기
        sports.put("배구", 10);
        System.out.println(sports);
        
        Map<String, String> sports2 = new HashMap<>();
        sports2.put("soccer", "축구");
        sports2.put("baseball", "야구");
        sports2.put("basketball", "농구");
        System.out.println(sports2);

        // putIfAbsent() : key 값이 없는 경우에만 put
        sports2.putIfAbsent("soccer", "운동");
        sports2.putIfAbsent("tennis", "테니스");
        System.out.println(sports2);

        // containsKey() : key가 있으면 true, 없으면 false
        System.out.println(sports2.containsKey("tennis"));
        System.out.println(sports2.containsKey("pingpong"));

        // map 출력 방법
        // 방법 1) for each 문 (강화된 for문)
        for (String s : sports2.keySet()) {
            System.out.println(s);
            System.out.println(sports2.get(s));
        }

        // 위와 동일
        Set<String> mySet = sports2.keySet();
        for (String s : mySet) {
            System.out.println(s);
        }

        // 방법 2) iterator 활용
        Iterator<String> iterator = sports2.keySet().iterator();
        // next() : 데이터를 하나씩 소모시키면서 값을 반환 (개수를 넘어가면 NoSuchElementException)
        System.out.println(iterator.next());
        // hasNext() : iterator 안에 그 다음 값이 있는지 없는지 boolean 으로 리턴
        System.out.println(iterator.hasNext());
        // 모든 값 출력
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // map은 key의 value 수를 count 하는 목적으로 많이 사용
        // getOrDefault(키 값, 초기값) : key 값이 없을 경우 초기값 리턴
        String[] arr = {"농구", "축구", "농구", "야구", "축구"};
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s,0) + 1);
        }

        // 위와 동일
//        for (int i = 0; i < arr.length; i++) {
//            if (map.containsKey(arr[i])) {
//                map.put(arr[i], map.get(arr[i]) + 1);
//            } else {
//                map.put(arr[i], 1);
//            }
//        }
        System.out.println(map);

        // String[] arr = {"농구", "축구", "농구", "야구", "축구"};
        String[] removeArr = {"농구", "농구", "농구", "야구", "축구"};
        for (String s : removeArr) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
                if (map.get(s) == 0) {
                    map.remove(s);
                }
            }
        }
        System.out.println(map);

//        for (String s : removeArr) {
//            if (map.containsKey(s)) {
//                if (map.get(s) == 1) {
//                    map.remove(s);
//                } else {
//                    map.put(s, map.get(s) - 1);
//                }
//            }
//        }

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("축구", 3);
        myMap.put("농구", 2);
        myMap.put("야구", 1);
        
        // 가장 value가 큰 key 값 찾기
        int max = Integer.MIN_VALUE;
        String maxKey = "";
        for (String s : myMap.keySet()) {
            if (myMap.get(s) > max) {
                max = myMap.get(s);
                maxKey = s;
            }
        }
        System.out.println(maxKey);

        // 백준 - 베스트 셀러

        // 프로그래머스 - 완주하지 못한 선수
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        // 방법 1)
        Map<String, Integer> map2 = new HashMap<>();

        String answer = "";
        for (String s : participant) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            if (map2.get(s) != 0) {
                answer = s;
                break;
            }

        }
        System.out.println(answer);

        // 방법 2) 복잡도 n*log(n)
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i]))
                System.out.println(participant[i]);
        }
        System.out.println(participant[participant.length - 1]);


        // 프로그래머스 - 의상
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        // => return 5

        Map<String, Integer> map3 = new HashMap<>();

        for (String[] cloth : clothes) {
            map3.put(cloth[1], map3.getOrDefault(cloth[1], 0) + 1);
        }

        int answer1 = 1;

        for (String s : map3.keySet()) {
            answer1 *= map3.get(s) + 1;
        }
        System.out.println(answer1 - 1);
        
        
        // LinkedHashMap : 데이터의 삽입 순서를 보장 (유지)
        Map<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("hello5", 1);
        linkedMap.put("hello4", 2);
        linkedMap.put("hello3", 3);
        linkedMap.put("hello2", 4);
        linkedMap.put("hello1", 5);

        for (String l : linkedMap.keySet()) {
            System.out.println(l);
        }

        // TreeMap : key를 "정렬"(오름차순)하여 map을 저장
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("hello5", 1);
        treeMap.put("hello4", 2);
        treeMap.put("hello3", 3);
        treeMap.put("hello2", 4);
        treeMap.put("hello1", 5);

        for (String l : treeMap.keySet()) {
            System.out.println(l);
        }

        // 백준 - 파일 정리(20291)
    }
}
