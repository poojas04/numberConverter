import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * High-Level Number System Converter (GUI Version)
 * 
 * This program provides functionality to convert numbers
 * between binary, decimal, octal, and hexadecimal formats.
 * It features a professional graphical user interface for
 * seamless base conversions.
 */
public class NumberSystemConverterGUI {

    /**
     * Converts a number from one base to another.
     *
     * @param number The input number as a string.
     * @param fromBase The base of the input number (e.g., 2, 10, 8, 16).
     * @param toBase The base to convert to (e.g., 2, 10, 8, 16).
     * @return The converted number as a string.
     */
    public static String convertBase(String number, int fromBase, int toBase) {
        int decimalValue = Integer.parseInt(number, fromBase);
        return Integer.toString(decimalValue, toBase).toUpperCase();
    }

    /**
     * Initializes and displays the GUI for the Number System Converter.
     */
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Universal Number Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.getContentPane().setBackground(Color.PINK);

        // Create a panel with centered layout
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK); // Ensure the panel also has a pink background
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components
        JLabel numberLabel = new JLabel("Enter the number to convert:");
        JTextField numberField = new JTextField(15);
        JLabel fromBaseLabel = new JLabel("Select the base of the input number:");

        String[] inputBases = {"Binary (2)", "Decimal (10)", "Octal (8)", "Hexadecimal (16)"};
        JComboBox<String> fromBaseDropdown = new JComboBox<>(inputBases);

        JLabel toBaseLabel = new JLabel("Select the base to convert to:");
        
        String[] bases = {"Binary (2)", "Decimal (10)", "Octal (8)", "Hexadecimal (16)"};
        JComboBox<String> toBaseDropdown = new JComboBox<>(bases);
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField(20); // Make the result field longer
        resultField.setEditable(false);
        resultField.setFont(new Font("Arial", Font.BOLD, 14)); // Set the result field text to bold

        // Set resultLabel text to bold as well
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set the "Result" label text to bold

        // Position components using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(numberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(numberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(fromBaseLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(fromBaseDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(toBaseLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(toBaseDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        panel.add(convertButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1; // Reset gridwidth
        gbc.anchor = GridBagConstraints.WEST; // Reset alignment
        panel.add(resultLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(resultField, gbc);

        // Add action listener for the convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String numberInput = numberField.getText();
                    int fromBase = switch (fromBaseDropdown.getSelectedIndex()) {
                        case 0 -> 2; // Binary
                        case 1 -> 10; // Decimal
                        case 2 -> 8; // Octal
                        case 3 -> 16; // Hexadecimal
                        default -> throw new IllegalStateException("Unexpected value: " + fromBaseDropdown.getSelectedIndex());
                    };
                    int toBase = switch (toBaseDropdown.getSelectedIndex()) {
                        case 0 -> 2; // Binary
                        case 1 -> 10; // Decimal
                        case 2 -> 8; // Octal
                        case 3 -> 16; // Hexadecimal
                        default -> throw new IllegalStateException("Unexpected value: " + toBaseDropdown.getSelectedIndex());
                    };

                    // Perform conversion
                    String result = convertBase(numberInput, fromBase, toBase);
                    resultField.setText(result);
                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid input. Ensure correct number and base.");
                }
            }
        });

        // Add panel to frame and center it
        frame.add(panel);
        frame.setLocationRelativeTo(null); // Center frame on screen
        frame.setVisible(true);
    }
}
