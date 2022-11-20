package Controlador;

import Utils.Employee;
import vista.pantallaModificar;
import vista.vistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class controladorVistaPrincipal implements ActionListener {
    private vistaPrincipal vistaprincipal;
    private ArrayList<Employee> employees;

    private pantallaModificar vistaModificar = new pantallaModificar();
    private final ControladorVistaModificar controladorModificar = new ControladorVistaModificar(vistaModificar);

    public controladorVistaPrincipal(vistaPrincipal vistaprincipal, ArrayList<Employee> employeeIterator) {
        this.vistaprincipal = vistaprincipal;
        this.employees = employeeIterator;
        this.vistaprincipal.getjButton1().addActionListener(this);
        this.vistaprincipal.getjButton2().addActionListener(this);
        this.vistaprincipal.getjButton3().addActionListener(this);

        this.controladorModificar.getVistaModificar().getRegresarButton().addActionListener(this);
        showEmployeesTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaprincipal.getjButton3()){
            controladorModificar.getVistaModificar().getTextField1().setText("");
            controladorModificar.getVistaModificar().getTextField2().setText("");
            controladorModificar.getVistaModificar().getTextField3().setText("");
            controladorModificar.getVistaModificar().getTextField4().setText("");
            controladorModificar.setEmployees(employees);
            controladorModificar.getVistaModificar().setVisible(true);

        }
        if(e.getSource() == this.controladorModificar.getVistaModificar().getRegresarButton()){
            if(controladorModificar.getUpdated()){
                employees = controladorModificar.getEmployees();
                this.vistaprincipal.getTablaModelo1().setRowCount(0);
                showEmployeesTable();
                /*
                String[] modificaciones = controladorModificar.getValuesToUpdate();
                for (String modificacione : modificaciones) {
                    System.out.println(modificacione);
                }
                */
            }
            controladorModificar.setUpdated(false);
        }
    }

    public void showEmployeesTable(){
        for(Employee employee : employees){
            this.vistaprincipal.getTablaModelo1().addRow(employee.getEmployeeObjectArray());
        }
    }
}
