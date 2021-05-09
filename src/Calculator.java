import java.util.EmptyStackException;
import java.util.Scanner;

public class Calculator {
    final int CAPACITY = 20;    //스택 최대 크기
    char[] stack = new char[CAPACITY];  //스택
    int top = 0;    //가장 위 원소 번호+1, 스택이 비어있으면 0
    //top의 초깃값을 -1로 하지 않고 0으로 설정한 이유는
    // 이후 코드에서 스택의 length를 좀 더 편하게 다루기 위해서이다.

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
        Calculator s = new Calculator();    //postfix 수식을 만들기 위해 사용되는 스택
        Calculator postfixRe = new Calculator();    //완성된 postfix 수식이 거꾸로 담기게 되는 스택
        Calculator postfix = new Calculator();      //완성된 postfix 수식이 차례대로 담기는 스택
        Calculator calc = new Calculator();     //postfix 수식의 결과값을 구하기 위해 사용되는 스택

        System.out.print("Infix 수식 입력 >> ");
        String arr = scanner.nextLine();

        System.out.print("Postfix 변환 결과 >> ");

        int length = arr.length();      //입력된 수식의 길이
        int curr = 0;       //현재 커서, 수식 배열을 돌면서 하나씩 판별

        while (true) {    //무한루프, 반복문 탈출조건은 따로 명시
            switch (arr.charAt(curr)) {     //switch 문으로 현재 커서 판별
                case ' ':
                    curr++;
                    break;  //operator 가 공백일 경우, 커서 크기만 증가시키고 break
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':   //operator 가 +, -, *, /일 경우,
                    s.push(arr.charAt(curr));
                    curr++;
                    break;  //스택에 push 하고 커서 크기 증가시킨 후, break
                case ')':   //operator 가 )일 경우,
                    curr++; //커서 크기 증가
                    while (s.peek() != '(') {
                        postfixRe.push(s.peek());
                        System.out.print(s.pop());
                    }   //( 가 나오기 전까지 스택에 들어있는 인자들 pop
                    s.pop();    //마지막에 남아있는 ( pop
                    break;
                default:    //연산자가 아닌 숫자일경우,
                    System.out.print(arr.charAt(curr));
                    postfixRe.push(arr.charAt(curr));
                    curr++;
                    break;
            }   //화면에 바로 출력해주고 curr 증가
            if (curr == length) {   //커서의 크기가 length 와 같아지면,
                postfixRe.push(s.peek());
                System.out.println(s.pop());
                break;
            }   //마지막으로 스택에 남아있는 인자 pop 해주고 화면에 출력
        }
        //Infix 수식 Postfix 수식으로 변환 및 출력 완료

        int postfixLen = postfixRe.top;     //postfix 수식의 길이
        int tmp1, tmp2, tmpSum=0, sum=0;

        for (int i = 0; i < postfixLen; i++)
            postfix.push(postfixRe.pop());  //Reverse 로 들어있는 postfix 수식을
        // 다시 적절한 순서로 postfix 스택에 넣어준다.

        for (int i = 0; i < postfixLen; i++) {
            switch (postfix.peek()) {   //switch 문 안에서 postfix.peek()가 커서 역할
                case '+':
                    tmp1 = Character.getNumericValue(calc.pop());
                    tmp2 = Character.getNumericValue(calc.pop());
                    tmpSum = tmp2 + tmp1;
                    calc.push((char)tmpSum);
                    postfix.pop();
                    break;     //operator 가 +일 경우, 숫자 두개를 꺼내서 더해준 다음, 다시 calc 스택에 넣어준다.
                case '-':
                    tmp1 = Character.getNumericValue(calc.pop());
                    tmp2 = Character.getNumericValue(calc.pop());
                    tmpSum = tmp2 - tmp1;
                    calc.push((char)tmpSum);
                    postfix.pop();
                    break;     //operator 가 -일 경우, 숫자 두개를 꺼내서 빼준 다음, 다시 calc 스택에 넣어준다.
                case '*':
                    tmp1 = Character.getNumericValue(calc.pop());
                    tmp2 = Character.getNumericValue(calc.pop());
                    tmpSum = tmp2 * tmp1;
                    calc.push((char)tmpSum);
                    postfix.pop();
                    break;     //operator 가 *일 경우, 숫자 두개를 꺼내서 곱해준 다음, 다시 calc 스택에 넣어준다.
                case '/':
                    tmp1 = Character.getNumericValue(calc.pop());
                    tmp2 = Character.getNumericValue(calc.pop());
                    tmpSum = tmp2 / tmp1;
                    calc.push((char)tmpSum);
                    postfix.pop();
                    break;     //operator 가 /일 경우, 숫자 두개를 꺼내서 나눠준 다음, 다시 calc 스택에 넣어준다.
                default:
                    calc.push(postfix.pop());   //operator 가 아닌 그냥 숫자인 경우, 그냥 calc 스택에 넣어준다.
            }
        }
        sum = calc.pop();
        System.out.println("Postfix 수식 계산 결과값 >> " + sum);
    }   //가장 마지막까지 남아있는 숫자가 결과값이니 결과값 sum 최종 출력
}