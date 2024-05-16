package web.service;

public class MathQuestionService {

    private static void validateInput(String number1, String number2) {
        if (number1 == null || number1.isEmpty() || number2 == null || number2.isEmpty()) {
            throw new RuntimeException("All fields are required.");
        }
        
        try {
            Double.parseDouble(number1);
            Double.parseDouble(number2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Enter valid numbers.");
        }
    }

    /**
     * Calculate Q1 result.
     * @param number1
     * @param number2
     * @return
     */
    public static double q1Addition(String number1, String number2) {
        validateInput(number1, number2);
        return Double.valueOf(number1) + Double.valueOf(number2);
    }

    /**
     * Calculate Q2 result.
     * @param number1
     * @param number2
     * @return
     */
    public static double q2Subtraction(String number1, String number2) {
        validateInput(number1, number2);
        return Double.valueOf(number1) - Double.valueOf(number2);
    }

    /**
     * Calculate Q3 result.
     * @param number1
     * @param number2
     * @return
     */
    public static double q3Multiplication(String number1, String number2) {
        validateInput(number1, number2);
        return Double.valueOf(number1) * Double.valueOf(number2);
    }
}
