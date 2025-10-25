package morseCode;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Font;
import static morseCode.MorseCode.englishToMorse;
import static morseCode.MorseCode.morseToEnglish;

public class MorseCodeFrame extends JFrame implements ActionListener {

    // Morse Code Importing into an Array
    private static final String[] code = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--..",
            "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...",
            "---..", "----.", "/" };

    // English Strings
    private static final char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };

    JFrame frame = new JFrame();
    // JPanel panel = new JPanel(new GridLayout(0,1));
    JPanel panel = new JPanel();
    Font boldFont = new Font("Arial", Font.BOLD, 14);
    JLabel title = new JLabel();
    JLabel title2 = new JLabel();
    JTextField morseText = new JTextField(20);
    JTextField englishText = new JTextField(20);
    JButton submit = new JButton();
    JLabel morseInfo = new JLabel();
    JLabel englishInfo = new JLabel();
    JLabel displayLabel = new JLabel();
    JLabel result = new JLabel();

    public MorseCodeFrame() {
        frame.add(panel);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(title);
        panel.add(title2);
        panel.add(morseInfo);
        panel.add(morseText);
        panel.add(englishInfo);
        panel.add(englishText);
        panel.add(submit);
        panel.add(displayLabel);
        panel.add(result);

        frame.setBackground(Color.LIGHT_GRAY);
        frame.setTitle("Morse Code / English Translator");

        title.setFont(boldFont);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setText("Morse Code / English Translator");
        title2.setFont(boldFont);
        title2.setAlignmentX(Component.CENTER_ALIGNMENT);
        title2.setText("Enter Only 1 of the Following Fields:");

        panel.setBackground(Color.WHITE);

        morseInfo.setText("Enter Morse Code OR");
        morseText.setBackground(Color.CYAN);

        englishInfo.setText("Enter English Text");
        englishText.setBackground(Color.GREEN);

        submit.setSize(200, 200);
        submit.setText("Submit");
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        submit.addActionListener(this);

        displayLabel.setText(" ");
        result.setText(" ");
        result.setFocusable(false); // Make it uneditable
        result.setBorder(null);    // Remove the border
        result.setOpaque(false);   // Make it transparent
        result.setFocusable(true); // Allow focus for copying

        frame.setVisible(true);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String morseTextField = morseText.getText();
        String englishTextField = englishText.getText();

        if (e.getSource() == submit) {
            // set the text of the label to the text of the field
            if (morseTextField.isEmpty() && englishTextField.isEmpty()) {
                displayLabel.setText("Hmmm... Please enter Morse OR English");
            } else {
                displayLabel.setText("Got it, it's time to Convert! Check Below: ");
                if (morseTextField.isEmpty()) {
                    String resultText = englishToMorse(code, englishTextField, letters);
                    result.setText("Here's Your Result:  " + resultText + "  ❤️");
                    result.requestFocusInWindow();
                } else if (englishTextField.isEmpty()) {
                    String resultText = morseToEnglish(code, morseTextField);
                    result.setText("Here's Your Result:  " + resultText + "  ❤️");
                    result.requestFocusInWindow();
                }

            }
        }
    }

    public static void main(String[] args) {
        // Ensure GUI updates are handled on the Event Dispatch Thread
        SwingUtilities.invokeLater(MorseCodeFrame::new);

    }

}
