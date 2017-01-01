package ctci_practice;

public class Q1_3 {
	
	public static String replaceSpaces(char[] url, int url_length) {
		
		int space_count = 0;
		
		//count the number of spaces in the string
		for(int i =  0; i < url_length; i++) {
			if(url[i] == ' ') space_count++;
		}
		//System.out.println("Space count : " + space_count);
		
		//calculate the length of the url including the replacement text
		//url_length includes the length of the str and the spaces(to be replaced by %)
		//space_count*2 represents the additional space needed to insert
		//the second and third replacement characters (20)
		int final_length = url_length + space_count * 2;
		
		//new char array to store the urlified text
		char[] final_url = new char[final_length];
		
		//if(url_length < url.length) url[url_length] = '\0';
		
		for(int i =  url_length-1; i >= 0; i--) {
			//replace the spaces with the url text
			if(url[i] == ' ') {
				final_url[final_length - 1] = '0';
				final_url[final_length - 2] = '2';
				final_url[final_length - 3] = '%';
				final_length = final_length - 3;
			} else {
				final_url[final_length - 1] = url[i];
				final_length--;
			}
			
		}
		
		//change the char array back to a string
		String final_str = new String(final_url);
		
		return final_str;
	}
	
	public static int get_length(char[] url) {
		
		for(int i = url.length-1; i >= 0; i--) {
			if(url[i] != ' ') {
				//length of the url is one more than the index of the last char
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		String str = "Mr Taha Shabbir";
		char[] char_url = str.toCharArray();
		
		int url_len = get_length(char_url) + 1;
		
		System.out.println(str + " : " + replaceSpaces(char_url, url_len));
	}

}
