package study;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestStudy {

    @Nested
    @DisplayName("String 클레스 테스트")
    class StringTest{
        @Test
        void replace() {
            String actual = "abc".replace("b", "d");
            assertThat(actual).isEqualTo("adc");
        }

        @Test
        void split(){
            String given1 = "1,2";
            String[] actual1 = given1.split(",");
            assertThat(actual1).contains("1", "2");

            String given2 = "1";
            String[] actual2 = given2.split(",");
            assertThat(actual2).containsExactly("1");
        }

        @Test
        void substring(){
            String given = "(1,2)";
            int lastIndex = given.length();
            String actual = given.substring(1, lastIndex-1);
            assertThat(actual).isEqualTo("1,2");
        }

        @Test
        void charAt(){
            String given = "abc";
            int index = 3;
            assertThatThrownBy(() -> {
                given.charAt(index);
            })
                    .isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: 3");
        }
    }

    @Nested
    @DisplayName("Set 클레스 테스트")
    class SetTest{
        private Set<Integer> numbers;

        @BeforeEach
        void setUp(){
            numbers = new HashSet<>();
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
        }

        @Test
        void size(){
            int actual = numbers.size();
            assertThat(actual).isEqualTo(3);
        }

        @Test
        void contains(){
            assertThat(numbers.contains(1)).isTrue();
            assertThat(numbers.contains(2)).isTrue();
            assertThat(numbers.contains(3)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {1,2,3})
        void parameterTest(int input){
            assertThat(numbers.contains(input)).isTrue();
        }

        @ParameterizedTest
        @CsvSource(value = {"true:false", "4:false", "5:false"}, delimiter = ':')
        void parameterTest2(Object input, Boolean expected){
            assertThat(numbers.contains(input)).isEqualTo(expected);
        }




    }






}
