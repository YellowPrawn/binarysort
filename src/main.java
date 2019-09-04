import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class main {

	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static int number = 240514;
	static int max = 0;
	static int min = 0;
	static int maxBuffer = 0;
	static int minBuffer = 0;
	static boolean stop = false;
	
	public static void main(String[] args) {
		
		String csvFile = "C:\\Users\\Damien\\eclipse-workspace\\BinarySort\\numbers.txt";
        String line = "";
        
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                numbers.add(Integer.valueOf(line));  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//System.out.println(numbers);
		Collections.sort(numbers);
		max = numbers.size();
		
		search();
	}
	static void search() {
			
		//System.out.println(numbers.get(Math.round((max+min)/2)));
			
		if(number > numbers.get(Math.round((max+min)/2))) {
			min = Math.round((max+min)/2);
		}else if(number < numbers.get(Math.round((max+min)/2))) {
			max = Math.round((max+min)/2);
		}
			
		if(number == numbers.get(Math.round(max)) || number == numbers.get(Math.round(min)) || number == numbers.get(Math.round((max+min)/2))) {
			System.out.println(number + " found");
			stop = true;
		} else if(maxBuffer == numbers.get(Math.round(max)) && minBuffer == numbers.get(Math.round(min))) {
			System.out.println(number + " not found");
			stop = true;
		}
			
		maxBuffer = numbers.get(Math.round(max));
		minBuffer = numbers.get(Math.round(min));
		
		if(stop==false) {
			search();
		}
	}
}
