import java.util.*;

public class ValidPathesis {
    class Solution {
        public boolean isValid(String s) {
            List left = new ArrayList(){
                { add('(');add('[');add('{'); }
            };
            List right = new ArrayList(){
                { add(')');add(']');add('}'); }
            };

            if(s.length()<=0) return true;

            Stack stack = new Stack();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(left.contains(c))  //left parentheses
                    stack.push(c);
                else if(right.contains(c)){  //right parentheses
                    if(stack.isEmpty())
                        return false;
                    char top_c = (char)stack.peek();
                    if(left.indexOf(top_c) == right.indexOf(c))  //match
                        stack.pop();
                    else break;
                }
            }
            return (stack.isEmpty() ? true:false);
        }
    }
}
