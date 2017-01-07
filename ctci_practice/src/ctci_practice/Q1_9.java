package ctci_practice;

/*String Rotation: Assume you have a method isSubstring which checks
 *  if one word is a substring of another. Given two strings, sl and 
 *  s2, write code to check if s2 is a rotation of sl using only one
 *  call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").*/
public class Q1_9 {
	
	private static boolean isSubstring(String a, String b) {
		if(a.toLowerCase().contains(b.toLowerCase()) || b.toLowerCase().contains(a.toLowerCase())) 
			return true;
		return false;
	}
	
	private static boolean isRotation(String a, String b) {
		//first check length to make sure they are the same
		if(a.length() != b.length()) return false;
		//concatenate string a to itself
		String aDoubled = a.concat(a);
		//check if b is a substring of the concatenated string,
		//which proves that they are rotations of each other
		if(!isSubstring(aDoubled, b)) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, 
				{"waterbottle", "erbottlewat"}, 
				{"camera", "macera"},{"abc","bac"}};
		
		for (String[] pair : pairs) {
			String a = pair[0], b = pair[1];
			System.out.println(a+", "+b+" : "+isRotation(a, b));
		}
	}

}
