package ctci_practice;

/*String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

public class Q1_6 {

	private static int compressedLen(String str) {
		int compressLength = 0, consecutiveCount = 0, strLen = str.length();
		
		for(int i = 0; i < strLen; i++) {
			consecutiveCount++;
			//if the string is ending, we end the count and amend compressed length
			if(((i+1) >= strLen) || (str.charAt(i) != str.charAt(i+1))) {
				compressLength += 1 + String.valueOf(consecutiveCount).length();
				consecutiveCount = 0;
			}
		}
		return compressLength;
	}
	
	private static String compressStr(String str, int compressedLen) {
		if(compressedLen >= str.length()) return str;
		
		StringBuffer compressed = new StringBuffer(compressedLen);
		int consecutiveCount = 0, strLen = str.length();
		
		for(int i = 0; i < strLen; i++) {
			consecutiveCount++;
			//if the string is ending, we end the count and amend compressed length
			if(((i+1) >= strLen) || (str.charAt(i) != str.charAt(i+1))) {
				compressed.append(str.charAt(i));
				compressed.append(consecutiveCount);
				consecutiveCount = 0;
			}
		}
		
		return compressed.toString();
	}
	
	public static void main(String[] args) {
		String str = "aaaaabbbbaaaabbddc";
		System.out.println(compressStr(str, compressedLen(str)));
	}

}
