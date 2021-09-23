import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    class Solution {
        List<String> result = new ArrayList<>();
        String s;
        String[][] alphabet= {
                {"a","b","c"},
                {"d","e","f"},
                {"g","h","i"},
                {"j","k","l"},
                {"m","n","o"},
                {"p","q","r","s"},
                {"t","u","v"},
                {"w","x","y","z"}};

        public List<String> letterCombinations(String digits) {
            if(digits==null || digits.length()==0) return result;
            this.s = digits;
            appendLetter("",0);
            return result;
        }

        public void appendLetter(String substring,int idx){
            if(idx>s.length()) return;
            else if(idx < s.length()){
                int a = s.charAt(idx)-'2';
                for(int i=0; i<alphabet[a].length;i++){
                    appendLetter(substring+alphabet[a][i],idx+1);
                }
            }
            else result.add(substring);
        }
    }
}
