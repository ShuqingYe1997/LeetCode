public class String2IntegerAtoi {
    class Solution {
        public int myAtoi(String s) {
            if (s == null) return 0;
            s = s.trim();
            if (s.length() == 0) return 0;
            int i;
            for (i = 0; i < s.length(); i++) {
                if (i == 0 && !isValid(s.charAt(i)))
                    return 0;
                if (isValid(s.charAt(i)))
                    break;
            }
            //处理完符号，进入数字部分
            int factor = 1;
            if (!isNumber(s.charAt(i))) {
                if (s.charAt(i) == '-')
                    factor = -1;
                i++;
            }
            double num = 0;
            for (; i < s.length(); i++) {
                if (!isNumber(s.charAt(i)))
                    break;
                else {
                    num *= 10;
                    num += s.charAt(i) - '0';
                }
                if (num * factor > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (num * factor < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            return (int) num * factor;
        }

        public boolean isNumber(char c) {
            return (c >= '0' && c <= '9');
        }

        public boolean isValid(char c) {
            return isNumber(c) || c == '+' || c == '-';
        }

    }
}
