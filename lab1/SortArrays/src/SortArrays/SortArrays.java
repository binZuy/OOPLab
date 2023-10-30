package SortArrays;
import java.util.Arrays;
public class SortArrays {
	public static void main(String[] args)   
	{   
	//defining an array of integer type   
	int [] array = new int [] {90, 23, 5, 109, 12, 22, 67, 34};  
	//invoking sort() method of the Arrays class  
	int sum=0;
	double ave;
	Arrays.sort(array);   
	System.out.println("Elements of array sorted in ascending order: ");  
	System.out.println(Arrays.toString(array)); 
	for (int i = 0; i < array.length; i++)   
	{       
	  sum +=array[i];
	}   
	ave = sum/(array.length);
	System.out.println("Average value = " + ave);
	}  
}
