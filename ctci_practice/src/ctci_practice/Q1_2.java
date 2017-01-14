package ctci_practice;

public class Q1_2 {

	public static boolean isPermutation(String a, String b) {
		
		//a and b can only be permutations of the 
		//other if they have the same size
		if(a.length() != b.length()) return false;
		
		int[] aLetterCount = new int[26];
		int[] bLetterCount = new int[26];
		
		for(int i = 0; i < a.length(); i++) {
			
			//increase the array value at index corresponding to the letter found
			int aLetterVal = a.charAt(i) - 'a';
			aLetterCount[aLetterVal]++;
			
			//increase the array value at index corresponding to the letter found
			int bLetterVal = b.charAt(i) - 'a';
			bLetterCount[bLetterVal]++;
		}
		
		//compare the letter counts of both strings
		for(int i = 0; i < 26; i++) {
			if(aLetterCount[i] != bLetterCount[i]) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		//test1
		String[] a = {"perm", "mop", "dog", "nice", "comeon"};
		String[] b = {"marp", "mope", "god", "nice", "onmoce"};
		
		for(int i = 0; i < a.length; i++) {
			System.out.println("Are the words " + a[i] + " and " + b[i] + " permutations : " + isPermutation(a[i], b[i]));
		}
		
		//test2
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = isPermutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}

}
