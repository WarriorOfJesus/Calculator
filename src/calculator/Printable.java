package calculator;

public interface Printable {
    default void print(String message) {
        System.out.print(message);
    }
}
