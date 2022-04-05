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
