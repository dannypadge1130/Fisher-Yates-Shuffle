import java.util.Random;
import java.util.Scanner;

public class Shuffle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of Entries:");
		int arraySize = sc.nextInt();
		
		int[] numbers = new int[arraySize];
		
		for(int i = 0; i<arraySize; i++) {
			System.out.print("Entry ("+i+"):");
			numbers[i] = sc.nextInt();
		}
		
		printNumbers(numbers);
		
		int[] shuffledNumbers = shuffleNumbers(numbers);
		
		printNumbers(shuffledNumbers);
		
		sc.close();
	}
	
	//Fisher-Yates shuffle
	public static int[] shuffleNumbers(int[] numbers) {
		
		Random random = new Random();
		int max = numbers.length;
		
		for (int i = 0; i < numbers.length; i++) {
			
			int min = i;
			
			int index = random.nextInt(max-min) + min; //Formula for random range. Random((max-min)+1)+min.  The +1 is for inclusion of max.
			int temp = numbers[index];
			numbers[index] = numbers[i];
			numbers[i] = temp;
		}
		
		return numbers;
	}
	
	public static void printNumbers(int[] numbers) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<numbers.length; i++) {
			if(sb.length() > 0) {
				sb.append(",");
			}
			sb.append(numbers[i]);
		}
		
		System.out.println(sb.toString()); 
	}
}
