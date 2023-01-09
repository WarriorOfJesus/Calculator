package calculator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Calculator implements Universal {
    Scanner scanner = new Scanner(System.in);
    private double number1;
    private double number2;
    private double sum;
    ArrayList<Double> story = new ArrayList<>();

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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
        double sum = this.sum = number1 + number2;
        story.add(sum);
        System.out.println("Answer is: " + sum);
    }

    @Override
    public void divide() {
        try {
            double division = number1 / number2;
            story.add(division);
            System.out.println("Answer is: " + division);
        } catch (ArithmeticException e) {
            System.out.println(" by zero is " + e);
        }

    }

    @Override
    public void multiply() {
        double sum = number1 * number2;
        story.add(sum);
        System.out.println("Answer is: " + sum);

    }

    @Override
    public void subtract() {
        double sum = number1 - number2;
        story.add(sum);
        System.out.println("Answer is: " + sum);

    }

    @Override
    public void universal() throws IOException {
        String answer;
        do {
            System.out.println("If you want to start, write <<Start>>");
            System.out.println("If you want to stop write <<End>>");
            answer = scanner.nextLine();
            if (Objects.equals(answer, "Start")) {
                print("Enter first number, math sign and  second number : ");
                this.number1 = scanner.nextDouble();
                char mathSign = scanner.next().charAt(0);
                this.number2 = scanner.nextDouble();
                scanner.nextLine();
                switch (mathSign) {
                    case '+' -> add();
                    case '-' -> subtract();
                    case '/' -> divide();
                    case '*' -> multiply();
                    case '%' -> percent();
                }
                System.out.println("do you want to see the history of the calculator?");
                System.out.println("yes or no");
                String answer2 = scanner.nextLine();
                if (Objects.equals(answer2, "yes")) {
                    System.out.println("Your story " + story);
//                    read();
                }
            } else if (Objects.equals(answer, "End")) {
                System.out.println("Ok it's your choice)");
            } else {
                System.out.println("Try again");
            }
        } while (!Objects.equals(answer, "End"));
    }

    @Override
    public void percent() {
        double sum = number1 / 100 * number2;
        story.add(sum);
        System.out.println("Answer: " + sum);
    }

    @Override
    public void read() throws IOException {
        FileReader fileReader = new FileReader("File7.txt");
        Scanner scanner1 = new Scanner(fileReader);
        int i = 1;
        while (scanner1.hasNextLine()) {
            System.out.println(i + ": " + scanner1.nextDouble());
            i++;
        }
        fileReader.close();
    }

    @Override
    public void write() throws IOException {
        FileWriter fileWriter = new FileWriter("File7.txt");
        fileWriter.write(String.valueOf(story));
        fileWriter.close();
    }
}
