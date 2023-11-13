package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Using + operator
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 65536; i++) 
			s +=r.nextInt(2);
		System.out.println("Using + operator: " + (System.currentTimeMillis()- start) +" ms"); // this prints roughly 4500.
		
		//Using StringBuilder
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <65536; i++)
			sb.append(r.nextInt(2));
		s = sb.toString();
		System.out.println("Using String Builder: " + (System.currentTimeMillis() - start) + " ms");
		
		// Using StringBuffer
		r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            stringBuffer.append(r.nextInt(2));
        }
        s = stringBuffer.toString();
        System.out.println("Using StringBuffer: " + (System.currentTimeMillis() - start) + " ms");
	}
}
