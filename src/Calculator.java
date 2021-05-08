import java.util.EmptyStackException;
import java.util.Scanner;

public class Calculator {
    final int CAPACITY = 20;    //스택 최대 크기
    char[] stack = new char[CAPACITY];  //스택
    int top = 0;    //가장 위 원소 번호+1, 스택이 비어있으면 0

    void push (char item) {     //push 함수
        stack[top] = item;      //인자로 받은 item변수를 스택의 가장 위에 넣어줌
        top++;      //top 크기 하나 증가
    }

    char pop() {        //pop 함수
        char answer;    //리턴할 answer 변수
        if (top == 0) { //스택이 비어있을 경우,
            throw new EmptyStackException();       //EmptyStackException()
        }
        answer = stack[--top];  //가장 위 원소 answer에 할당
        stack[top] = '\0';      //넣어준 원소 삭제
        return answer;          //answer 리턴
    }

    char peek() {
            return stack[top-1];
        }       //스택에서 원소를 꺼내지 않고, 가장 위에 있는 원소 리턴

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator s = new Calculator();

        System.out.print("Infix 수식 입력 >> ");
        String arr = scanner.nextLine();

        System.out.print("Postfix 변환 결과 >> ");

        int length = arr.length();      //입력된 수식의 길이
        int curr = 0;       //현재 커서, 수식 배열을 돌면서 하나씩 판별

        while (true) {    //무한루프, 반복문 탈출조건은 따로 명시
            switch (arr.charAt(curr)) {     //switch문으로 현재 커서 판별
                case ' ':   //operator가 공백일 경우,
                    curr++;
                    break;  //커서 크기만 증가시키고 break
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':   //operator가 +, -, *, /일 경우,
                    s.push(arr.charAt(curr));
                    curr++;
                    break;  //스택에 push하고 커서 크기 증가시킨 후, break
                case ')':   //operator가 )일 경우,
                    curr++; //커서 크기 증가
                    while (s.peek() != '(') {
                        System.out.print(s.pop());
                    }       //(가 나올때까지 스택에 들어있는 원소들 출력
                    s.pop();    //마지막에 남아있는 ( pop
                    break;
                default:    //연산자가 아닌 숫자일경우,
                    System.out.print(arr.charAt(curr));
                    curr++;
                    break;  //화면에 바로 출력, 커서 크기 증가시키고 break
            }
            if (curr == length) {   //커서의 크기가 length와 같아지면,
                System.out.print(s.pop());
                break;
            }       // 스택에 마지막으로 남아있는 원소 화면에 출력해주고 반복문 탈출
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
