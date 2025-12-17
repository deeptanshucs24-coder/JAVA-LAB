import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DivisionUI extends JFrame implements ActionListener {
    // UI Components
    JTextField txtNum1, txtNum2, txtResult;
    JButton btnDivide;

    public DivisionUI() {
        // Frame Settings
        setTitle("Integer Division");
        setSize(300, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // UI Elements
        add(new JLabel("Number 1:"));
        txtNum1 = new JTextField(20);
        add(txtNum1);

        add(new JLabel("Number 2:"));
        txtNum2 = new JTextField(20);
        add(txtNum2);

        add(new JLabel("Result:"));
        txtResult = new JTextField(20);
        txtResult.setEditable(false); // Result should not be editable
        add(txtResult);

        btnDivide = new JButton("Divide");
        add(btnDivide);

        // Adding Listener
        btnDivide.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Retrieve values and parse to integers
            // Throws NumberFormatException if input is not an integer
            int num1 = Integer.parseInt(txtNum1.getText());
            int num2 = Integer.parseInt(txtNum2.getText());

            // Perform division
            // Throws ArithmeticException if num2 is 0
            int result = num1 / num2;

            // Display Result
            txtResult.setText(String.valueOf(result));

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, 
                "Error: Please enter valid integers.", 
                "Number Format Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ae) {
            JOptionPane.showMessageDialog(this, 
                "Error: Cannot divide by zero.", 
                "Arithmetic Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new DivisionUI();
    }
}