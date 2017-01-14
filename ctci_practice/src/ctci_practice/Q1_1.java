package ctci_practice;

public class Q1_1 {
	
	public static boolean isUnique(String str) {
		if(str.length() > 128) return false;
		
		//create boolean array auto initialized to 0
		boolean[] asciiSet = new boolean[128];
		
		//loop to run check if any char has already been seen in the string
		for(int i = 0; i < str.length(); i++) {
			
			//get the ascii value of the character
			int asciiVal = str.charAt(i);
			
			//if the value at index val is 1(true), then the char is not unique
			if(asciiSet[asciiVal]) return false;
			
			//set the ascii_set value to true if unique
			asciiSet[asciiVal] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		String[] words = {"helo", "hello", "bad", "103", "111"};
		
		for(String word : words) {
			System.out.println(word + " : " + isUnique(word));
		}
	}

}
