package proyectojson;

import Controlador.controladorVistaPrincipal;
import Utils.Employee;
import Utils.JSONToObjectConverter;
import Utils.NullEmployee;
import Utils.ValidarLectura;
import org.json.simple.JSONObject;
import vista.pantallaModificar;
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
        ValidarLectura v = new ValidarLectura("json2.txt");
        JSONToObjectConverter converter = new JSONToObjectConverter();
        converter.convertJSONtoArray(v.getArrayJSONobject());

        vistaPrincipal VistaPrincipal = new vistaPrincipal();
        controladorVistaPrincipal control = new controladorVistaPrincipal(VistaPrincipal, converter.getArrayEmployee());

        VistaPrincipal.setVisible(true);

        //pantallaModificar pantalla = new pantallaModificar();
        //pantalla.setVisible(true);

    }
    
}
