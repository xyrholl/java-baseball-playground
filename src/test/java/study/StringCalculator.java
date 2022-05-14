package study;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

    // 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현
    // 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
    // 공백을 기준으로 분리
    @Test
    void test(){
        String given = "2 + 3 * 4 / 2";
        String[] values = given.split(" ");
        int len = values.length / 2;

        List<Integer> numbers = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        for (String one :values) {
            if(one.length() < 2){
                byte[] by = one.getBytes(StandardCharsets.UTF_8);
                if(by[0] >= 48 && by[0] <= 57){
                    numbers.add(Integer.parseInt(new String(by)));
                }else{
                    operator.add(new String(by));
                }
            }else{
                numbers.add(Integer.parseInt(one));
            }
        }

        int result = numbers.get(0);
        for (int i = 1; i <= len; i++) {
            result = calculate(numbers.get(i), operator.get(i-1), result);
        }

        int answer = result;
        assertThat(answer).isEqualTo(10);

    }

    int calculate(int num, String operator, int result){
        if(num != 0){
            switch (operator){
                case "+" :
                    result += num;
                    break;
                case "-" :
                    result -= num;
                    break;
                case "*" :
                    result *= num;
                    break;
                case "/" :
                    result /= num;
                    break;
            }
        }
        return result;
    }

    @Test
    void stringReverse(){
        String given = "ABCDE";
        int len = given.length()-1;
        String reverse = "";

        for (int i = len; i >= 0; i--) {
            reverse += given.charAt(i);
        }
        StringBuffer sb = new StringBuffer();
        sb.reverse();

        assertThat(reverse).isEqualTo("EDCBA");
    }

}
