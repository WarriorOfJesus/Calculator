package calculator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Calculator implements Universal {
    Scanner scanner = new Scanner(System.in);
    private double number1;
    private double number2;
    ArrayList<Integer> myIntegerArrayList = new ArrayList<>();

    public Calculator(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public Calculator() {
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }


    @Override
    public String toString() {
        return "Calculator{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                '}';
    }

    @Override
    public void add() {
        double sum = number1 + number2;
        System.out.println("Answer is: " + sum);
    }

    @Override
    public void divide() {
        try {
            double division = number1 / number2;
            System.out.println("Answer is: " + division);
        } catch (ArithmeticException e) {
            System.out.println(" by zero is " + e);
        }

    }

    @Override
    public void multiply() {
        double sum = number1 * number2;
        System.out.println("Answer is: " + sum);

    }

    @Override
    public void subtract() {
        double sum = number1 - number2;
        System.out.println("Answer is: " + sum);

    }

    @Override
    public void universal() {
        String start = "Start";
        String end = "End";
        String answer = null;
        do {
            System.out.println("If you want to start, write <<Start>>");
            System.out.println("If you want to stop write <<End>>");
            answer = scanner.nextLine();
            if (Objects.equals(answer, start)) {
                printable("Enter first number, math sign and  second number : ");
                this.number1 = scanner.nextDouble();
                char mathSign = scanner.next().charAt(0);
                this.number2 = scanner.nextDouble();
                switch (mathSign) {
                    case '+' -> {
                        add();
                    }
                    case '-' -> {
                        subtract();
                    }
                    case '/' -> {
                        divide();
                    }
                    case '*' -> {
                        multiply();
                    }
                }
            } else{
                System.out.println("Try again");
                answer = scanner.nextLine();
            }
        } while (!Objects.equals(answer, end));
    }
}
