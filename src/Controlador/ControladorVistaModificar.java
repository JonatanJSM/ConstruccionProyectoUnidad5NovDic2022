package Controlador;

import Utils.Employee;
import Utils.employeeModifier;
import vista.pantallaModificar;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorVistaModificar implements ActionListener {
    private pantallaModificar vistaModificar;
    private String[] valuesToUpdate = new String[4];
    private ArrayList<Employee> employees;
    private boolean updated = false;
    private boolean deleted = false;

    private int indexToDelete;
    public ControladorVistaModificar(pantallaModificar vistaModificar){
        this.vistaModificar = vistaModificar;
        this.vistaModificar.getRegresarButton().addActionListener(this);
        this.vistaModificar.getmodificarButton().addActionListener(this);
        this.vistaModificar.getEliminarButton().addActionListener(this);
    }

    public ControladorVistaModificar(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaModificar.getmodificarButton()){
            storeUpdateValues();
            employeeModifier modifierEmployee = new employeeModifier();
            modifierEmployee.modifyEmployee(valuesToUpdate);
            updateEmployees();
        }

        if(e.getSource() == this.vistaModificar.getRegresarButton()){
            this.vistaModificar.dispose();
            System.gc();
        }

        if(e.getSource() == this.vistaModificar.getEliminarButton()){
            deleteEmployee();
            if(deleted){
                employeeModifier modifierEmployee = new employeeModifier();
                modifierEmployee.detelteEmployee(indexToDelete);
            }
        }
    }

    public void deleteEmployee(){
        try{
            indexToDelete = Integer.parseInt(this.vistaModificar.getTextField1().getText());
        }catch (NumberFormatException e){
            indexToDelete = -1;
        }
        deleted = false;
        if(indexToDelete >= 0){
            for(int i = 0 ; i < employees.size() ; i++){
                if (employees.get(i).getId() ==  indexToDelete) {
                    employees.remove(i);
                    deleted = true;
                    break;
                }
            }
        }
        if(deleted){
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha eliminado el empleado con id " + indexToDelete,
                    "Delete Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "No se pudo eliminar el empleado con id " + indexToDelete,
                    "Delete Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void storeUpdateValues(){
        valuesToUpdate[0] = this.vistaModificar.getTextField1().getText();
        valuesToUpdate[1] = this.vistaModificar.getTextField2().getText();
        valuesToUpdate[2] = this.vistaModificar.getTextField4().getText();
        valuesToUpdate[3] = this.vistaModificar.getTextField3().getText();

    }

    public void updateEmployees(){
        int indexToUpdate;
        boolean nullValuesToUpdate = false;
        boolean updatedEmployee = false;
        try{
            indexToUpdate = Integer.parseInt(valuesToUpdate[0]);
        }catch (NumberFormatException ex){
            indexToUpdate = 0;
        }
        if((indexToUpdate > 0 )){
            for(Employee emp : employees){
                if(emp.getId() == Integer.parseInt(valuesToUpdate[0])){
                    try{
                        if(!valuesToUpdate[1].equals("")){
                            emp.setFirstName(valuesToUpdate[1]);
                        }
                        if(!valuesToUpdate[2].equals("")){
                            emp.setLastName(valuesToUpdate[2]);
                        }
                        if(!valuesToUpdate[3].equals("")){
                            emp.setPhoto(valuesToUpdate[3]);
                        }
                        setUpdated(true);
                        updatedEmployee = true;
                    }catch (NullPointerException e){
                        updatedEmployee = false;
                    }
                }
            }

        }
        if(updatedEmployee){
            JOptionPane.showMessageDialog(
                    null,
                    "Se ha modificado el empleado con id " + valuesToUpdate[0],
                    "Update Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(
                    null,
                    "No se modificó algún empleado",
                    "Update Employee",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public pantallaModificar getVistaModificar() {
        return vistaModificar;
    }


    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public boolean getUpdated() {
        return updated;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setIndexToDelete(int indexToDelete) {
        this.indexToDelete = indexToDelete;
    }

    public int getIndexToDelete() {
        return indexToDelete;
    }

    public String[] getValuesToUpdate() {
        return valuesToUpdate;
    }

    public JButton getBotonRegrear(){
        return this.vistaModificar.getRegresarButton();
    }
}
