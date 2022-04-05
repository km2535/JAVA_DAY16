package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

public class ForEachTest {
	public static void main(String[] args) {
//		기존의 배열 형태도
		int [] data = {10,20,30,40,50};
//		아래와 같이 foreach문 사용 가능하다.
		for (int i : data) {
			System.out.println(i);
		}
//		위 forEach문을 이용하면 HashSet이나 HashMap 데이터들을 Iterator를 사용하지 
//		않고 바로 요소들을 순회 시킬 수 있다.
//		HashSet을 만들어 보자 
		HashSet<String> likeit = new HashSet<String>();
		likeit.add("coding");
		likeit.add("maker");
		likeit.add("javascript");
		likeit.add("java");
		likeit.add("php");
//		위 HashSet을 forEach문으로 만들어 보자
		for (String hobby : likeit) {
			System.out.println(hobby);
		}
//		HashMap도 만들보자
		HashMap<String, Integer> shinee = new HashMap<String, Integer>();
		shinee.put("온유",34);
		shinee.put("종현",33);
		shinee.put("키",32);
		shinee.put("민호",32);
		shinee.put("태민",30);
		
//		다만 반복자로 만들기 위해서는 최소한 Set객체까지 넣어야 된다.
		Set<Entry<String, Integer>> entryset = shinee.entrySet();
		for (Entry<String, Integer> entry : entryset) {
			System.out.println("이름 : " + entry.getKey() + " / 나이 : " + entry.getValue());
		}
	}
}
