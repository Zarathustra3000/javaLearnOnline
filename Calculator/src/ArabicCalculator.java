public class ArabicCalculator implements Calculator {

    private static ArabicCalculator calculator;

    private ArabicCalculator() {
    }

    public static ArabicCalculator getCalculator() {
        if (calculator == null) {
            calculator = new ArabicCalculator();
        }
        return calculator;
    }

    public void summation(String a, String b) {
        System.out.println(Integer.parseInt(a) + Integer.parseInt(b));
    }

    public void subtraction(String a, String b) {
        System.out.println(Integer.parseInt(a) - Integer.parseInt(b));
    }

    public void multiplication(String a, String b) {
        System.out.println(Integer.parseInt(a) * Integer.parseInt(b));
    }

    public void division(String a, String b) {
        System.out.println(Integer.parseInt(a) / Integer.parseInt(b));
    }

}
