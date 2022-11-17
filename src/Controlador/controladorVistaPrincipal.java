package Controlador;

import Utils.Employee;
import vista.vistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class controladorVistaPrincipal implements ActionListener {
    private vistaPrincipal vistaprincipal;
    private Iterator<Employee> employeeIterator;

    public controladorVistaPrincipal(vistaPrincipal vistaprincipal, Iterator<Employee> employeeIterator) {
        this.vistaprincipal = vistaprincipal;
        this.employeeIterator = employeeIterator;
        showEmployeesTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void showEmployeesTable(){
        while(employeeIterator.hasNext()){
            this.vistaprincipal.getTablaModelo1().addRow(employeeIterator.next().getEmployeeObjectArray());
        }
    }
}
