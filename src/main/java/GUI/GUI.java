package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ConstantValues.ConstantValues.*;

public class GUI extends JFrame implements ActionListener {

    JButton button;
    JPanel buttonPanel;
    JTextField field;
    public GUI() {
        // Użycie kontruktora klasy nadrzędnej

        super("Simple Calculator");
        setSize(APP_SIZE[0], APP_SIZE[1]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        addPanels();
        addButtons();
        addTextFields();
    }

    private void addPanels() {
        buttonPanel = new JPanel();
        buttonPanel.setBounds(0, 100, 385, 440);
        buttonPanel.setBackground(Color.red);
        buttonPanel.setLayout(new GridLayout(4,4,5,5));

        add(buttonPanel);
    }

    private void addTextFields(){
        field = new JTextField();
        field.setEditable(false);
        field.setBounds(0,0,APP_SIZE[0],100 );
        field.setText(APP_TITLE);
        add(field);
    }

    private void addButtons() {
        for (String[] buttonText : BUTTON_TEXTS) {
            for (String s : buttonText) {
                button = new JButton(s);
                buttonPanel.add(button);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("test");
        }
    }
}
