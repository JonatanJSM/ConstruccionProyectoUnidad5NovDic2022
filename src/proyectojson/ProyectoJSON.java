package proyectojson;

import Controlador.controladorVistaPrincipal;
import Utils.JSONToObjectConverter;
import Utils.ValidarLectura;
import vista.vistaPrincipal;

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
    }
}
