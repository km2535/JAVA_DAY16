package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class HMapTest {
	public static void main(String[] args) {
//		HashMap을 사용하기 위해 객체화를 한다.
		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		HashMap에 데이터를 넣기 위해 put메소드를 이용한다.
		map.put("하나", 1);
		map.put("둘", 2);
		map.put("셋", 3);
		map.put("넷", 4);
		map.put("다섯", 5);
//		반복문을 돌릴려면 key또는 value를 기준으로 반복을 시켜야 되지만 key가 index로 활용되지 
//		못한다면 반복을 시킬 수 없다. 특정한 요소로 반복시킬 수 없으면 iterator를 이용한다.
//		iterator를 이용하려면 마찬가지로 쌍으로 이루어진 요소가 아닌 한개의 요소가 순서를 이루는 형태가 
//		되어야 되고 우리가 만든 순서대로 자리를 잡지는 않지만 순서를 먼저 이루기 위해 keySet()을 이용한다.
//		keyset이 반환하는 값도 객체이니 Set타입 객체화를 시킨다. 
		Set<String> keyset = map.keySet();
//		set으로 자리잡은 요소들을 Iterator를 이용하여 값을 출력할 수 있다. 
//		Iterator 타입으로 객체화시키자
		Iterator<String> keyiter = keyset.iterator();
//		위 요소를 하나씩 꺼내 출력해보자
		while(keyiter.hasNext()) {
			System.out.println(keyiter.next());
		}
//		value를 사용하고 싶을 때도 위와 같은 이유로 Iterator를 해야 될 것이다. 
//		다만 keySet은 Set타입이고 value는 collection이니 사용 시 주의
		Collection<Integer> values = map.values();
//		마찬가지로 Iterator로 객체화시키자
		Iterator<Integer> valueiter = values.iterator();
		while(valueiter.hasNext()) {
			System.out.println(valueiter.next());
		}
//		entry로 하나의 타입으로 사용할 수 있고 그게 바로 entrySet이다. 다만 Entry 타입으로 
//		만든다면 한쌍을 이루는 타입도 다시 명시해주어야 사용가능하다.
//		또한 Entry는 Set타입으로써 이용하면 된다.
		Set<Entry<String, Integer>> entryset = map.entrySet();
//		마찬가지로 Iterator타입으로 만들자
		Iterator<Entry<String, Integer>> entryiter = entryset.iterator();
		while(entryiter.hasNext()) {
//			이렇게 entry자체를 출력할 수도 있고 
//			System.out.println(entryiter.next());
//			entry 객체를 별도로 만들어 key와 value를 따로 출력 할 수 있다.
			Entry<String, Integer> entry = entryiter.next();
			System.out.println(entry.getKey()+ " : " + entry.getValue());
		}
	}
}
