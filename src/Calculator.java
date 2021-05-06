import java.util.EmptyStackException;
import java.util.Scanner;

public class Calculator {
        final int CAPACITY = 20;
        char[] stack = new char[CAPACITY];
        int top = 0;

        void push (char item) {
            stack[top] = item;
            top++;
        }

        char pop() {
            char answer;
            if (top == 0) {
                throw new EmptyStackException();
            }
            answer = stack[--top];
            stack[top] = '\0';
            return answer;
        }

        char peek() {
            return stack[top-1];
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator s = new Calculator();

        System.out.print("Infix 수식 입력 >> ");
        String arr = scanner.nextLine();

        System.out.print("Postfix 변환 결과 >> ");

        int length = arr.length();
        int curr = 0;

        while (curr <= length) {
            switch (arr.charAt(curr)) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                    s.push(arr.charAt(curr));
                    curr++;
                    break;
                case ')':
                    curr++;
                    while (s.peek() != '(') {
                        System.out.print(s.pop());
                    }
                    s.pop();
                    break;
                default:
                    System.out.print(arr.charAt(curr));
                    curr++;
                    break;
            }
            if (curr == length) {
                System.out.print(s.pop());
                break;
            }
        }

        /*Calculator s = new Calculator();

        s.push('+');
        s.push('-');
        s.push('*');

        System.out.print(s.pop());
        System.out.print(s.pop());
        System.out.print(s.pop());*/
    }
}
