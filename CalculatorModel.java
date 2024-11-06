public class CalculatorModel {
    private String calculationValue;

    // Helper functions for parsing and formatting

    private double parseDouble(String input) {
        return Double.parseDouble(input);
    }

    private String formatOutput(double result) {
        return Double.toString(result);
    }

    // Helper functions for binary operations
    private int parseBinary(String input) {
        return Integer.parseInt(input, 2);
    }

    private String formatBinary(int result) {
        return Integer.toBinaryString(result);
    }

    // Basic Arithmetic Operations (Decimal)
    public void add(String firstNumber, String secondNumber) {
        calculationValue = formatOutput(parseDouble(firstNumber) + parseDouble(secondNumber));
    }

    public void subtract(String firstNumber, String secondNumber) {
        calculationValue = formatOutput(parseDouble(firstNumber) - parseDouble(secondNumber));
    }

    public void multiply(String firstNumber, String secondNumber) {
        calculationValue = formatOutput(parseDouble(firstNumber) * parseDouble(secondNumber));
    }

    public void divide(String firstNumber, String secondNumber) {
        double second = parseDouble(secondNumber);
        if (second != 0) {
            calculationValue = formatOutput(parseDouble(firstNumber) / second);
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    // Binary Arithmetic Operations
    public void addBinary(String firstBinary, String secondBinary) {
        int firstDecimal = parseBinary(firstBinary);
        int secondDecimal = parseBinary(secondBinary);
        calculationValue = formatBinary(firstDecimal + secondDecimal);
    }

    public void subtractBinary(String firstBinary, String secondBinary) {
        int firstDecimal = parseBinary(firstBinary);
        int secondDecimal = parseBinary(secondBinary);
        calculationValue = formatBinary(firstDecimal - secondDecimal);
    }

    public void multiplyBinary(String firstBinary, String secondBinary) {
        int firstDecimal = parseBinary(firstBinary);
        int secondDecimal = parseBinary(secondBinary);
        calculationValue = formatBinary(firstDecimal * secondDecimal);
    }

    public void divideBinary(String firstBinary, String secondBinary) {
        int firstDecimal = parseBinary(firstBinary);
        int secondDecimal = parseBinary(secondBinary);
        if (secondDecimal == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        calculationValue = formatBinary(firstDecimal / secondDecimal);
    }

    // Scientific Operations
    public void sin(String number) {
        calculationValue = formatOutput(Math.sin(Math.toRadians(parseDouble(number))));
    }

    public void cos(String number) {
        calculationValue = formatOutput(Math.cos(Math.toRadians(parseDouble(number))));
    }

    public void tan(String number) {
        calculationValue = formatOutput(Math.tan(Math.toRadians(parseDouble(number))));
    }

    public void sqrt(String number) {
        calculationValue = formatOutput(Math.sqrt(parseDouble(number)));
    }

    public void log(String number) {
        calculationValue = formatOutput(Math.log10(parseDouble(number)));
    }

    public String getCalculationValue() {
        return calculationValue;
    }
}
