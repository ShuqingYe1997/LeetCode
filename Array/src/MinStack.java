import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;  //每个数+当前最小数

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if(!stack.isEmpty()) {
                int min = getMin();
                if (x < min)
                    min = x;
                stack.push(min);
                stack.push(x);
            }
            else{
                stack.push(x);
                stack.push(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return stack.get(stack.size()-2);
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
