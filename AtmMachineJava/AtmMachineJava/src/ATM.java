import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ATM extends JFrame {
    private int balance = 1000;
    private JLabel displayLabel;
    private JTextField inputField;

    public ATM() {
        setLayout(new FlowLayout());
        displayLabel = new JLabel("Enter amount to withdraw or deposit:");
        inputField = new JTextField(10);
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");

        add(displayLabel);
        add(inputField);
        add(withdrawButton);
        add(depositButton);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputField.getText().isEmpty()) {
                    displayLabel.setText("Please enter an amount");
                } else {
                    int amount = Integer.parseInt(inputField.getText());
                    if (balance >= amount) {
                        balance -= amount;
                        displayLabel.setText("Withdrew " + amount + ", Current balance is " + balance);
                    } else {
                        displayLabel.setText("Insufficient funds");
                    }
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inputField.getText().isEmpty()) {
                    displayLabel.setText("Please enter an amount");
                } else {
                    int amount = Integer.parseInt(inputField.getText());
                    balance += amount;
                    displayLabel.setText("Deposited " + amount + ", Current balance is " + balance);
                }
            }
        });
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        atm.setSize(600, 200);
        atm.setVisible(true);
        atm.setTitle("ATM");
    }
}
