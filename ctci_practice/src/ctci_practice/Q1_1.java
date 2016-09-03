package ctci_practice;

public class Q1_1 {
	
	public static boolean is_unique(String str) {
		if(str.length() > 128) return false;
		
		//create boolean array auto initialized to 0
		boolean[] ascii_set = new boolean[128];
		
		//loop to run check if any char has already been seen in the string
		for(int i = 0; i < str.length(); i++) {
			
			//get the ascii value of the character
			int ascii_val = str.charAt(i);
			
			//if the value at index val is 1(true), then the char is not unique
			if(ascii_set[ascii_val]) return false;
			
			//set the ascii_set value to true if unique
			ascii_set[ascii_val] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		String[] words = {"helo", "hello", "bad", "103", "111"};
		
		for(String word : words) {
			System.out.println(word + " : " + is_unique(word));
		}
	}

}
