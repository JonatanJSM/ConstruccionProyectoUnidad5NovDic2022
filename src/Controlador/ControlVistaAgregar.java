package Controlador;

import Utils.Employee;
import vista.pantallaAgregar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ControlVistaAgregar implements ActionListener {
    private pantallaAgregar vistaAgregar;
    private ArrayList<Employee> employees;
    private boolean aggregated = false;
    private int indexToAdd;
    private String[] valuesToAdd = new String[4];

    public ControlVistaAgregar(pantallaAgregar vistaAgregar){
        this.vistaAgregar = vistaAgregar;
        this.vistaAgregar.getGuardarButton().addActionListener(this);
        this.vistaAgregar.getRegresarButton().addActionListener(this);
    }

    public ControlVistaAgregar(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaAgregar.getGuardarButton()){
            storeNewValue();

            addNewEmployess();
        }

        if(e.getSource() == this.vistaAgregar.getRegresarButton()){
            this.vistaAgregar.dispose();
            System.gc();
        }
    }

    public void addNewEmployess(){
        try{
            indexToAdd = Integer.parseInt(this.vistaAgregar.getTextField3().getText());
        }catch (NumberFormatException e){
            indexToAdd = -1;
        }
        aggregated = true;
        if(indexToAdd >= 0){
            for (Employee employee : employees) {
                if (employee.getId() == indexToAdd) {
                    aggregated = false;
                    break;
                }
            }
        }
        validateEmpytData();
        if(aggregated){
            String firstName = this.vistaAgregar.getTextField2().getText();
            if(indexToAdd >= 0){
                for (Employee employee : employees) {
                    if (Objects.equals(employee.getFirstName(), firstName)) {
                        aggregated = false;
                        break;
                    }
                }
            }
            if (aggregated){
                employees.add(new Employee(indexToAdd,valuesToAdd[1],valuesToAdd[2],valuesToAdd[3]));
            }
        }
        if(aggregated && indexToAdd >= 0){
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha agregado el empleado",
                    "Add Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo agregar el empleado con id " + indexToAdd,
                    "Add Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void storeNewValue(){
        valuesToAdd[0] = this.vistaAgregar.getTextField3().getText();
        valuesToAdd[1] = this.vistaAgregar.getTextField2().getText();
        valuesToAdd[2] = this.vistaAgregar.getTextField1().getText();
        valuesToAdd[3] = this.vistaAgregar.getTextField4().getText();
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void validateEmpytData(){
        if(Objects.equals(valuesToAdd[1], "") || Objects.equals(valuesToAdd[2], "") || Objects.equals(valuesToAdd[3], "")){
            aggregated = false;
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setAggregated(boolean aggregated){
        this.aggregated = aggregated;
    }

    public boolean getAggregated(){
        return this.aggregated;
    }

    public JButton getBotonRegrear(){
        return this.vistaAgregar.getRegresarButton();
    }

    public pantallaAgregar getVistaAgregar(){
        return this.vistaAgregar;
    }
}
