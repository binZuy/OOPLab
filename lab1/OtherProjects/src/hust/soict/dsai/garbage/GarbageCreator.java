package hust.soict.dsai.garbage;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
//import java.nio.file.Path;

public class GarbageCreator {
	public static void main(String[] args) {
		
		String filename = "C:\\Users\\duyng\\OneDrive - Hanoi University of Science and Technology\\Desktop\\Java_OOP\\BaoCaoOOP\\oolt.vn.20231.20210270.nguyenminhduy\\lab1\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		try
		{
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b : inputBytes) {
			outputString+=(char)(b & 0xFF);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time using + ope: " + (endTime-startTime) + " ms");
		
		// Using StringBuilder
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b: inputBytes){
		 	outputStringBuilder.append((char)(b & 0xFF));
		 }
		endTime = System.currentTimeMillis();
		System.out.println("Time using StringBuilder: " + (endTime-startTime) + " ms");
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
}
