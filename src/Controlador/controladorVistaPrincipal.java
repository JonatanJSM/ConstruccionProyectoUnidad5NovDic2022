package Controlador;

import Utils.Employee;
import vista.pantallaAgregar;
import vista.pantallaModificar;
import vista.vistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class controladorVistaPrincipal implements ActionListener, MouseListener {
    private vistaPrincipal vistaprincipal;
    private ArrayList<Employee> employees;

    private pantallaModificar vistaModificar = new pantallaModificar();
    private final ControladorVistaModificar controladorModificar = new ControladorVistaModificar(vistaModificar);

    private pantallaAgregar vistaAgregar = new pantallaAgregar();
    private final ControlVistaAgregar controlVistaAgregar = new ControlVistaAgregar(vistaAgregar);

    public controladorVistaPrincipal(vistaPrincipal vistaprincipal, ArrayList<Employee> employeeIterator) {
        this.vistaprincipal = vistaprincipal;
        this.employees = employeeIterator;
        //jButton1 es el botón para agregar empleado
        this.vistaprincipal.getjButton1().addActionListener(this);
        this.vistaprincipal.getjTable1().addMouseListener((MouseListener) this);

        this.controladorModificar.getVistaModificar().getRegresarButton().addActionListener(this);
        this.controlVistaAgregar.getVistaAgregar().getRegresarButton().addActionListener(this);
        showEmployeesTable();
    }

    public controladorVistaPrincipal(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaprincipal.getjButton1()){
            this.controlVistaAgregar.setEmployees(employees);
            this.controlVistaAgregar.getVistaAgregar().setVisible(true);
        }

        if(e.getSource() == this.controlVistaAgregar.getBotonRegrear()){
            if(controlVistaAgregar.getAggregated()){
                employees = controlVistaAgregar.getEmployees();
                this.vistaprincipal.getTablaModelo1().setRowCount(0);
                showEmployeesTable();
            }
            controlVistaAgregar.setAggregated(false);

        }

        if(e.getSource() == this.controladorModificar.getBotonRegrear()){
            if(controladorModificar.getUpdated()){
                employees = controladorModificar.getEmployees();
                this.vistaprincipal.getTablaModelo1().setRowCount(0);
                showEmployeesTable();
            }
            controladorModificar.setUpdated(false);
            if(controladorModificar.getDeleted()){
                employees = controladorModificar.getEmployees();
                this.vistaprincipal.getTablaModelo1().setRowCount(0);
                showEmployeesTable();
            }
            controladorModificar.setDeleted(false);
        }

    }

    public void mouseClicked(MouseEvent e){
        if(e.getClickCount() ==2 ){
            String aux =  vistaprincipal.getjTable1().getValueAt(vistaprincipal.getjTable1().getSelectedRow(),0).toString();
            controladorModificar.getVistaModificar().getTextField1().setText(aux);
            controladorModificar.getVistaModificar().getTextField2().setText((String) vistaprincipal.getjTable1().getValueAt(vistaprincipal.getjTable1().getSelectedRow(),1));
            controladorModificar.getVistaModificar().getTextField3().setText("");
            controladorModificar.getVistaModificar().getTextField4().setText((String) vistaprincipal.getjTable1().getValueAt(vistaprincipal.getjTable1().getSelectedRow(),2));
            controladorModificar.setEmployees(employees);
            controladorModificar.getVistaModificar().setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void showEmployeesTable(){
        for(Employee employee : employees){
            this.vistaprincipal.getTablaModelo1().addRow(employee.getEmployeeObjectArray());
        }
    }
}
