package Utils;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class employeeInsertTest {
    private static ValidarLectura validacionJSON;
    private static employeeModifier employeeModifier;
    private String path = "json2.txt";

    @BeforeEach
    void setUp() {
        validacionJSON = new ValidarLectura();
        validacionJSON.readJSON(path);
        employeeModifier = new employeeModifier();
    }

    @Test
    @DisplayName("No es correcto el formato del ID")
    public void IdEmployee(){
        String camposAInsertar[] = {"idUno","nuevo","employee","123"};
        boolean result = employeeModifier.insertEmployee(camposAInsertar);
        assertTrue(result);
    }

    @Test
    @DisplayName("Algún campo no tiene valor")
    public void fieldsEmployee(){
        String camposAInsertar[] = {"3","nuevo","","123"};
        boolean result = employeeModifier.insertEmployee(camposAInsertar);
        assertTrue(result);
    }

    @Test
    @DisplayName("No se agregó empleado en el JSON")
    public void testLongitudArray(){
        int longitudAntes, longitudDespues;
        longitudAntes = employeeModifier.getArrayJSONobject().size();
        String camposAInsertar[] = {"id","Hortensia","Gutierrez","https://i.pinimg.com/originals/f0/74/dc/f074dc9f568075e9b025c683c6599760.png"};
        employeeModifier.insertEmployee(camposAInsertar);
        longitudDespues = employeeModifier.getArrayJSONobject().size();
        //System.out.println("LONGITUD_ANTES_ " + longitudAntes + " LONGITUD_DESPUES " + longitudDespues);
        assertTrue(longitudAntes+1 == longitudDespues);
    }

}