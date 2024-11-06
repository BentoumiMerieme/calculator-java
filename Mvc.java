public class Mvc {

    public static void main(String[] args) {
        // Create the model
        CalculatorModel theModel = new CalculatorModel();

        // Create views
        DecimalCalculatorView decimalView = new DecimalCalculatorView();
        BinaryCalculatorView binaryView = new BinaryCalculatorView();
        ScientificCalculatorView scientificView = new ScientificCalculatorView();
        CalculatriceView simpleView = new CalculatriceView();

        // Create the controller with all views and the model
        new CalculatorController(decimalView, binaryView, scientificView, simpleView, theModel);

        // Set the visibility of each view
        decimalView.setVisible(true);
        binaryView.setVisible(true);
        scientificView.setVisible(true);
        simpleView.setVisible(true);
    }
}
