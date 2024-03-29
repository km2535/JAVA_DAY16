# JAVA-16

## HashMap

컬렉션 프레임워크 중 하나, Map 구조로 이루어져 있다.
Map 구조란 key와 value로 이루어져 있는 entry(한쌍) 구조이다.

> **컬렉션** 사용 시 주의할 점
> **컬렉션**에서는 값들이 일치한지 **비교**할 때 그 요소 타입의 **equals()**나 **hashCode()**로 비교를 하기 때문에 우리가 만든 클래스에서 저 둘을 **재정의**하지 않는다면 주소값 비교로 같은 요소를 찾을 수 없게 된다. 따라서 비교하고자 하는 요소를 올바르게 비교하도록 우리가 만든 클래스에서 **equals()와 hashCode()를 재정의 해서 사용한다.**

### HashMap 안에 구성되어 있는 요소들만 따로 뽑아내는 메소드들

- .keyset()
  - Key들만 모여있는 Set을 리턴
- .value()
  - value들만 모여있는 Collection을 리턴
- .entry()
  - key, value가 하나로 모여있는 Entry들만 있는 Set을 리턴

```java
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
```

## 빠른 for 문

- 향상된 for문, forEach문이라고도 하면 이 것을 이용하면 위와 같은 복잡한 과정을 거치지 않고 곧바로 요소들을 순회 할 수 있다.

```
for(자료형 변수명 : 반복자){
	반복 내용
}
```

- 단순하게 모든 요소들을 순회 할 때 사용하는 것이 좋다.
- 순서가 중요한 경우(몇번째에 어떤 값이 있는지 알 필요가 있는 경우)에는 기존의 for문을 이용한다.

```java
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
```

## Thread

- 프로세스
  - 실행된 프로그램
  - 운영체제로부터 시스템 자원을 할당 받는 작업의 단위
  - 자바 프로그램은 운영체제 대신 JVM에 의해 자원을 할당 받는다.
- Thread 쓰레드
  - 프로세스의 특정한 수행 경로
  - 프로그램의 처리 경로
  - 프로그램의 흐름
- 멀티쓰레드
  - 여러개의 경로를 가질 수 있게 한다.
  - 한개의 처리 경로를 여러개로 나누어 동시 작업이 가능해진다.
  - 웹 페이지(JSP)가 대표적인 멀티 쓰레드 응용 프로그램이다.
  - 하나의 프로세스를 동시에 처리하는 것처럼 보이지만 사실은 매우 짧은 단위로 분할 해서 차례로 처리한다.
    ![](https://imagedelivery.net/v7-TZByhOiJbNM9RaUdzSA/6d9a500f-9543-43dd-360e-ee8c13b8e500/public)
- 교착 상태
  - 멀티쓰레드 중 쓰레드 간의 대기상태가 종료되지 않아서 무한정 대기만 하는 비정상적인 상태, 제어문을 통해 교착상태를 파악하고 다시 깨워준다.
- 멀티 쓰레드 장/단점
  - 장점
    - 효율성 증가
    - 처리량 증가
    - 처리비용 감소
  - 단점
    - 복잡하고 설계가 어려움
    - 자원의 공유문제
    - 교착상태(DeadLock)

### 멀티쓰레드 구현방법

#### Thread 클래스 상속

```java
package thread;

public class MyThread extends Thread{
// 쓰레드 클래스를 상속 받는다.
	String data;
// 어떤 데이터를 메소드로 만들고
	public MyThread(String data) {
		this.data = data;
	}
	//쓰레드로 만들 시 수행할 메소드
	//해당 쓰레드가 수행할 작업
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			//Thread.sleep(n) : n 밀리초동안 잠시 멈춤, 오류가 있을 수 있어서 try로 만듦
			try { sleep(1000); } catch (InterruptedException e) {}
		}
	}
}
```

사용

```java
package thread;

public class ThreadMain {
	public static void main(String[] args) {

		MyThread t1 = new MyThread("☆");
		MyThread t2 = new MyThread("★");
		// 쓰레드 메소드인 start를 이용하면 실행이 가능하다.
        // 설계했듯이 1초 쉬고 다음 data를 출력한다.
		t1.start();
		t2.start();

	}
}
```

#### Runnable 인터페이스 상속 받은 후 Thread에 넘겨주기

```java
package thread;

public class MyRunnable implements Runnable{
//	인터페이스 상속받는다.
	String data;

	public MyRunnable(String data) {
		this.data = data;
	}
//  설계는 쓰레드 클래스를 상속받은 클래스와 동일하게 만들었다.
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
		}
	}
}
```

사용

```java
package thread;

public class ThreadMain {
	public static void main(String[] args) {

		MyRunnable r1 = new MyRunnable("♡");
		MyRunnable r2 = new MyRunnable("♥");
		// Runnable 인터페이스를 상속받아 여기까지 객체화 시켰다면 사용가능한 상태이나 사용을 하려면 다시 Thread로 넣어줘야 사용할 수 있다.

		Thread t3 = new Thread(r1);
		Thread t4 = new Thread(r2);

		System.out.println("------출력시작------");
        //join을 사용하지 않고 바로 사용한다면 쓰레드가 작업을 먼저 끝낸 출력물 먼저 보여주기 때문에
        //출력끝을 먼저 출력하게 된다.
        //따라서 우리가 의도한대로 사용하려면 join메소드를 이용하여 해당 작업이
        // 종료될 때까지 다음 쓰레드를 실행하지 못하도록 막아줘야한다.
		t3.start();
		t4.start();

		//thread객체.join() : 이 쓰레드의 작업 수행 동안 다른 쓰레드들 멈추기
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {}
		System.out.println("------출력끝------");
	}
```

## 파일 입출력

### Writer(입력)

![](https://imagedelivery.net/v7-TZByhOiJbNM9RaUdzSA/601734ca-1c81-4054-8506-800dda4f0c00/public)

- FileWriter 코드를 이용하여 파일을 찾고 BufferedWriter를 이용해 buffer를 시킨뒤 close나 flush를 이용하여 파일에 입력한다.
- FileWriter
  - 경로에 있는 파일을 준비시키기(쓰기 위해)
  - 파일이 없는 경우에는 그 이름대로 파일을 생성한다.
  - 하지만 경로가 이상한 경우(폴더가 잘못된 폴더인 경우) 폴더를 생성해 주지는 않고, 예외가 발생한다.
- new FileWriter("파일경로/파일명.확장자") : 덮어쓰기 모드
- new FileWriter("파일경로/파일명.확장자", true) : 추가하기 모드
- BufferedWriter : 버퍼를 이용해서 파일 작성
- .write("문자열") : 버퍼에 문자열 쓰기
- .close() : 파일에 적용/ 버퍼에 있는 데이터들을 파일에 써주면서 버퍼 닫기.

```java
package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTest {
	public static void main(String[] args) {
//		경로가 이상한 경우 에러를 발생 시킬 수 있기 때문에 trycatch문으로 만든다.
		try {
//			FileWriter fw = new FileWriter("text.txt");
			FileWriter fw = new FileWriter("text.txt", true);
//			파일을 쓸 준비가 완료되었으면 버퍼를 만들어 세팅해준다.
			BufferedWriter bw = new BufferedWriter(fw);
//			버퍼객체를 만들고 다음 파일에 무엇을 쓸지 작성한다.
//			bw.write("아무거나 작성해도 써진다.");
//			이어쓰기 하려면 FileWriter의 옵션을 true로 해야한다.
			bw.write("\n아무거나 작성해도 써진다.");
//			작성완료 하였으면 close해서 버퍼를 완료한다.
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
```

파일로 만들 수 있는 것을 모두 만들 수 있다면 html이나 css나 js도 만들 수 있겠다...

### Reader(출력)

day17에 계속
