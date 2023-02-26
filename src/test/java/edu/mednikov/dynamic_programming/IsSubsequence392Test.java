package edu.mednikov.dynamic_programming;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsSubsequence392Test {

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("", "", true),
                Arguments.of("a", "", false),
                Arguments.of("b", "c", false),
                Arguments.of("abc", "axbyzc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("acb", "ahbgdc", false),
                Arguments.of("rjufvjafbxnbgriwgokdgqdqewn", "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq", false)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void isSubsequence(String s, String t, boolean expected) {
        assertThat(new IsSubsequence392().isSubsequence(s, t)).isEqualTo(expected);
    }
}