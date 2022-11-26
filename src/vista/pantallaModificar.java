package vista;

import javax.swing.*;

public class pantallaModificar extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JButton regresarButton;
    private JButton modificarButton;
    private JTextField textField3;
    private JButton eliminarButton;

    public pantallaModificar(){
        setContentPane(panel1);
        setTitle("Modificando employee");
        setSize(650,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setVisible(true);
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

    public JButton getRegresarButton(){
        return regresarButton;
    }

    public JButton getmodificarButton(){
        return modificarButton;
    }

}
