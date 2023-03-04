import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



import java.util.stream.Stream;

public class PhoneBookTest {
    PhoneBook phoneBook = PhoneBook.getInstance();

    @AfterEach
    public void afterEach(){
        phoneBook.getContactList().clear();
    }

    @ParameterizedTest
    @MethodSource("addSource")
    public void testAdd(String name, String number, int expected) {
        int result = phoneBook.add(name, number);
        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments> addSource(){
        return Stream.of(
                Arguments.of("Name1", "89999999991", 1),
                Arguments.of("Name2", "89999999992", 1),
                Arguments.of("Name3", "89999999993", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("findByNumberSource")
    public void testFindByNumber(String name, String number, String expected){
        phoneBook.getContactList().put(name, number);
        String result = phoneBook.findByNumber(number);
        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments> findByNumberSource(){
        return Stream.of(
                Arguments.of("Name1", "89999999991", "Name1"),
                Arguments.of("Name2", "89999999992", "Name2"),
                Arguments.of("Name3", "89999999993", "Name3")
        );
    }
    @ParameterizedTest
    @MethodSource("findByNameSource")
    public void testFindByName(String name, String number, String expected){
        phoneBook.getContactList().put(name, number);
        String result = phoneBook.findByName(name);
        Assertions.assertEquals(expected, result);
    }
    public static Stream<Arguments> findByNameSource(){
        return Stream.of(
                Arguments.of("Name1", "89999999991", "89999999991"),
                Arguments.of("Name2", "89999999992", "89999999992"),
                Arguments.of("Name3", "89999999993", "89999999993")
        );
    }
    @ParameterizedTest
    @MethodSource("printAllNAmesSource")
    public void printAllNames(String name1, String number1, String name2, String number2){
        phoneBook.getContactList().put(name1, number1);
        phoneBook.getContactList().put(name2, number2);
        phoneBook.printAllNames();
    }
    public static Stream<Arguments> printAllNAmesSource(){
        return Stream.of(
                Arguments.of("Name1", "89999999991", "Name2", "89999999992"),
                Arguments.of("Name2", "89999999992", "Name3", "89999999993"),
                Arguments.of("Name3", "89999999993", "Name1", "89999999991")
        );
    }
}
