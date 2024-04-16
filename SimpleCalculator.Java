import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

    JButton button;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button = new JButton("Perform Operation");
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(button);
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String[] options = {"Addition", "Subtraction", "Multiplication", "Division"};
            int choice = JOptionPane.showOptionDialog(this, "Select Operation", "Operation Selection",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) { // Addition
                performAddition();
            } else if (choice == 1) { // Subtraction
                performSubtraction();
            } else if (choice == 2) { // Multiplication
                performMultiplication();
            } else if (choice == 3) { // Division
                performDivision();
            }
        }
    }

    private void performAddition() {
        double num1 = getNumberInput("Enter first number:");
        double num2 = getNumberInput("Enter second number:");
        double result = num1 + num2;
        displayResult(result);
    }

    private void performSubtraction() {
        double num1 = getNumberInput("Enter first number:");
        double num2 = getNumberInput("Enter second number:");
        double result = num1 - num2;
        displayResult(result);
    }

    private void performMultiplication() {
        double num1 = getNumberInput("Enter first number:");
        double num2 = getNumberInput("Enter second number:");
        double result = num1 * num2;
        displayResult(result);
    }

    private void performDivision() {
        double num1 = getNumberInput("Enter dividend:");
        double num2 = getNumberInput("Enter divisor:");
        if (num2 == 0) {
            JOptionPane.showMessageDialog(this, "Error: Division by zero is not allowed.");
        } else {
            double result = num1 / num2;
            displayResult(result);
        }
    }

    private double getNumberInput(String message) {
        String input = JOptionPane.showInputDialog(this, message);
        return Double.parseDouble(input);
    }

    private void displayResult(double result) {
        JOptionPane.showMessageDialog(this, "Result: " + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}

