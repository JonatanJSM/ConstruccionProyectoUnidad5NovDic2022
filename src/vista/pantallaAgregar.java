package vista;

import javax.swing.*;

public class pantallaAgregar extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton regresarButton;
    private JButton guardarButton;
    private JPanel jpanel1;

    public pantallaAgregar(){
        setContentPane(jpanel1);
        setTitle("Agregando employee");
        setSize(650,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public JTextField getTextField1(){
        return textField1;
    }

    public JTextField getTextField2(){
        return textField2;
    }

    public JTextField getTextField3(){
        return textField3;
    }

    public JTextField getTextField4(){
        return textField4;
    }

    public JButton getGuardarButton() {
        return guardarButton;
    }

    public JButton getRegresarButton() {
        return regresarButton;
    }
}
