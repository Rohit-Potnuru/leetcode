public class Solution {
    public String reverseWords(String s) {
        String[] word = s.split(" ");
		int len = word.length;
		if(len<1){
		    return s;
		}
		String sentence = word[len-1];
		for (int i = len - 1 ;i > 0 ;i--){
			sentence = sentence + " " + word[i-1];
		}
		return sentence;
	}
}