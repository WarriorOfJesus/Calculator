package itacademy.calculator;

public interface Printable {
    default void printable(String message) {
        System.out.print(message);
    }
}
