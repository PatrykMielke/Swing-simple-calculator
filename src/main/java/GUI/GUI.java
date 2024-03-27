package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ConstantValues.ConstantValues.*;

public class GUI extends JFrame implements ActionListener {

    JButton button;
    JPanel buttonPanel;
    public GUI() {
        // Użycie kontruktora klasy nadrzędnej

        super("Simple Calculator");
        setSize(APP_SIZE[0], APP_SIZE[1]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        addPanels();
        addLabels();
        addButtons();
    }

    private void addPanels() {
        buttonPanel = new JPanel();
        buttonPanel.setBounds(10, 190, 380, 400);
        buttonPanel.setSize(380,400);
        buttonPanel.setBackground(Color.red);
        buttonPanel.setLayout(new GridLayout(4,4));

        add(buttonPanel);
    }

    private void addLabels() {
    }

    private void addButtons() {
        for (int i = 0; i < 12; i++) {
            button = new JButton( Integer.toString(i) );

            buttonPanel.add(button);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("test");
        }
    }
}
