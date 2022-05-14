package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
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
