public class RomanCalculator implements Calculator {

    private static RomanCalculator calculator;
    private int[] digit = new int[2];
    private  int answer;

    private RomanCalculator() {
    }

    public static RomanCalculator getCalculator() {
        if (calculator == null) {
            calculator = new RomanCalculator();
        }
        return calculator;
    }

    public void summation(String a, String b) {
        arabicParseNumbers(a,b);
        answer = digit[0] + digit[1];
        System.out.println(romanParseNumbers(answer));
    }

    public void subtraction(String a, String b) {
        arabicParseNumbers(a,b);
        answer = digit[0] - digit[1];
        System.out.println(romanParseNumbers(answer));
    }

    public void multiplication(String a, String b) {
        arabicParseNumbers(a,b);
        answer = digit[0] * digit[1];
        System.out.println(romanParseNumbers(answer));
    }

    public void division(String a, String b) {
        arabicParseNumbers(a,b);
        answer = digit[0] / digit[1];
        System.out.println(romanParseNumbers(answer));
    }

    private void arabicParseNumbers(String a, String b) {
        digit[0] = EnumRomanNumerals.valueOf(a).getValue();
        digit[1] = EnumRomanNumerals.valueOf(b).getValue();

    }

    private String romanParseNumbers(int digit) {

        for (EnumRomanNumerals en: EnumRomanNumerals.values()) {
            if (en.getValue() == digit)
                return en.getKey();
        }
        return null;
    }
}
