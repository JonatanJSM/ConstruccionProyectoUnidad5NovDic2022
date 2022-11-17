package proyectojson;

import Utils.Employee;
import Utils.JSONToObjectConverter;
import Utils.NullEmployee;
import Utils.ValidarLectura;
import org.json.simple.JSONObject;
import vista.vistaPrincipal;

import java.util.ArrayList;

/**
 *
 * @author jonat
 */
public class ProyectoJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        vistaPrincipal VistaPrincipal = new vistaPrincipal();
        VistaPrincipal.setVisible(true);
        //PRUEBAS EN EL MAIN, se puede omitir
        ValidarLectura v = new ValidarLectura();
        v.readJSON("json2.txt");
        JSONObject employeeObject = v.extractJSONObjectbyKey("employees");
        v.extractEmployeeJSONArray(employeeObject, "employee");
        JSONToObjectConverter converter = new JSONToObjectConverter();
        converter.convertJSONtoArray(v.getArrayJSONobject());
        System.out.println("----------------------------");
        ArrayList<Employee> arrayEmps = new ArrayList<Employee>();
        arrayEmps = converter.getArrayEmployee();

        for (Employee emp : arrayEmps)
        {
            System.out.println(emp.toString());
        }
    }
    
}
