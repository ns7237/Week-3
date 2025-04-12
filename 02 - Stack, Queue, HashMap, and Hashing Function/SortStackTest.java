import java.util.Stack;

class SortStack {
    public void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insertInSortedOrder(stack, temp);
        }
    }

    private void insertInSortedOrder(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, value);
            stack.push(temp);
        }
    }
}

public class SortStackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        SortStack sorter = new SortStack();
        sorter.sort(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
