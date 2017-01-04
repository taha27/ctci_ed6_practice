package ctci_practice;
//import java.lang.Math;

/*There are three types of edits that can be performed on strings: insert a
 *  character, remove a character, or replace a character. Given two strings,
 *  write a function to check if they are one edit (or zero edits) away.
 */

public class Q1_5 {

	public static boolean oneEditReplace(String a, String b) {
		
		if(a.length() != b.length()) return false;
		
		boolean oneDiff = false;
		
		//check to make sure there is only difference
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				if(oneDiff) return false;
				oneDiff = true;
			}
		}
		return true;
	}
	
	public static boolean one_edit_insert(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		
		if((aLen - bLen) == 0 || Math.abs(aLen - bLen) != 1) return false;
		
		//this will store whether a is one possible insert or one possible delete away from b
		String editType = "one delete away";
		
		boolean isAShorter = false;
		if(aLen < bLen) {
			isAShorter = true;
			editType = "one insert away";
		}
		
		boolean isShifted = false;
		int aIndex = 0, bIndex = 0;
		
		/*implement the actual comparison using a for or while loop 
		 * where at the first instance of a mismatch, increase index 
		 * of the larger string and continue compare*/
		while(aIndex < aLen && bIndex < bLen) {
			if(a.charAt(aIndex) == b.charAt(bIndex)) {
				aIndex++;
				bIndex++;
			} else {
				if(isShifted) return false;
				
				//shift one of the indices
				if(isAShorter) bIndex++;
				else aIndex++;
				
				isShifted = true;
			}
		}
		
		System.out.println(a + ", " + b + " : " + editType);
		
		return true;
	}
	
	public static boolean zero_edit_away(String a, String b) {
		if(a.equals(b)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		String[][] pairs = {{"a", "b"}, {"", "d"},{"d", "de"},
							{"pale", "pse"},{"acdsfdsfadsf", "acdsgdsfadsf"},
							{"acdsfdsfadsf", "acdsfdfadsf"},{"acdsfdsfadsf", "acdsfdsfads"},
							{"acdsfdsfadsf", "cdsfdsfadsf"},{"adfdsfadsf", "acdfdsfdsf"},
							{"adfdsfadsf", "bdfdsfadsg"},{"adfdsfadsf", "affdsfads"},
							{"pale", "pkle"},{"pkle", "pable"}};
		
		//test
		for(String[] pair : pairs) {
			
			//check if the strings are exactly the same
			if(zero_edit_away(pair[0], pair[1])) {
				System.out.println(pair[0] + ", " + pair[1] + " : " + "zero edits away");
			} else if(oneEditReplace(pair[0], pair[1])) {
				System.out.println(pair[0] + ", " + pair[1] + " : " + "one replace edit away");
			} else if(one_edit_insert(pair[0], pair[1])) {
				//System.out.println(pair[0] + ", " + pair[1] + " : " + "zero edits away");
			} else {
				System.out.println(pair[0] + ", " + pair[1] + " : " + "not zero or one edit away");
			}
		}
		
	}
}