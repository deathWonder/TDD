import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PhoneBookTest {
    PhoneBook phoneBook = PhoneBook.getInstance();
    @ParameterizedTest
    @MethodSource("addSource")
    public void testAdd(String name, String number, int expected) {
        int result = phoneBook.add(name, number);
        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments> addSource(){
        return Stream.of(
                Arguments.of("Name1", "89999999990", 1),
                Arguments.of("Name2", "89999999991", 2),
                Arguments.of("Name3", "89999999992", 3)
        );
    }
}
