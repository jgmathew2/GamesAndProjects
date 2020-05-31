
public class Lesson2 {
	
	public static void main(String[] args) {
	   // Java type system
	
	   // Java only has 8 primitive types
	   // primitive types: int, float, long, double, char, 
	   //                   boolean, short, byte (0 to 255)
	
	   // class types: everything else
	   //    String, ArrayList, int[], String[], char[][]
	   //    Integer, Float
	
	   // Java has a class named Object. It is the universal class type
	   // Every single class type value can be stored in an Object var.
	   Object s = "Hello World";
	   // Object s cannot use String functions, as they are not valid functions of class Object
	   
	
	
	   String f = "My name is %s. My age is %d";
	   System.out.println(String.format(f, "Johan", 14));
	   System.out.println(sum(3,4,5,6));
	   
	   //Autowraps 14 into an Integer so it can be formatted
	   
	   
	   
	   //for every primitive type, there is also a class type 
	   //so you can treat primitive types as class types
	   //Ex: int - Integer
	   Object array = new int[]{1, 2, 3};
	   
	   Integer x = new Integer(5);
	   Integer y = new Integer(5);
	   System.out.println(x==y);
	   String str = (String)s;
	   System.out.println(str.length());
	   
	   if(s instanceof String) {
	       System.out.println("s is indeed a String");
	   }
	
	   //System.out.println((String)array);
	   
	 
	
	}
	static int sum(int...values) {
	//can take in any number of int values
	//values acts as array in function
	int total = 0;
	   for(int v : values) {
	     total += v;
	   }
	   return total;
	}



}
