package ctci_practice;

public class Q1_4 {
    
    //set a constant representing the number of letters in the English alphabet
    public static final int ALPHABET_SIZE = 26;
    
    //check if the palindrome requirement is fulfilled for a given string
	public static boolean isPalindromePermutation(String str) {
		//change string to all lower case characters for easier comparisons
		str = str.toLowerCase();
		
		//at most all but one letter have to be fully divisible by 2
		int[] letter_count = new int[ALPHABET_SIZE];
		
		//iterate through every character in the string
		for(int i = 0; i < str.length(); i++) {
		    //get numeric value of character at the current index relative to 'a'
			char c = str.charAt(i);
			int c_val = c-'a';
			
			//count occurrences of each letter
			if(c_val >= 0 && c_val < ALPHABET_SIZE) {
				letter_count[c-'a']++;
			}
		}
		
		//check if there is more than one case of a 
		//letter count not being fully divisible by 2
		boolean odd_char_seen = false;
		for(int i = 0; i < ALPHABET_SIZE; i++) {
			if(letter_count[i]%2 == 1) {
			    if(odd_char_seen) {
                    return false;
                }
			    odd_char_seen = true;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String[] strings = {"Rats live on no evil star",
							"A man, a plan, a canal, panama",
							"Lleve",
							"Tacotac",
							"asda"};
		for (String s : strings) {
			System.out.println(s + " : " + isPalindromePermutation(s));
		}
	}

}
