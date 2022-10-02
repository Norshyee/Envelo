import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Zadanie2Test {

    private Zadanie2 task;

    @BeforeEach
    void init() {
        task = new Zadanie2();
    }

    private static Stream<Arguments> searchArguments() {
        int[] array = IntStream.of(123, 56, 19, 12, 10, 4).toArray();

        return Stream.of(
                Arguments.of(array, 123),
                Arguments.of(array, 56),
                Arguments.of(array, 19),
                Arguments.of(array, 10),
                Arguments.of(array, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("searchArguments")
    void positiveSearchTest(int[] numbers, int x) {
        Assertions.assertTrue(task.searchNumber(numbers, x));
    }

    @ParameterizedTest
    @MethodSource("searchArguments")
    void negativeSearchTest(int[] numbers, int x) {
        Assertions.assertFalse(task.searchNumber(numbers, x - 1));
    }
}