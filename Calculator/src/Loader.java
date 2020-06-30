import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static List<String> arab_numbers = new ArrayList<>();
    private static List<String> roman_numbers = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            arab_numbers.add(String.valueOf(i));
        }
        roman_numbers.add("I");
        roman_numbers.add("II");
        roman_numbers.add("III");
        roman_numbers.add("IV");
        roman_numbers.add("V");
        roman_numbers.add("VI");
        roman_numbers.add("VII");
        roman_numbers.add("VIII");
        roman_numbers.add("IX");
        roman_numbers.add("X");
    }

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String equation = reader.readLine().trim();
        try {
            String[] equationArray = equation.split(" ");

            if (isArabNumber(equation)) {
                arabCalculator(equationArray);
            } else if (isRomanNumber(equation)) {
                romanCalculator(equationArray);
            } else {
                throw new  InvalidInput("Sorry, Invalid input.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean isArabNumber(String equation) {
        String[] equationArray = equation.split(" ");

        if (arab_numbers.contains(equationArray[0]) && arab_numbers.contains(equationArray[2])) {
            return true;
        }
        return false;
    }

    private static boolean isRomanNumber(String equation) {
        String[] equationArray = equation.split(" ");
        if (roman_numbers.contains(equationArray[0]) && roman_numbers.contains(equationArray[2])) {
            return true;
        }
        return false;

    }

    private static void arabCalculator(String[] array) {

        ArabicCalculator calculator = ArabicCalculator.getCalculator();
        String numberOne = array[0];
        String numberTwo = array[2];
        String sign = array[1];

        if (sign.equals("+")) {
            calculator.summation(numberOne, numberTwo);
        } else if (sign.equals("-")) {
            calculator.subtraction(numberOne, numberTwo);
        } else if (sign.equals("*")) {
            calculator.multiplication(numberOne, numberTwo);
        } else if (sign.equals("/")) {
            calculator.division(numberOne, numberTwo);
        }
    }

    private static void romanCalculator(String[] array) {

        RomanCalculator calculator = RomanCalculator.getCalculator();
        String numberOne = array[0];
        String numberTwo = array[2];
        String sign = array[1];

        if (sign.equals("+")) {
            calculator.summation(numberOne, numberTwo);
        } else if (sign.equals("-")) {
            calculator.subtraction(numberOne, numberTwo);
        } else if (sign.equals("*")) {
            calculator.multiplication(numberOne, numberTwo);
        } else if (sign.equals("/")) {
            calculator.division(numberOne, numberTwo);
        }
    }

}
