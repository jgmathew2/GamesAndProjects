
import java.io.*;
import java.util.Scanner;

	public class Lesson3 {
	//static function can be called without creating an instance
	//of the class
	//An exception is a runtime error
	//Runtime errors occur during the running of code
	public static void main(String[] args) {
		File f = new File("/home/user/sync/workspace/CS01B/src/Lesson1.java");
		try {
			Scanner in = new Scanner(f);
			int count = 0;
			while(in.hasNext()) {
			       String line = in.nextLine();
			       Utils.println(line);
			       count++;
			       
			        }
			if(count < 1000) throw new MyException();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (MyException e) {
			Utils.println("jk");
		}
	}
	
	
	}
	//extends have this class "inherit" everything inside the Exception class
	//Can be treated as a regular exception
	
	class MyException extends Exception {
	
	}