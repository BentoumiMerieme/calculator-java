import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorModel theModel;
    private DecimalCalculatorView decimalView;
    private BinaryCalculatorView binaryView;
    private ScientificCalculatorView scientificView;
    private CalculatriceView simpleView;

    public CalculatorController(DecimalCalculatorView decimalView, BinaryCalculatorView binaryView,
                                ScientificCalculatorView scientificView, CalculatriceView simpleView,
                                CalculatorModel theModel) {
        this.decimalView = decimalView;
        this.binaryView = binaryView;
        this.scientificView = scientificView;
        this.simpleView = simpleView;
        this.theModel = theModel;

        this.decimalView.addCalculateListener(new DecimalCalculateListener());
        this.binaryView.addCalculateListener(new BinaryCalculateListener());
        this.scientificView.addCalculateListener(new ScientificCalculateListener());
        this.simpleView.addButtonListener(new SimpleButtonClickListener());
    }

    // Listener for decimal calculator
    class DecimalCalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String firstNumber = decimalView.getFirstNumber();
                String secondNumber = decimalView.getSecondNumber();
                String operation = decimalView.getSelectedOperation();

                switch (operation) {
                    case "+":
                        theModel.add(firstNumber, secondNumber);
                        break;
                    case "-":
                        theModel.subtract(firstNumber, secondNumber);
                        break;
                    case "*":
                        theModel.multiply(firstNumber, secondNumber);
                        break;
                    case "/":
                        theModel.divide(firstNumber, secondNumber);
                        break;
                }

                decimalView.setCalcSolution(theModel.getCalculationValue());
            } catch (NumberFormatException ex) {
                decimalView.displayErrorMessage("Please enter valid integers.");
            } catch (ArithmeticException ex) {
                decimalView.displayErrorMessage("Error: " + ex.getMessage());
            }
        }
    }

    // Listener for binary calculator
    class BinaryCalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String firstBinary = binaryView.getFirstBinaryNumber();
                String secondBinary = binaryView.getSecondBinaryNumber();
                String operation = binaryView.getSelectedOperation();

                switch (operation) {
                    case "+":
                        theModel.addBinary(firstBinary, secondBinary);
                        break;
                    case "-":
                        theModel.subtractBinary(firstBinary, secondBinary);
                        break;
                    case "*":
                        theModel.multiplyBinary(firstBinary, secondBinary);
                        break;
                    case "/":
                        theModel.divideBinary(firstBinary, secondBinary);
                        break;
                }

                binaryView.setCalcSolution(theModel.getCalculationValue());
            } catch (NumberFormatException ex) {
                binaryView.displayErrorMessage("Please enter valid binary numbers.");
            } catch (ArithmeticException ex) {
                binaryView.displayErrorMessage("Error: " + ex.getMessage());
            }
        }
    }

    // Listener for scientific calculator
    class ScientificCalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String firstNumber = scientificView.getFirstNumber();
                String secondNumber = scientificView.getSecondNumber();
                String operation = scientificView.getSelectedOperation();

                switch (operation) {
                    case "+":
                        theModel.add(firstNumber, secondNumber);
                        break;
                    case "-":
                        theModel.subtract(firstNumber, secondNumber);
                        break;
                    case "*":
                        theModel.multiply(firstNumber, secondNumber);
                        break;
                    case "/":
                        theModel.divide(firstNumber, secondNumber);
                        break;
                    case "sin":
                        theModel.sin(firstNumber);
                        break;
                    case "cos":
                        theModel.cos(firstNumber);
                        break;
                    case "tan":
                        theModel.tan(firstNumber);
                        break;
                    case "sqrt":
                        theModel.sqrt(firstNumber);
                        break;
                    case "log":
                        theModel.log(firstNumber);
                        break;
                }

                scientificView.setCalcSolution(theModel.getCalculationValue());
            } catch (NumberFormatException ex) {
                scientificView.displayErrorMessage("Please enter valid numbers.");
            } catch (ArithmeticException ex) {
                scientificView.displayErrorMessage("Error: " + ex.getMessage());
            }
        }
    }

    // Listener for simple calculator operations
    class SimpleButtonClickListener implements ActionListener {
        private String currentInput = "";
        private String operator = "";
        private String lastResult = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("\\d") || command.equals(",")) {
                currentInput += command.equals(",") ? "." : command; // Use "." for decimal
                simpleView.setDisplayText(currentInput);
            } else if (command.equals("C")) {
                resetCalculator();
            } else if (command.equals("=")) {
                calculateResult();
            } else {
                // Handle scientific operations or set an arithmetic operator
                handleOperator(command);
            }
        }

        private void resetCalculator() {
            currentInput = "";
            operator = "";
            lastResult = "";
            simpleView.setDisplayText("");
        }

        private void calculateResult() {
            try {
                if (operator.isEmpty()) {
                    lastResult = currentInput;
                } else {
                    switch (operator) {
                        case "+":
                            theModel.add(lastResult, currentInput);
                            break;
                        case "-":
                            theModel.subtract(lastResult, currentInput);
                            break;
                        case "*":
                            theModel.multiply(lastResult, currentInput);
                            break;
                        case "/":
                            theModel.divide(lastResult, currentInput);
                            break;
                        case "sin":
                            theModel.sin(currentInput);
                            break;
                        case "cos":
                            theModel.cos(currentInput);
                            break;
                        case "tan":
                            theModel.tan(currentInput);
                            break;
                        case "sqrt":
                            theModel.sqrt(currentInput);
                            break;
                        case "log":
                            theModel.log(currentInput);
                            break;
                    }
                    lastResult = theModel.getCalculationValue();
                }
                simpleView.setDisplayText(lastResult);
                currentInput = lastResult; // Allow chaining calculations
            } catch (ArithmeticException ex) {
                simpleView.setDisplayText("Error: " + ex.getMessage());
                resetCalculator();
            }
        }

        private void handleOperator(String command) {
            if (command.matches("[+\\-*/]")) { // Basic operators
                if (!currentInput.isEmpty()) {
                    lastResult = currentInput;
                    currentInput = "";
                    operator = command;
                }
            } else if (command.matches("sin|cos|tan|sqrt|log")) { // Scientific operators
                operator = command;
                calculateResult();
            }
        }
    }
}
