package proyectojson;

import Utils.JSONToObjectConverter;
import Utils.ValidarLectura;
import Utils.employeeModifier;

public class prubeas {
    public static void main(String[] args) {
        employeeModifier modi = new employeeModifier();
        String[] modificador = {"0","","Pedro","hola"};

        ValidarLectura v = new ValidarLectura("json2.txt");
        JSONToObjectConverter converter = new JSONToObjectConverter();

        System.out.println("El arreglo antes   : "+ v.getJsonObject());
        modi.modifyEmployee(v.getArrayJSONobject(),modificador);
        System.out.println("El arreglo final es: "+ v.getJsonObject());

    }
}
