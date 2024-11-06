import java.awt.event.ActionListener;
import javax.swing.*;

public class ScientificCalculatorView extends JFrame {

    private JTextField firstNumber = new JTextField(10);
    private JLabel operationLabel = new JLabel("Operation:");
    private JComboBox<String> operationSelector = new JComboBox<>(new String[] { "+", "-", "*", "/", "sin", "cos", "tan", "sqrt", "log" });
    private JTextField secondNumber = new JTextField(10); // Used only for basic operations
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(10);

    public ScientificCalculatorView() {
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        calcPanel.add(new JLabel("Scientific Calculator"));
        calcPanel.add(firstNumber);
        calcPanel.add(operationLabel);
        calcPanel.add(operationSelector);
        calcPanel.add(secondNumber); // Ignored for single-operand operations
        calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);

        this.add(calcPanel);
    }

    public String getFirstNumber() {
        return firstNumber.getText();
    }

    public String getSecondNumber() {
        return secondNumber.getText();
    }

    public String getSelectedOperation() {
        return operationSelector.getSelectedItem().toString();
    }

    public void setCalcSolution(String solution) {
        calcSolution.setText(solution);
    }

    public void addCalculateListener(ActionListener listenForCalcButton) {
        calculateButton.addActionListener(listenForCalcButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
