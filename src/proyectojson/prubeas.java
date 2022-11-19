package proyectojson;

import Controlador.controladorVistaPrincipal;
import Utils.JSONToObjectConverter;
import Utils.ValidarLectura;
import Utils.modificadorEmployee;
import vista.vistaPrincipal;

public class prubeas {
    public static void main(String[] args) {
        modificadorEmployee modi = new modificadorEmployee();

        ValidarLectura v = new ValidarLectura("json2.txt");
        JSONToObjectConverter converter = new JSONToObjectConverter();

        System.out.println("El arreglo antes   : "+ v.getJsonObject());
        modi.modi(v.getArrayJSONobject());
        System.out.println("El arreglo final es: "+ v.getJsonObject());

    }
}
