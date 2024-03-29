package GUI;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ConstantValues.ConstantValues.*;

public class GUI extends JFrame implements ActionListener {

    JButton button;
    JPanel buttonPanel;
    JTextField field;
    String fieldValue = "0";

    public GUI() {
        // Constructor of a base class

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
        buttonPanel.setBounds(0, 100, 384, 460);
        buttonPanel.setLayout(new GridLayout(4,4,4,4));
        add(buttonPanel);
    }

    private void addTextFields(){
        field = new JTextField();
        field.setEditable(false);
        field.setBounds(20,20,APP_SIZE[0]-50,60 );
        field.setFont(new Font("Arial", Font.BOLD, 30));
        field.setText(fieldValue);
        field.setHorizontalAlignment(JTextField.RIGHT);
        add(field);
    }

    private void addButtons() {
        for (String[] buttonText : BUTTON_TEXTS) {
            for (String s : buttonText) {
                button = new JButton(s);
                button.addActionListener(this);
                buttonPanel.add(button);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Object o = e.getSource();
            if(o.getClass().equals(JButton.class)){

                String clickedButton = ((JButton)o).getText();

                // digits
                if(clickedButton.matches("[0-9]")){
                    if (fieldValue.equals("0")){
                        fieldValue = clickedButton;
                    }
                    else{
                        fieldValue += clickedButton;
                    }
                }
                // a dot
                else if(clickedButton.matches("[.]")){
                    if(!fieldValue.contains(".")){
                        fieldValue += clickedButton;
                        System.out.println(fieldValue);
                    }

                }
                else if(clickedButton.matches("[+\\-*/]")){
                    String lastSymbol = fieldValue.substring(fieldValue.length()-1);

                    if(lastSymbol.matches("[0-9]")){
                        fieldValue += clickedButton;
                    }
                    else if(lastSymbol.matches("[+\\-*/]")){
                        String newString = fieldValue.substring(0,fieldValue.length()-1);
                        fieldValue = newString + clickedButton.charAt(0);
                    }
                }
                else if (clickedButton.matches("=")){

                }
                field.setText(fieldValue);
            }
        }
        catch (Exception exception){
            System.out.println("Something went terribly wrong!");
        }

    }

}
